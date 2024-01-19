package com.example.films_online.mapper;

import com.example.films_online.dto.film.FilmResponse;
import com.example.films_online.entities.Film;

import java.util.List;

public interface FilmMapper {
    List<FilmResponse> toDtoS(List<Film> all);

    FilmResponse toDto(Film film);
}
