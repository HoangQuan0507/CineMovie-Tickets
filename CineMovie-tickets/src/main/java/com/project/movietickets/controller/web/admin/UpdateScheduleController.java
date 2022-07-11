package com.project.movietickets.controller.web.admin;

import com.project.movietickets.service.CinemaService;
import com.project.movietickets.service.MovieService;
import com.project.movietickets.service.RoomMovieScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class UpdateScheduleController {

    private final RoomMovieScheduleService roomMovieScheduleService;

    private final CinemaService cinemaService;

    private final MovieService movieService;

    @GetMapping(value = "/schedules/{id}/update")
    public String update(@PathVariable int id, Model model) {
        var cinemas = cinemaService.getAllCinema();
        var movies = movieService.getAllMovie();
        var roomMovieSchedule = roomMovieScheduleService.findById(id);

        model.addAttribute("roomMovieSchedule", roomMovieSchedule);
        model.addAttribute("cinemas", cinemas);
        model.addAttribute("movies", movies);

        return "admin/schedule/update";
    }

    @PostMapping(value = "/schedules/{id}/update")
    public String updateRoomMovieSchedule(@PathVariable int id,
                                          @RequestParam int roomId,
                                          @RequestParam int movieId,
                                          @RequestParam String time) {

        roomMovieScheduleService.updateRoomMovieSchedule(id, roomId, movieId, time);
        return "redirect:/admin/schedules";
    }
}
