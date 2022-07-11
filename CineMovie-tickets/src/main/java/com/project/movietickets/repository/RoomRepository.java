package com.project.movietickets.repository;

import com.project.movietickets.entity.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomRepository extends JpaRepository<RoomEntity, Integer> {
    List<RoomEntity> getRoomEntitiesByCinema_IdOrderByName(int id);
}
