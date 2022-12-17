package com.example.appjamserver.global.filter;

import com.example.appjamserver.global.error.CustomException;
import com.example.appjamserver.global.error.ErrorCode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@RequiredArgsConstructor
public class ErrorFilter extends OncePerRequestFilter {

    private final ObjectMapper objectMapper;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws IOException {
        try {
            filterChain.doFilter(request, response);
        } catch (CustomException e) {
            setErrorResponse(e.getErrorCode(), response);
        } catch (Exception e) {
            if (e.getCause() instanceof CustomException exception) {
                setErrorResponse(exception.getErrorCode(), response);
            } else {
                e.printStackTrace();
                setErrorResponse(ErrorCode.INTERNAL_SERVER_ERROR, response);
            }
        }
    }

    private void setErrorResponse(ErrorCode errorCode, HttpServletResponse response) throws IOException {
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setCharacterEncoding(StandardCharsets.UTF_8.name());
        response.getWriter().write(objectMapper.writeValueAsString(errorCode));
    }

}
