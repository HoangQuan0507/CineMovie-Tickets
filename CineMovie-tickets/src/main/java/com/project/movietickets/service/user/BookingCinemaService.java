//package com.project.movietickets.service.user;
//
//import com.project.movietickets.entity.CinemaEntity;
//import com.project.movietickets.entity.CityEntity;
//import com.project.movietickets.entity.RoomMovieScheduleEntity;
//import com.project.movietickets.model.CinemaModel;
//import com.project.movietickets.model.CityModel;
//import com.project.movietickets.model.RoomMovieScheduleModel;
//import com.project.movietickets.repository.CityRepository;
//import com.project.movietickets.repository.RoomMovieScheduleRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//
//@Service
//public class BookingCinemaService {
//    @Autowired
//    private CityRepository cityRepository;
//
//    @Autowired
//    private RoomMovieScheduleRepository roomMovieScheduleRepository;
//
//    public List<LocalDate> getAllDayOfWeek(){
//        final var now = LocalDate.now();
//
//        final var result = new ArrayList<LocalDate>();
//        for (int i = 0; i < 7; i++) {
//            result.add( now.plusDays(i));
//        }
//
//        return result;
//    }
//
//    public List<CityModel> getAllCityModelHasMovie(int movieId){
//        var cities = getAllCityEntityHasMovie(movieId);
//        var roomMovieSchedules = getAllScheduleHasMovie(movieId);
//
//        var mapCinemaSchedule = new HashMap<CinemaEntity, List<RoomMovieScheduleModel>>();
//
//        roomMovieSchedules.forEach( item -> {
//            var cinema = item.getRoom().getCinema();
//
//            if (mapCinemaSchedule.containsKey(cinema)){
//                var value = mapCinemaSchedule.get(cinema);
//                var model = new RoomMovieScheduleModel(item);
//                value.add(model);
//
//                mapCinemaSchedule.put(cinema, value);
//            } else {
//                var value = new ArrayList<RoomMovieScheduleModel>();
//                var model = new RoomMovieScheduleModel(item);
//                value.add(model);
//
//                mapCinemaSchedule.put(cinema, value);
//            }
//        });
//
//        var result = new ArrayList<CityModel>();
//
//        cities.forEach( city -> {
//            var cinemasOfCity = new ArrayList<CinemaModel>();
//
//            city.getCinemas().forEach( cinema -> {
//                if (!mapCinemaSchedule.containsKey(cinema)){
//                    return;
//                }
//
//                var listScheduleOfCinema = mapCinemaSchedule.get(cinema);
//
//                var cinemaModel = new CinemaModel(
//                        cinema.getId(), cinema.getName(), listScheduleOfCinema
//                );
//                cinemasOfCity.add(cinemaModel);
//            });
//
//            var cityModel = new CityModel(city.getId(), city.getName(), cinemasOfCity);
//            result.add(cityModel);
//        });
//
//        return result;
//    }
//
//    private List<CityEntity> getAllCityEntityHasMovie(int movieId){
//        return cityRepository.findListCityByMovieId(movieId);
//    }
//
//    private List<RoomMovieScheduleEntity> getAllScheduleHasMovie(int movieId){
//        return roomMovieScheduleRepository.findRoomMovieScheduleEntitiesByMovie_Id(movieId);
//    }
//}
