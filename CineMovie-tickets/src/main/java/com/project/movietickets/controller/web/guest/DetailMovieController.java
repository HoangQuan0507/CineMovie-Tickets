package com.project.movietickets.controller.web.guest;

import com.project.movietickets.entity.MovieEntity;
import com.project.movietickets.repository.CityRepository;
import com.project.movietickets.service.DetailMovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@RequiredArgsConstructor
public class DetailMovieController {

    private final DetailMovieService detailMovieService;

    private final CityRepository cityRepository;

    @GetMapping(value = "/movies")
    public String index(@Param("id") int id, Model model){
        MovieEntity movie = detailMovieService.getDetailMovie(id);
        model.addAttribute("movie", movie);
        model.addAttribute("cityId", cityRepository.findFirstByNameNotNull().getId());
        model.addAttribute("date", LocalDate.now().toString());

        return "detail";
    }
}
