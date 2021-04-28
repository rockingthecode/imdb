package com.graphql.imdb.mapper;

import com.graphql.imdb.entity.CharacterEntity;
import com.graphql.imdb.model.CharacterResponse;
import com.graphql.imdb.model.input.CharacterRequest;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface CharacterMapper {

    CharacterEntity map(CharacterRequest characterRequest);

    CharacterResponse map(CharacterEntity characterEntity);
}
