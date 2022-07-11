package com.project.movietickets.service.user;

import com.project.movietickets.entity.CinemaEntity;
import com.project.movietickets.entity.RoomMovieScheduleEntity;
import com.project.movietickets.model.custom.Cinema;
import com.project.movietickets.model.custom.Schedule;
import com.project.movietickets.repository.RoomMovieScheduleRepository;
import com.project.movietickets.service.MovieService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Log4j2
public class PurchaseService {
    private final MovieService movieService;
    private final RoomMovieScheduleRepository roomMovieScheduleRepository;

    public List<Cinema> getAllDate(int movieId, int cityId, String localDate) {
        var roomMovieSchedules = roomMovieScheduleRepository.findAllByCityAndMovieAndDate(
                movieId,
                cityId,
                localDate
        );

        // name cinema - list schedule
        Map<String, List<Schedule>> cinemaListScheduleMap = new HashMap<>();

        roomMovieSchedules.forEach( item -> {
            String cinemaName = item.getRoom().getCinema().getName();
            String localTime = item.getSchedule().getTime().toLocalTime().toString();
            int id = item.getId();

            List<Schedule> schedules = null;
            if (cinemaListScheduleMap.containsKey(cinemaName)) {
                schedules = cinemaListScheduleMap.get(cinemaName);
            } else {
                schedules = new ArrayList<>();
            }

            schedules.add(new Schedule(id, localTime));
            cinemaListScheduleMap.put(cinemaName, schedules);
        });

        List<Cinema> cinemas = new ArrayList<>();

        cinemaListScheduleMap.forEach((key, value) -> {
            cinemas.add(new Cinema(key, value));
        });

        log.info(cinemas);

        return cinemas;
    }
}
