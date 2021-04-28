package com.graphql.imdb.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MovieResponse {

    private Integer id;

    private String title;

    private Genre genre;

    private Float rating;

    private Integer directorId;

    private List<CharacterResponse> characters;

    private Integer releaseYear;

}
