package com.example.appjamserver.domain.refresh_token.repository;

import com.example.appjamserver.domain.refresh_token.RefreshToken;
import org.springframework.data.repository.CrudRepository;

public interface RefreshTokenRepository extends CrudRepository<RefreshToken, String> {
}
