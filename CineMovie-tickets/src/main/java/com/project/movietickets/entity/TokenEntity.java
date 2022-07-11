package com.project.movietickets.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "tokens")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TokenEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(updatable = false, nullable = false)
    private String token;
    @Column(updatable = false, nullable = false)
    private String username;
    private boolean isUsed = false;
    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime timeCreate;
    @Column(nullable = false)
    private String password;
}
