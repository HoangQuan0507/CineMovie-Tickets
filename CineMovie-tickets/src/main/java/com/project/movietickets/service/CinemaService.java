package com.project.movietickets.service;

import com.project.movietickets.entity.CinemaEntity;
import com.project.movietickets.repository.CinemaRepository;
import com.project.movietickets.repository.CityRepository;
import com.project.movietickets.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CinemaService {
    @Autowired
    private CinemaRepository cinemaRepository;

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private RoomRepository roomRepository;

    public List<CinemaEntity> getAllCinema() {
        return cinemaRepository.findAll();
    }

    public void deleteCinema(int id) {
        final var cinema = cinemaRepository.findById(id).get();

        cinema.setCity(null);
        cinemaRepository.save(cinema);

        cinemaRepository.deleteById(id);

        assert cinemaRepository.findById(id).isEmpty() : "No remove";
    }

    public CinemaEntity createCinema(String name, int cityId) {
        final var city = cityRepository.findById(cityId).get();
        final var cinema = new CinemaEntity();
        cinema.setCity(city);
        cinema.setName(name);

        return cinemaRepository.save(cinema);
    }

    public CinemaEntity updateCinema(int id, String name, int cityId) {
        final var city = cityRepository.findById(cityId).get();
        final var cinema = cinemaRepository.findById(id).get();
        cinema.setCity(city);
        cinema.setName(name);

        return cinemaRepository.save(cinema);
    }

    public CinemaEntity findById(int id) {
        return cinemaRepository.findById(id).get();
    }
}
