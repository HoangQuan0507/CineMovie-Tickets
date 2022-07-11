package com.project.movietickets.repository;

import com.project.movietickets.entity.RoomMovieScheduleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomMovieScheduleRepository extends JpaRepository<RoomMovieScheduleEntity, Integer> {
    //List<RoomMovieScheduleEntity> findRoomMovieScheduleEntitiesByMovie_Id(int movieId);

    @Query(value = "select room_movie_schedules.*\n" +
            "from room_movie_schedules\n" +
            "inner join schedules\n" +
            "on room_movie_schedules.schedule_id = schedules.id\n" +
            "inner join rooms\n" +
            "on room_movie_schedules.room_id = rooms.id\n" +
            "inner join cinemas\n" +
            "on rooms.cinema_id = cinemas.id\n" +
            "inner join citys\n" +
            "on cinemas.city_id = citys.id\n" +
            "where movie_id = :movieId and citys.id = :cityId and date(schedules.time) = :localDate", nativeQuery = true)
    List<RoomMovieScheduleEntity> findAllByCityAndMovieAndDate(
            @Param("movieId") int movieId,
            @Param("cityId") int cityId,
            @Param("localDate") String localDate
    );
}
