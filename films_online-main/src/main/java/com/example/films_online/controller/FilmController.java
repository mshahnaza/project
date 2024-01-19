package com.example.films_online.controller;

import com.example.films_online.dto.film.FilmAddRequest;
import com.example.films_online.dto.film.FilmResponse;
import com.example.films_online.service.FilmService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/film")
@AllArgsConstructor
public class FilmController {
    private FilmService filmService;

    @PostMapping("/add")
    public void addFilm(@RequestBody FilmAddRequest request, @RequestHeader("Authorization") String token){
        filmService.addFilm(request, token);
    }
    @GetMapping("/films")
    public List<FilmResponse> filmResponses(@RequestHeader("Authorization") String string){
        return filmService.getAll(string);
    }


    @PostMapping("/buy/{filmId}")
    public void buy(@PathVariable Long filmId, @RequestHeader("Authorization") String token){
        filmService.buy(filmId, token);
    }
    @GetMapping("/my/films")
    public List<FilmResponse> myFilms(@RequestHeader("Authorization") String string){
        return filmService.getMyFilms(string);
    }
}
