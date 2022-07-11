package com.project.movietickets.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity(name = "movies")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovieEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(insertable = false)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false)
    private String director;

    @Column(nullable = false)
    private String category;

    @Column(nullable = false)
    private LocalDate premiere;

    @Column(nullable = false)
    private int time;

    @Column(nullable = false)
    private String language;

    @Column(nullable = false)
    private String image;

    private int view = 0;

    private String format;

    private int ageLimit;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    private List<RoomMovieScheduleEntity> roomMovieSchedules;
}
