package com.thinktag.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.thinktag.user.model.User;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import static java.util.Optional.ofNullable;

@Service
public class UserAuthenticationServiceImpl implements UserAuthenticationService {

    @Autowired
    JwtClientAdapter jwtClient;

    @Override
    public Optional<User> findByToken(String token) {
        Map<String, String> claims = jwtClient.validateToken(token);
        if(claims.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(new User(claims.get("username"), claims.get("username"), ""));
    }
}
