package com.project.movietickets.repository;

import com.project.movietickets.entity.UserEntity;
import com.project.movietickets.model.Role;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class UserRepositoryTest {
    @Autowired
    private UserRepository repository;

    @Test
    public void testInsertUserToDataBase(){
        UserEntity created = UserEntity.builder()
                .username("abcd123")
                .password("abcd123")
                .email("abc@gmail.com")
                .fullName("Name")
                .role(Role.ROLE_USER)
                .gender(true)
                .dateOfBirth(LocalDate.of(2020,8,8))
                .build();

        UserEntity result = repository.save(created);

        assertEquals("abcd123", result.getUsername());
        assertEquals("abcd123", result.getPassword());
        assertEquals("abc@gmail.com", result.getEmail());
        assertEquals("Name", result.getFullName());
        assertEquals(true, result.isGender());
        assertEquals(LocalDate.of(2020,8,8), result.getDateOfBirth());
        assertEquals(Role.ROLE_USER, result.getRole());
    }
}
