package com.project.movietickets.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity(name = "chairs")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChairEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(insertable = false)
    private int id;

    @Column(length = 2, unique = true, nullable = false)
    private String position;

    @OneToMany(mappedBy = "chair", cascade = CascadeType.ALL)
    private List<RoomChairEntity> roomChairs;
}
