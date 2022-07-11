package com.project.movietickets.controller.web.admin;

import com.project.movietickets.service.CinemaService;
import com.project.movietickets.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class CinemaController {

    private final CinemaService cinemaService;

    private final CityService cityService;

    @GetMapping("/cinemas")
    public String index(Model model) {
        var cinemas = cinemaService.getAllCinema();
        var cities = cityService.getAllCity();

        model.addAttribute("cities", cities);
        model.addAttribute("cinemas", cinemas);

        return "admin/cinema/index";
    }

    /**
     * For create cinema
     *
     * @return String
     */
    @GetMapping("/cinemas/create")
    public String create(Model model) {
        var cities = cityService.getAllCity();
        model.addAttribute("cities", cities);
        return "admin/cinema/create";
    }

    @PostMapping("/cinemas")
    public String createCinema(
            @RequestParam("name") String name,
            @RequestParam("cityId") int cityId
    ) {
        cinemaService.createCinema(name, cityId);
        return "redirect:/admin/cinemas";
    }

    /**
     * For delete cinema
     *
     * @param id
     * @return String
     */
    @GetMapping("/cinemas/{id}/delete")
    public String delete(@PathVariable("id") int id) {
        cinemaService.deleteCinema(id);
        return "redirect:/admin/cinemas";
    }
}
