package com.graphql.imdb.resolver.mutation;

import com.graphql.imdb.model.MovieResponse;
import com.graphql.imdb.model.input.MovieRequest;
import com.graphql.imdb.service.MovieCreateService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class BulkMovieMutationResolver implements GraphQLMutationResolver {

    private final MovieCreateService movieCreateService;

    public List<MovieResponse> createBulkMovie(List<MovieRequest> movieRequestList) {
        return movieRequestList.stream().map(movieCreateService::createMovie).collect(Collectors.toList());
    }

}
