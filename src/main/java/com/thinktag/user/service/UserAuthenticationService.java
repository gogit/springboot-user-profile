package com.thinktag.user.service;

import com.thinktag.user.model.User;

import java.util.Optional;

public interface UserAuthenticationService {

    /**
     * Finds a user by issued token
     *
     * @param token JWT
     * @return
     */
    Optional<User> findByToken(String token);

}
