package com.graphql.imdb.repository;

import com.graphql.imdb.entity.CharacterEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CharacterRepository extends CrudRepository<CharacterEntity, Integer> {
    List<CharacterEntity> findByMovieId(Integer movieId);

    @Query("select c from  CharacterEntity c where c.movieId in :movieIds")
    List<CharacterEntity> findByMovieIdList(@Param("movieIds") List<Integer> movieIdList);
}
