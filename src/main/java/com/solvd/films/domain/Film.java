package com.solvd.films.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Table(name = "films")
public class Film {

    @Id
    private Long id;

    private String name;

    private String genre;

    private Integer year;

    private LocalDateTime showingDate;

    private BigDecimal price;

    private Integer places;

    private Boolean isSold;

}
