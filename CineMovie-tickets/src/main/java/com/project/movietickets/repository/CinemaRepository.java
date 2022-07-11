package com.project.movietickets.repository;

import com.project.movietickets.entity.CinemaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CinemaRepository extends JpaRepository<CinemaEntity, Integer> {
}
