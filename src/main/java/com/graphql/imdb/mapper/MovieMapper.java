package com.graphql.imdb.mapper;

import com.graphql.imdb.entity.MovieEntity;
import com.graphql.imdb.model.MovieResponse;
import com.graphql.imdb.model.input.MovieRequest;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface MovieMapper {

    public MovieEntity map(MovieRequest movieRequest);

    public MovieResponse map(MovieEntity movieRequest);
}
