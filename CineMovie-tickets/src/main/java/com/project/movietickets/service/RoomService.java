package com.project.movietickets.service;

import com.project.movietickets.entity.ChairEntity;
import com.project.movietickets.entity.CinemaEntity;
import com.project.movietickets.entity.RoomChairEntity;
import com.project.movietickets.entity.RoomEntity;
import com.project.movietickets.repository.ChairRepository;
import com.project.movietickets.repository.CinemaRepository;
import com.project.movietickets.repository.RoomChairRepository;
import com.project.movietickets.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomService {

    private final RoomRepository roomRepository;

    private final CinemaRepository cinemaRepository;

    private final RoomChairRepository roomChairRepository;

    private final ChairRepository chairRepository;

    public List<RoomEntity> getAllRoom(){
        return roomRepository.findAll();
    }

    @Transactional
    public RoomEntity create(String name, int cinemaId) {
        CinemaEntity cinema = cinemaRepository.getOne(cinemaId);

        RoomEntity room = new RoomEntity();
        room.setCinema(cinema);
        room.setName(name);
        roomRepository.save(room);

        chairRepository.findAll().forEach( chair -> {
            RoomChairEntity roomChairEntity = RoomChairEntity.builder()
                    .chair(chair)
                    .room(room)
                    .build();

            roomChairRepository.save(roomChairEntity);
        });

        return room;
    }
}
