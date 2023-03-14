package com.solvd.films.web.mapper;

import com.solvd.films.domain.Film;
import com.solvd.films.web.dto.FilmDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FilmMapper {

    FilmDto entityToDto(Film film);

    Film dtoToEntity(FilmDto filmDto);

}
