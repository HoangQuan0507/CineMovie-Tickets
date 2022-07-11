package com.project.movietickets.repository;

import com.project.movietickets.entity.ChairEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChairRepository extends JpaRepository<ChairEntity, Integer> {
}
