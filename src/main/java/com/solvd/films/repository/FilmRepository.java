package com.solvd.films.repository;

import com.solvd.films.domain.Film;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface FilmRepository extends R2dbcRepository<Film, Long> {
}
