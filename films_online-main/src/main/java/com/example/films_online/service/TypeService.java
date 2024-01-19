package com.example.films_online.service;

import com.example.films_online.dto.type.TypeResponse;

import java.util.List;

public interface TypeService {
    void addType(String name, String token);

    List<TypeResponse> getAll();
}
