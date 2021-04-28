package com.graphql.imdb.entity;

import com.graphql.imdb.model.Genre;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "MOVIE")
public class MovieEntity {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "TITLE", nullable = false)
    private String title;

    @Column(name = "GENRE", nullable = false)
    @Enumerated(EnumType.STRING)
    private Genre genre;

    @Column(name = "RATING")
    private Float rating;

    @Column(name = "RELEASE_YEAR")
    private Integer releaseYear;

}
