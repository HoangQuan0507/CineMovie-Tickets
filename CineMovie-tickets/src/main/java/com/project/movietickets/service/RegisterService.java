package com.project.movietickets.service;

import com.project.movietickets.entity.UserEntity;
import com.project.movietickets.model.Role;
import com.project.movietickets.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Log4j2
@Service
@RequiredArgsConstructor
public class RegisterService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public UserEntity registerUser(String username,
                                   String password,
                                   String fullname,
                                   String email,
                                   String phone,
                                   String zone,
                                   String cinemaLove,
                                   boolean gender,
                                   String dateOfBirth) {

        UserEntity user = UserEntity.builder()
                .username(username)
                .password(passwordEncoder.encode(password))
                .fullName(fullname)
                .email(email)
                .cinemaLove(cinemaLove)
                .zone(zone)
                .phone(phone)
                .role(Role.ROLE_USER)
                .gender(gender)
                .dateOfBirth(LocalDate.parse(dateOfBirth))
                .build();

        try {
            return userRepository.save(user);
        } catch (Exception e) {
            log.error(e);
        }

        return null;
    }
}
