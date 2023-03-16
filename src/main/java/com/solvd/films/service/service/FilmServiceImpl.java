package com.solvd.films.service.service;

import com.solvd.films.domain.Film;
import com.solvd.films.domain.exception.ResourceDoesNotExistException;
import com.solvd.films.repository.FilmRepository;
import com.solvd.films.service.FilmService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class FilmServiceImpl implements FilmService {

    private final FilmRepository filmRepository;

    @Override
    public Mono<Film> create(Film film) {
        return filmRepository.save(film);
    }

    @Override
    public Flux<Film> findAll() {
        return filmRepository.findAll();
    }

    @Override
    public Mono<Film> findById(Long id) {
        return Mono.just(id)
                .flatMap(filmRepository::findById)
                .switchIfEmpty(Mono.error(new ResourceDoesNotExistException("There are no film with id " + id)));
    }

    @Override
    public Mono<Film> update(Long id, Integer amount) {
        return  findById(id)
                .map(filmUpdated -> {
                        filmUpdated.setPlaces(filmUpdated.getPlaces() - amount);
                        return filmUpdated;
                }).flatMap(filmRepository::save);
    }

    @Override
    public Mono<Film> updateStatus(Long id) {
        return  findById(id)
                .map(filmUpdated -> {
                        filmUpdated.setIsSold(true);
                        return filmUpdated;
                }).flatMap(filmRepository::save);
    }

    @Override
    public Mono<Integer> getFreePlacesById(Long id) {
        return findById(id)
                .flatMap(film -> Mono.just(film.getPlaces()));
    }

}
