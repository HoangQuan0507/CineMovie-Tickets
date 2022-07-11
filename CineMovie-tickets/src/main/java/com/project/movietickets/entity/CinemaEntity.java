package com.project.movietickets.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity(name = "cinemas")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CinemaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(insertable = false)
    private int id;
    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn
    private CityEntity city;

    @OneToMany(mappedBy = "cinema", cascade = CascadeType.ALL)
    private List<RoomEntity> rooms;
}
