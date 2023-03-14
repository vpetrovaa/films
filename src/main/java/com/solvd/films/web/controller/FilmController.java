package com.solvd.films.web.controller;

import com.solvd.films.domain.Film;
import com.solvd.films.service.FilmService;
import com.solvd.films.web.dto.FilmDto;
import com.solvd.films.web.mapper.FilmMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/films")
@RequiredArgsConstructor
public class FilmController {

    private final FilmService filmService;
    private final FilmMapper filmMapper;

    @GetMapping("/{id}")
    public Mono<FilmDto> findById(@PathVariable Long id) {
        Mono<Film> film = filmService.findById(id);
        return film.map(filmMapper::entityToDto);
    }

    @PostMapping
    public Mono<FilmDto> create(@RequestBody @Validated FilmDto filmDto) {
        Film filmMapped = filmMapper.dtoToEntity(filmDto);
        Mono<Film> film = filmService.create(filmMapped);
        return film.map(filmMapper::entityToDto);
    }

    @GetMapping
    public Flux<FilmDto> findAll() {
        Flux<Film> films = filmService.findAll();
        return films.map(filmMapper::entityToDto);
    }

    @PutMapping("/{id}/{amount}")
    public Mono<FilmDto> update(@PathVariable("id") Long id, @PathVariable("amount") Integer amount) {
        Mono<Film> film = filmService.update(id, amount);
        return film.map(filmMapper::entityToDto);
    }

    @GetMapping("/places/{id}")
    public Mono<Integer> findFreePlaces(@PathVariable Long id) {
        return filmService.getFreePlacesById(id);
    }

}
