package com.graphql.imdb.resolver.mutation;

import com.graphql.imdb.entity.CharacterEntity;
import com.graphql.imdb.mapper.CharacterMapper;
import com.graphql.imdb.model.CharacterResponse;
import com.graphql.imdb.model.input.CharacterRequest;
import com.graphql.imdb.repository.CharacterRepository;
import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CharacterMutationResolver implements GraphQLMutationResolver {

    private final CharacterRepository characterRepository;

    private final CharacterMapper characterMapper;

    public CharacterResponse createCharacter(CharacterRequest characterRequest) {
        CharacterEntity characterEntity = characterMapper.map(characterRequest);
        return characterMapper.map(characterRepository.save(characterEntity));
    }
}
