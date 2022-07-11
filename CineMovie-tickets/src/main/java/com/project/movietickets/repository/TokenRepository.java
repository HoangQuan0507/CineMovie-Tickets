package com.project.movietickets.repository;

import com.project.movietickets.entity.TokenEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TokenRepository extends JpaRepository<TokenEntity, Integer> {
    Optional<TokenEntity> findTokenEntityByToken(String token);
}
