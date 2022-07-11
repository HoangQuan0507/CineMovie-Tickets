package com.project.movietickets.repository;

import com.project.movietickets.entity.CityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<CityEntity, Integer> {
    @Query(value = "select distinct citys.* from citys\n" +
            "inner join cinemas\n" +
            "on cinemas.city_id = citys.id\n" +
            "inner join rooms\n" +
            "on rooms.cinema_id = cinemas.id\n" +
            "inner join room_movie_schedules\n" +
            "on room_movie_schedules.room_id = rooms.id\n" +
            "where room_movie_schedules.movie_id = :movieId ;", nativeQuery = true)
    List<CityEntity> findListCityByMovieId(@Param("movieId") int movieId);

    CityEntity findFirstByNameNotNull();
}
