package com.project.movietickets.repository;

import com.project.movietickets.entity.CinemaEntity;
import com.project.movietickets.entity.CityEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CityRepositoryTest {
    @Autowired
    private CityRepository repository;

    @Test
    public void testInsertAddressToDataBase(){
        CityEntity created = CityEntity.builder()
                .name("Ha Noi")
                .build();

        CityEntity result = repository.save(created);

        assertEquals("Ha Noi", result.getName());
    }
}
