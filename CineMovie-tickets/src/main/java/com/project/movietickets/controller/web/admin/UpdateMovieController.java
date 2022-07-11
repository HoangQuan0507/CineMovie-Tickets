package com.project.movietickets.controller.web.admin;

import com.project.movietickets.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class UpdateMovieController {

    private final MovieService service;

    @GetMapping(value = "/movies/{id}/update")
    public String index(@PathVariable int id, Model model) {
        var movie = service.findById(id);
        model.addAttribute("movie", movie);
        return "admin/movie/update";
    }


    @PostMapping(value = "/movies/{id}/update")
    public String update(@PathVariable int id,
                         @RequestParam String name,
                         @RequestParam String description,
                         @RequestParam String director,
                         @RequestParam String category,
                         @RequestParam String premiere,
                         @RequestParam int time,
                         @RequestParam String language,
                         @RequestParam String format,
                         @RequestParam int ageLimit) {
        service.updateMovie(
                id, name, description, director, category, premiere, time, language, format, ageLimit
        );

        return "redirect:/admin/movies";
    }
}
