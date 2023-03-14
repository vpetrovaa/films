package com.solvd.films.service;

import com.solvd.films.domain.Film;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface FilmService {

    Mono<Film> create(Film film);

    Flux<Film> findAll();

    Mono<Film> findById(Long id);

    Mono<Film> update(Long id, Integer amount);

    Mono<Integer> getFreePlacesById(Long id);

}
