package com.project.movietickets.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity(name = "room_chairs")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoomChairEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(insertable = false)
    private int id;

    @ManyToOne
    @JoinColumn
    private ChairEntity chair;

    @ManyToOne
    @JoinColumn
    private RoomEntity room;

    private boolean status = false;

    @OneToMany(mappedBy = "roomChair", cascade = CascadeType.ALL)
    private List<TicketEntity> tickets;
}
