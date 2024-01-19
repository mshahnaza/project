package com.example.films_online.repositories;

import com.example.films_online.entities.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FilmRepository extends JpaRepository<Film, Long> {
    Optional<Film> findByTranscript(String tra);
    List<Film> findByAgeAccessGreaterThan(Integer integer);
    List<Film> findAllByAgeAccessLessThan(Integer integer);
}
