package com.project.movietickets.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "tickets")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TicketEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(insertable = false)
    private int id;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private String code;

    private boolean isPay = false;

    private boolean isReceived = false;

    private int amount;

    @ManyToOne
    @JoinColumn
    private RoomMovieScheduleEntity roomMovieSchedule;

    @ManyToOne
    @JoinColumn
    private RoomChairEntity roomChair;

    @ManyToOne
    @JoinColumn
    private UserEntity user;
}
