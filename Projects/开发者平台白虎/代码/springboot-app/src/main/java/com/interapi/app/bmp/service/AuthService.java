package com.interapi.app.bmp.service;

import org.springframework.security.core.AuthenticationException;

import com.interapi.app.bmp.model.UserTab;

public interface AuthService {
    String login(String username, String password);
    String refresh(String oldToken);
    UserTab register(UserTab userToAdd) throws AuthenticationException;
}
