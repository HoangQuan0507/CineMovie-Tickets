package com.project.movietickets.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity(name = "rooms")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoomEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(insertable = false)
    private int id;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn
    private CinemaEntity cinema;

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<RoomChairEntity> roomChairs;

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
    private List<RoomMovieScheduleEntity> roomMovieSchedules;
}
