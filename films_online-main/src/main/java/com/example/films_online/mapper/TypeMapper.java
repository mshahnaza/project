package com.example.films_online.mapper;

import com.example.films_online.dto.type.TypeResponse;
import com.example.films_online.entities.Type;

import java.util.List;

public interface TypeMapper {
    List<TypeResponse> toDtoS(List<Type> all);
}
