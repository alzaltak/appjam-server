package com.example.appjamserver.global.security.auth;

import com.example.appjamserver.domain.user.domain.repository.UserRepository;
import com.example.appjamserver.global.exception.UserNotFound;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByAccountId(username)
                .map(AuthDetails::new)
                .orElseThrow(() -> UserNotFound.EXCEPTION);
    }

}
