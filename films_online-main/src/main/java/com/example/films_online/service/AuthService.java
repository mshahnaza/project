package com.example.films_online.service;

import com.example.films_online.dto.AuthLoginRequest;
import com.example.films_online.dto.AuthLoginResponse;
import com.example.films_online.dto.UserRegisterRequest;
import com.example.films_online.entities.User;

public interface AuthService {
    void register(UserRegisterRequest userRegisterRequest);

    AuthLoginResponse login(AuthLoginRequest authLoginRequest);

    User getUsernameFromToken(String token);
}
