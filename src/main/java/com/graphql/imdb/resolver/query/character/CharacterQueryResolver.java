package com.graphql.imdb.resolver.query.character;

import com.google.common.collect.Lists;
import com.graphql.imdb.entity.CharacterEntity;
import com.graphql.imdb.mapper.CharacterMapper;
import com.graphql.imdb.model.CharacterResponse;
import com.graphql.imdb.repository.CharacterRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CharacterQueryResolver implements GraphQLQueryResolver {

    private final CharacterRepository characterRepository;
    private final CharacterMapper characterMapper;

    public List<CharacterResponse> getCharacters(Integer movieId) {
        List<CharacterEntity> characterEntities = Lists.newArrayList(characterRepository.findByMovieId(movieId));
        return characterEntities.stream().map(characterMapper::map).collect(Collectors.toList());
    }

}
