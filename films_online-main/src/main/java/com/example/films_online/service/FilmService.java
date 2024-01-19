package com.example.films_online.service;

import com.example.films_online.dto.film.FilmAddRequest;
import com.example.films_online.dto.film.FilmResponse;

import java.util.List;

public interface FilmService {
    void addFilm(FilmAddRequest request, String token);

    List<FilmResponse> getAll(String s);

    void buy(Long filmId, String token);

    List<FilmResponse> getMyFilms(String string);
}
