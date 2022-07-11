package com.project.movietickets.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Entity(name = "schedules")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ScheduleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(insertable = false)
    private int id;

    @Basic
    private LocalDateTime time;

    @OneToMany(mappedBy = "schedule", cascade = CascadeType.ALL)
    private List<RoomMovieScheduleEntity> roomSchedules;
}
