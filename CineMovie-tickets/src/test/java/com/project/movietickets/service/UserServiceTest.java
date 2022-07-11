package com.project.movietickets.service;

import com.project.movietickets.entity.UserEntity;
import com.project.movietickets.model.Role;
import com.project.movietickets.model.UserModel;
import com.project.movietickets.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @MockBean
    private UserRepository userRepository;

    @Test
    public void testCreateUser() {
        final var user = UserEntity.builder()
                .email("email.com")
                .dateOfBirth(LocalDate.parse("2020-08-08"))
                .fullName("fullname")
                .username("username")
                .gender(true)
                .password("123456")
                .role(Role.ROLE_USER)
                .build();

        userService.createUser(user);

        Mockito.verify(userRepository).save(Mockito.any(UserEntity.class));
    }

    @Test
    public void testUpdateUserWithPassword(){
        UserModel model = new UserModel(
                0,
                "username",
                "password",
                "email",
                "fullName",
                true,
                LocalDate.of(2020, 8, 8),
                Role.ROLE_EMPLOYEE
        );

        UserEntity entity = UserEntity.builder()
                .id(1)
                .username("oldUsername")
                .password(passwordEncoder.encode("oldPassword"))
                .email("oldEmail")
                .dateOfBirth(LocalDate.of(2020, 8, 8))
                .role(Role.ROLE_EMPLOYEE)
                .build();

        Mockito.when(userRepository.getOne(1)).thenReturn(entity);

        ArgumentCaptor<UserEntity> argument = ArgumentCaptor.forClass(UserEntity.class);


        userService.updateUser(1, model);


        // Assert
        Mockito.verify(userRepository).save(argument.capture());
        UserEntity result = argument.getValue();

        assertEquals(1, result.getId());
        assertEquals("username", result.getUsername());
        assertEquals("email", result.getEmail());
        assertEquals(true, passwordEncoder.matches("password", result.getPassword()));
    }
}
