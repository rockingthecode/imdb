package com.graphql.imdb.resolver.mutation;

import com.graphql.imdb.model.MovieResponse;
import com.graphql.imdb.model.input.MovieRequest;
import com.graphql.imdb.service.MovieCreateService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MovieMutationResolver implements GraphQLMutationResolver {

    private final MovieCreateService movieCreateService;

    public MovieResponse createMovie(MovieRequest movieRequest) {
        return movieCreateService.createMovie(movieRequest);
    }

}
