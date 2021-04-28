package com.graphql.imdb.service;

import com.graphql.imdb.entity.CharacterEntity;
import com.graphql.imdb.mapper.CharacterMapper;
import com.graphql.imdb.model.CharacterResponse;
import com.graphql.imdb.model.MovieResponse;
import com.graphql.imdb.repository.CharacterRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@Component
@RequiredArgsConstructor
public class CharacterQueryService {

    private final CharacterRepository characterRepository;
    private final CharacterMapper characterMapper;

    public Map<Integer, List<CharacterResponse>> getCharacters(Set<Integer> movieIdList) {
        log.info("Retrieving characters of movieIds : {}", movieIdList);
        List<CharacterEntity> byMovieId = characterRepository.findByMovieIdList(new ArrayList<>(movieIdList));
        return byMovieId.stream().map(characterMapper::map).collect(Collectors.groupingBy(CharacterResponse::getMovieId));
    }

    public List<CharacterResponse> characters(Integer movieId) {
        List<CharacterEntity> byMovieId = characterRepository.findByMovieId(movieId);
        return byMovieId.stream().map(characterMapper::map).collect(Collectors.toList());
    }

}
