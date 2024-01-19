package com.example.films_online.mapper.impl;

import com.example.films_online.dto.film.FilmResponse;
import com.example.films_online.entities.Film;
import com.example.films_online.mapper.FilmMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FilmMapperImpl implements FilmMapper {
    @Override
    public List<FilmResponse> toDtoS(List<Film> all) {
        List<FilmResponse> filmResponses = new ArrayList<>();
        for (Film film: all){
            filmResponses.add(toDto(film));
        }
        return filmResponses;
    }

    @Override
    public FilmResponse toDto(Film film) {
        FilmResponse filmResponse = new FilmResponse();
        filmResponse.setId(film.getId());
        filmResponse.setName(film.getName());
        filmResponse.setTranscript(film.getTranscript());
        filmResponse.setAge_access(film.getAgeAccess());
        filmResponse.setPrice(film.getPrice());
        filmResponse.setType(film.getType().getName());
        return filmResponse;
    }
}
