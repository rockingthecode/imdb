package com.graphql.imdb.repository;

import com.graphql.imdb.entity.MovieEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends CrudRepository<MovieEntity, Integer> {

    @Query("select m from  MovieEntity m where m.releaseYear > :releaseYear")
    List<MovieEntity> findAfterThisYear(@Param("releaseYear") Integer releaseYear);

}
