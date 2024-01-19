package com.example.films_online.service.impl;

import com.example.films_online.dto.film.FilmAddRequest;
import com.example.films_online.dto.film.FilmResponse;
import com.example.films_online.entities.Film;
import com.example.films_online.entities.Type;
import com.example.films_online.entities.User;
import com.example.films_online.enums.Role;
import com.example.films_online.exception.BadCredentialsException;
import com.example.films_online.exception.NotFoundException;
import com.example.films_online.mapper.FilmMapper;
import com.example.films_online.repositories.FilmRepository;
import com.example.films_online.repositories.TypeRepository;
import com.example.films_online.repositories.UserRepository;
import com.example.films_online.service.AuthService;
import com.example.films_online.service.FilmService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class FilmServiceImpl implements FilmService {
    @Autowired
    private AuthService authService;
    @Autowired
    private TypeRepository typeRepository;
    @Autowired
    private FilmMapper filmMapper;
    @Autowired
    private FilmRepository filmRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public void addFilm(FilmAddRequest request, String token) {
        if (filmRepository.findByTranscript(request.getTranscript()).isPresent())
            throw new NotFoundException("Film with this transcript is already exist!: "+request.getTranscript(),
                    HttpStatus.BAD_REQUEST);
        if (!authService.getUsernameFromToken(token).getRole().equals(Role.ADMIN))
            throw new BadCredentialsException("This function is only for admin!");

        Film film = new Film();

        film.setName(request.getName());
        film.setPrice(request.getPrice());
        film.setAgeAccess(request.getAge_access());
        film.setTranscript(request.getTranscript());
        Optional<Type> type = typeRepository.findByName(request.getType());
        if (type.isEmpty())
            throw new NotFoundException("No type with name: "+request.getType(), HttpStatus.BAD_REQUEST);
        film.setType(type.get());
        filmRepository.save(film);
    }

    @Override
    public List<FilmResponse> getAll(String s) {
        User user = authService.getUsernameFromToken(s);

        if (!user.getRole().equals(Role.ADMIN)){
            System.out.println("the user");
            List<FilmResponse> filmResponses = filmMapper.toDtoS(filmRepository.findAllByAgeAccessLessThan(user.getCustomer().getAge()));
            System.out.println("the size: "+filmResponses.size());
            return filmResponses;
        }
        System.out.println("the admin");

        return filmMapper.toDtoS(filmRepository.findAll());
    }

    @Override
    public void buy(Long filmId, String token) {
        User user = authService.getUsernameFromToken(token);
        Optional<Film> film = filmRepository.findById(filmId);

        List<Film> films = new ArrayList<>();
        if (!user.getCustomer().getFilms().isEmpty())
            films = user.getCustomer().getFilms();
        films.add(film.get());
        user.getCustomer().setFilms(films);
        userRepository.save(user);
    }

    @Override
    public List<FilmResponse> getMyFilms(String string) {
        User user = authService.getUsernameFromToken(string);

        if (!user.getRole().equals(Role.ADMIN)){
            System.out.println("the user");
            List<FilmResponse> filmResponses = filmMapper.toDtoS(user.getCustomer().getFilms());
            System.out.println("the size: "+filmResponses.size());
            return filmResponses;
        }
        return null;
    }
}
