package com.example.appjamserver.global.security.jwt;

import com.example.appjamserver.domain.refresh_token.RefreshToken;
import com.example.appjamserver.domain.refresh_token.repository.RefreshTokenRepository;
import com.example.appjamserver.global.exception.ExpiredJwt;
import com.example.appjamserver.global.exception.InvalidJwt;
import com.example.appjamserver.global.security.auth.AuthDetailsService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@RequiredArgsConstructor
@Component
public class JwtTokenProvider {

    private static final String HEADER = "Authorization";
    private static final String PREFIX = "Bearer ";

    private final JwtProperty jwtProperty;
    private final AuthDetailsService authDetailsService;
    private final RefreshTokenRepository refreshTokenRepository;

    public String generateAccessToken(String accountId) {
        return generateToken(accountId, "access", jwtProperty.getAccessExp());
    }

    public String generateRefreshToken(String accountId) {
        String refreshToken = generateToken(accountId, "refresh", jwtProperty.getRefreshExp());
        refreshTokenRepository.save(RefreshToken.builder()
                .accountId(accountId)
                .token(refreshToken)
                .ttl(jwtProperty.getRefreshExp())
                .build());

        return refreshToken;
    }

    private String generateToken(String accountId, String type, Long exp) {
        return Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, jwtProperty.getSecretKey())
                .setSubject(accountId)
                .claim("type", type)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + exp * 1000))
                .compact();
    }

    public String resolveToken(HttpServletRequest request) {
        String bearer = request.getHeader(JwtTokenProvider.HEADER);
        return parseToken(bearer);
    }

    public String parseToken(String bearerToken) {
        if (bearerToken != null && bearerToken.startsWith(JwtTokenProvider.PREFIX)) {
            return bearerToken.replace(JwtTokenProvider.PREFIX, "");
        }
        return null;
    }

    public Authentication authentication(String token) {
        UserDetails userDetails = authDetailsService.loadUserByUsername(getTokenSubject(token));
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }

    private String getTokenSubject(String token) {
        return getTokenBody(token).getSubject();
    }

    private Claims getTokenBody(String token) {
        try {
            return Jwts.parser().setSigningKey(jwtProperty.getSecretKey())
                    .parseClaimsJws(token).getBody();
        } catch (ExpiredJwtException e) {
            throw ExpiredJwt.EXCEPTION;
        } catch (Exception e) {
            throw InvalidJwt.EXCEPTION;
        }
    }

}
