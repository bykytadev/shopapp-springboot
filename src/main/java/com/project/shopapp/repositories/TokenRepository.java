package com.project.shopapp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.shopapp.models.Token;
import com.project.shopapp.models.User;

@Repository
public interface TokenRepository extends JpaRepository<Token, Long> {
    List<Token> findByUser(User user);

    Token findByToken(String token);

    Token findByRefreshToken(String token);
}
