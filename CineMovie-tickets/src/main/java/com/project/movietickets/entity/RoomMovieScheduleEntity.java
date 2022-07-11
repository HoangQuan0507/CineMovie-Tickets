package com.project.movietickets.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity(name = "room_movie_schedules")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoomMovieScheduleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(insertable = false)
    private int id;

    @ManyToOne
    @JoinColumn
    private RoomEntity room;

    @ManyToOne
    @JoinColumn
    private MovieEntity movie;

    @ManyToOne
    @JoinColumn
    private ScheduleEntity schedule;

    @OneToMany(mappedBy = "roomMovieSchedule", cascade = CascadeType.ALL)
    private List<TicketEntity> tickets;
}
