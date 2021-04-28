package com.graphql.imdb.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "CHARACTER")
public class CharacterEntity {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "MOVIE_ID", nullable = false)
    private Integer movieId;

    @Column(name = "CHARACTER_NAME", nullable = false)
    private String characterName;

}
