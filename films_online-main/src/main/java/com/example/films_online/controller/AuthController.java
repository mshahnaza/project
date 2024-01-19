package com.example.films_online.controller;

import com.example.films_online.dto.AuthLoginRequest;
import com.example.films_online.dto.AuthLoginResponse;
import com.example.films_online.dto.UserRegisterRequest;
import com.example.films_online.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public void register(@RequestBody UserRegisterRequest userRegisterRequest){
        authService.register(userRegisterRequest);
    }

    @PostMapping("/login")
    public AuthLoginResponse login(AuthLoginRequest authLoginRequest){
        return authService.login(authLoginRequest);
    }

}
