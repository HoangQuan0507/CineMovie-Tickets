package com.project.movietickets.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity(name = "citys")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CityEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(insertable = false)
    private int id;
    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL)
    private List<CinemaEntity> cinemas;
}
