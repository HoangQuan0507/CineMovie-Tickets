package com.project.movietickets.repository;

import com.project.movietickets.entity.CinemaEntity;
import com.project.movietickets.entity.RoomEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class RoomRepositoryTest {
    @Autowired
    private RoomRepository repository;
    @Autowired
    private CinemaRepository cinemaRepository;

    @Test
    public void testInsertRoomToDataBase(){
        RoomEntity created = RoomEntity.builder()
                .name("Name")
                .build();

        RoomEntity result = repository.save(created);

        assertEquals("Name", result.getName());
    }

    @Test
    public void testInsertCinemaOfRoomToDataBase(){
        CinemaEntity cinema = CinemaEntity.builder()
                .name("Cinema")
                .build();

        RoomEntity room = RoomEntity.builder()
                .name("Name")
                .cinema(cinema)
                .build();

        cinemaRepository.save(cinema);
        RoomEntity result = repository.save(room);

        assertEquals("Cinema", result.getCinema().getName());
    }
}
