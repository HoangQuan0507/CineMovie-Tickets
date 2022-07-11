package com.project.movietickets.repository;

import com.project.movietickets.entity.ChairEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ChairRepositoryTest {
    @Autowired
    private ChairRepository repository;

    @Test
    public void testInsertChairToDataBase(){
        ChairEntity created = ChairEntity.builder()
                .position("A6")
                .build();

        ChairEntity result = repository.save(created);

        assertEquals("A6", result.getPosition());
    }
}
