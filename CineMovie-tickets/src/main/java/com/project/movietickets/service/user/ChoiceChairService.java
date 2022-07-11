package com.project.movietickets.service.user;

import com.project.movietickets.entity.RoomChairEntity;
import com.project.movietickets.repository.RoomMovieScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChoiceChairService {

    private final RoomMovieScheduleRepository roomMovieScheduleRepository;

    public List<RoomChairEntity> getAllChairOfSchedule(int scheduleId) {
        var schedule = roomMovieScheduleRepository.findById(scheduleId).get();
        var room = schedule.getRoom();
        var roomChairs = room.getRoomChairs();

        return roomChairs;
    }
}
