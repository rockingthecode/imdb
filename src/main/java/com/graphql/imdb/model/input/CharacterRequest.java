package com.graphql.imdb.model.input;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CharacterRequest {
    private Integer id;
    private Integer movieId;
    private String characterName;
}
