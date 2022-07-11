package com.project.movietickets.repository;

import com.project.movietickets.entity.CinemaEntity;
import com.project.movietickets.entity.CityEntity;
import com.project.movietickets.entity.RoomEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class CinemaRepositoryTest {
    @Autowired
    private CinemaRepository cinemaRepository;

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Test
    public void testInsertCinemaToDataBase(){
        final var created = CinemaEntity.builder()
                .name("CGV")
                .build();

        assertEquals("CGV", created.getName());
    }

    @Test
    public void testInsertCityOfCinemaToDataBase(){
        final var city = CityEntity.builder()
                .name("Ha Noi")
                .build();
        cityRepository.save(city);

        final var created = CinemaEntity.builder()
                .name("CGV")
                .city(city)
                .build();
        cinemaRepository.save(created);

        assertEquals("Ha Noi", created.getCity().getName());
    }

    @Test
    public void testRemoveCinema(){
        final var city = CityEntity.builder().name("City").build();
        cityRepository.save(city);

        final var cinema = CinemaEntity.builder()
                .city(city)
                .name("Name")
                .build();
        cinemaRepository.save(cinema);

        final var room = RoomEntity.builder()
                .name("Name")
                .cinema(cinema)
                .build();
        roomRepository.save(room);

        final var roomId = room.getId();
        final var id = cinema.getId();

        cinema.setCity(null);
        cinemaRepository.save(cinema);

        cinemaRepository.deleteById(id);

        assertEquals(true, cinemaRepository.findById(id).isEmpty());
        assertEquals(true, roomRepository.findById(roomId).isEmpty());
    }
}
