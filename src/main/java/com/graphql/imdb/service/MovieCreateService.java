package com.graphql.imdb.service;

import com.google.common.collect.Lists;
import com.graphql.imdb.entity.CharacterEntity;
import com.graphql.imdb.entity.MovieEntity;
import com.graphql.imdb.mapper.CharacterMapper;
import com.graphql.imdb.mapper.MovieMapper;
import com.graphql.imdb.model.CharacterResponse;
import com.graphql.imdb.model.MovieResponse;
import com.graphql.imdb.model.input.MovieRequest;
import com.graphql.imdb.repository.CharacterRepository;
import com.graphql.imdb.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MovieCreateService {

    private final MovieRepository movieRepository;
    private final MovieMapper movieMapper;
    private final CharacterRepository characterRepository;
    private final CharacterMapper characterMapper;


    public MovieResponse createMovie(MovieRequest movieRequest) {
        MovieEntity movieEntity = movieMapper.map(movieRequest);
        MovieResponse movieResponse = movieMapper.map(movieRepository.save(movieEntity));
        List<CharacterResponse> characterResponses = createCharacters(movieResponse.getId(), movieRequest.getCharacters());
        movieResponse.setCharacters(characterResponses);
        return movieResponse;
    }

    private List<CharacterResponse> createCharacters(Integer movieId, List<String> characters) {
        List<CharacterEntity> characterEntities = characters.stream()
                .map(name -> {
                    return CharacterEntity.builder().movieId(movieId).characterName(name).build();
                })
                .collect(Collectors.toList());
        return Lists.newArrayList(characterRepository.saveAll(characterEntities)).stream()
                .map(characterMapper::map)
                .collect(Collectors.toList());
    }
}
