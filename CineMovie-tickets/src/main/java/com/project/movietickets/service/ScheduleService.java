package com.project.movietickets.service;

import com.project.movietickets.entity.ScheduleEntity;
import com.project.movietickets.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    public List<ScheduleEntity> getAllSchedule() {
        return scheduleRepository.findAll();
    }
}
