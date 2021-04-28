package com.graphql.imdb.context;

import com.graphql.imdb.model.CharacterResponse;
import com.graphql.imdb.service.CharacterQueryService;
import lombok.RequiredArgsConstructor;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@Component
@RequiredArgsConstructor
public class DataLoaderRegistryFactory {

    public static final String CHARACTER_RESPONSE_DATA_LOADER = "CHARACTER_RESPONSE_DATA_LOADER";
    private final static Executor threadPool = Executors.newFixedThreadPool(4);
    private final CharacterQueryService characterQueryService;

    public DataLoaderRegistry create() {
        DataLoaderRegistry registry = new DataLoaderRegistry();
        registry.register(CHARACTER_RESPONSE_DATA_LOADER, createCharacterDataLoader());
        return registry;
    }

    private DataLoader<Integer, List<CharacterResponse>> createCharacterDataLoader() {
        return DataLoader.newMappedDataLoader((Set<Integer> movieIds) -> CompletableFuture.supplyAsync(() ->
                        characterQueryService.getCharacters(movieIds)
                , threadPool));
    }

}
