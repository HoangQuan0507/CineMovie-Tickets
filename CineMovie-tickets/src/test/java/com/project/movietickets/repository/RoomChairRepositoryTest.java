package com.project.movietickets.repository;

import com.project.movietickets.entity.ChairEntity;
import com.project.movietickets.entity.RoomChairEntity;
import com.project.movietickets.entity.RoomEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class RoomChairRepositoryTest {
    @Autowired
    private RoomChairRepository repository;
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private ChairRepository chairRepository;

    @Test
    public void testInsertRoomChairToDataBase(){
        RoomEntity room = RoomEntity.builder()
                .name("CGV")
                .build();

        ChairEntity chair = ChairEntity.builder()
                .position("A5")
                .build();

        RoomChairEntity created = RoomChairEntity.builder()
                .chair(chair)
                .room(room)
                .build();

        chairRepository.save(chair);
        roomRepository.save(room);
        RoomChairEntity result = repository.save(created);

        assertEquals("A5", result.getChair().getPosition());
        assertEquals("CGV", result.getRoom().getName());
    }
}
