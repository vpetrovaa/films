package com.solvd.films.web.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class FilmDto {

    private Long id;

    @Size(min = 3, max = 45, message = "Name must be from 3 to 45 symbols")
    @NotBlank(message = "Name cant be empty")
    private String name;

    @Size(min = 3, max = 45, message = "Genre must be from 3 to 45 symbols")
    @NotBlank(message = "Genre cant be empty")
    private String genre;

    @NotNull(message = "Year cant be null")
    private Integer year;

    @NotNull(message = "Date cant be null")
    private LocalDateTime showingDate;

    @DecimalMin(value = "0.1", message = "Price should be more than 0")
    @Digits(integer = 3, fraction = 2, message = "Format is 0.00")
    @NotNull(message = "Price cant be null")
    private BigDecimal price;

    @NotNull(message = "Places cant be null")
    private Integer places;

}
