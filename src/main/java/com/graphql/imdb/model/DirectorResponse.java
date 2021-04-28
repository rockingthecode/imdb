package com.graphql.imdb.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class DirectorResponse {

    private Integer id;

    private String firstName;

    private String lastName;

    private List<MovieResponse> movieEntities;

}
