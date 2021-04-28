package com.graphql.imdb.model.input;

import com.graphql.imdb.model.Genre;
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
public class MovieRequest {

    private String title;

    private Genre genre;

    private Float rating;

    private Integer releaseYear;

    private List<String> characters;

}
