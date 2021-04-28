package com.graphql.imdb.resolver.query.movie;

import com.google.common.collect.Lists;
import com.graphql.imdb.entity.MovieEntity;
import com.graphql.imdb.mapper.MovieMapper;
import com.graphql.imdb.model.MovieResponse;
import com.graphql.imdb.repository.MovieRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class MovieQueryResolver implements GraphQLQueryResolver {

    private final MovieRepository movieRepository;
    private final MovieMapper movieMapper;

    public List<MovieResponse> getMoviesReleasedAfter(Integer releaseYear) {
        ArrayList<MovieEntity> movieEntities = Lists.newArrayList(movieRepository.findAfterThisYear(releaseYear));
        return movieEntities.stream().map(movieMapper::map).collect(Collectors.toList());
    }

}
