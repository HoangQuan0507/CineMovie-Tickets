package com.project.movietickets.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class UserModel {
    private int id;

    private String username;

    private String password;

    private String email;

    private String fullName;

    private boolean gender;

    private LocalDate dateOfBirth;

    private Role role;
}
