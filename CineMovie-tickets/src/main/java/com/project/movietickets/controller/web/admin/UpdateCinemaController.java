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
public class UpdateCinemaController {

    private final CinemaService cinemaService;

    private final CityService cityService;

    /**
     * For update cinema
     *
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/cinemas/{id}/update")
    public String detail(@PathVariable int id, Model model) {
        var cinema = cinemaService.findById(id);
        var cities = cityService.getAllCity();

        model.addAttribute("cities", cities);
        model.addAttribute("cinema", cinema);
        return "admin/cinema/update";
    }

    @PostMapping("/cinemas/{id}/update")
    public String update(@PathVariable int id,
                         @RequestParam String name,
                         @RequestParam int cityId) {
        cinemaService.updateCinema(id, name, cityId);
        return "redirect:/admin/cinemas";
    }
}
