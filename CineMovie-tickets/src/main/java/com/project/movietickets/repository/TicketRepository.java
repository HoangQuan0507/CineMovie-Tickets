package com.project.movietickets.repository;

import com.project.movietickets.entity.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface TicketRepository extends JpaRepository<TicketEntity, Integer> {
    List<TicketEntity> getAllByDateGreaterThanOrderByDateAsc(LocalDate date);
    List<TicketEntity> findAllByUserUsernameOrderByDateDesc(String username);
    Optional<TicketEntity> findTicketEntityByCode(String code);
    List<TicketEntity> findTicketEntitiesByDate(LocalDate date);
    List<TicketEntity> findTicketEntitiesByRoomMovieSchedule_Id(int id);
}
