package com.project.movietickets.repository;

import com.project.movietickets.entity.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<MovieEntity, Integer> {
    @Query(value = "select movies.* from movies order by view desc, name asc limit 4;", nativeQuery = true)
    List<MovieEntity> getListMovieViewHighest();

    @Query(value = "select movies.* from movies order by premiere desc, name asc limit 4;", nativeQuery = true)
    List<MovieEntity> getTopNewMovieLastest();
}
