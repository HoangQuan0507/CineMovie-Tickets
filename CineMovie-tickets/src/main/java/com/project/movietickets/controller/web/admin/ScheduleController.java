package com.project.movietickets.controller.web.admin;

import com.project.movietickets.service.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
@Log4j2
public class ScheduleController {

    private final RoomMovieScheduleService roomMovieScheduleService;

    private final CinemaService cinemaService;

    private final MovieService movieService;

    @GetMapping(value = "/schedules")
    public String index(Model model) {
        var roomMovieSchedules = roomMovieScheduleService.getAllSchedule();
        model.addAttribute("roomMovieSchedules", roomMovieSchedules);

        return "admin/schedule/index";
    }

    @GetMapping(value = "/schedules/create")
    public String create(Model model) {
        var cinemas = cinemaService.getAllCinema();
        var movies = movieService.getAllMovie();

        model.addAttribute("cinemas", cinemas);
        model.addAttribute("movies", movies);

        return "admin/schedule/create";
    }

    @PostMapping(value = "/schedules/create")
    public String createSchedule(@RequestParam int roomId,
                                 @RequestParam int movieId,
                                 @RequestParam String time,
                                 Model model) {
        try {
            roomMovieScheduleService.createRoomMovieSchedule(roomId, movieId, time);
        } catch (Exception e) {
            log.error(e);
            model.addAttribute("error", "Sai định dạng ngày giờ!");
            return "admin/schedule/create";
        }

        return "redirect:/admin/schedules";
    }

    @GetMapping(value = "/schedules/{id}/delete")
    public String delete(@PathVariable int id) {
        roomMovieScheduleService.delete(id);

        return "redirect:/admin/schedules";
    }
}
