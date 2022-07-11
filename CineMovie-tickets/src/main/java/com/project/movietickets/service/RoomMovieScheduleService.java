package com.project.movietickets.service;

import com.project.movietickets.entity.RoomMovieScheduleEntity;
import com.project.movietickets.entity.ScheduleEntity;
import com.project.movietickets.repository.MovieRepository;
import com.project.movietickets.repository.RoomMovieScheduleRepository;
import com.project.movietickets.repository.RoomRepository;
import com.project.movietickets.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomMovieScheduleService {

    private final RoomMovieScheduleRepository roomMovieScheduleRepository;

    private final RoomRepository roomRepository;

    private final MovieRepository movieRepository;

    private final ScheduleRepository scheduleRepository;

    public List<RoomMovieScheduleEntity> getAllSchedule() {
        return roomMovieScheduleRepository.findAll();
    }

    @Transactional
    public RoomMovieScheduleEntity createRoomMovieSchedule(int roomId, int movieId, String time) {
        var localDateTime = LocalDateTime.parse(time);
        var room = roomRepository.getOne(roomId);
        var movie = movieRepository.getOne(movieId);
        var schedule = scheduleRepository.save(
                ScheduleEntity.builder()
                        .time(localDateTime)
                        .build()
        );

        var roomMovieSchedule = RoomMovieScheduleEntity.builder()
                .room(room)
                .schedule(schedule)
                .movie(movie)
                .build();

        return roomMovieScheduleRepository.save(roomMovieSchedule);
    }

    @Transactional
    public void delete(int id) {
        roomMovieScheduleRepository.deleteById(id);

        assert roomMovieScheduleRepository.findById(id).isEmpty() : new RuntimeException("Cannot delete");
    }

    public RoomMovieScheduleEntity findById(int id) {
        return roomMovieScheduleRepository.getOne(id);
    }

    @Transactional
    public RoomMovieScheduleEntity updateRoomMovieSchedule(int id, int roomId, int movieId, String time) {
        var localDateTime = LocalDateTime.parse(time);
        var room = roomRepository.getOne(roomId);
        var movie = movieRepository.getOne(movieId);
        var schedule = scheduleRepository.save(
                ScheduleEntity.builder()
                        .time(localDateTime)
                        .build()
        );
        var roomMovieSchedule = roomMovieScheduleRepository.getOne(id);

        roomMovieSchedule.setRoom(room);
        roomMovieSchedule.setMovie(movie);
        roomMovieSchedule.setSchedule(schedule);

        return roomMovieScheduleRepository.save(roomMovieSchedule);
    }
}
