package com.graphql.imdb.resolver.query.movie;

import com.graphql.imdb.context.DataLoaderRegistryFactory;
import com.graphql.imdb.entity.CharacterEntity;
import com.graphql.imdb.mapper.CharacterMapper;
import com.graphql.imdb.model.CharacterResponse;
import com.graphql.imdb.model.MovieResponse;
import com.graphql.imdb.repository.CharacterRepository;
import com.graphql.imdb.service.CharacterQueryService;
import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dataloader.DataLoader;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Slf4j
@Component
@RequiredArgsConstructor
public class CharacterResolver implements GraphQLResolver<MovieResponse> {

    private final CharacterQueryService characterQueryService;

/*
    public List<CharacterResponse> getCharacters(MovieResponse movieResponse) {
        log.info("Retrieving characters of movie : {}", movieResponse.getTitle());
        return characterQueryService.characters(movieResponse.getId());
    }
*/

    public CompletableFuture<List<CharacterResponse>> getCharacters(MovieResponse movieResponse, DataFetchingEnvironment environment) {
        DataLoader<Integer, List<CharacterResponse>> dataLoader = environment.getDataLoader(DataLoaderRegistryFactory.CHARACTER_RESPONSE_DATA_LOADER);
        return dataLoader.load(movieResponse.getId());
    }

}
