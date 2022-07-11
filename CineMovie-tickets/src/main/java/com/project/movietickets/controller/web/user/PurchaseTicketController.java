package com.project.movietickets.controller.web.user;

import com.project.movietickets.entity.CityEntity;
import com.project.movietickets.model.custom.Cinema;
import com.project.movietickets.service.CityService;
import com.project.movietickets.service.user.PurchaseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class PurchaseTicketController {
    private final PurchaseService purchaseService;

    private final CityService cityService;

    @GetMapping("/purchase/{movieId}/{cityId}/{date}")
    public ModelAndView getView(@PathVariable int movieId,
                                @PathVariable int cityId,
                                @PathVariable String date) {
        var modelAndView = new ModelAndView("user/ticket/index");

        List<Cinema> cinemas = purchaseService.getAllDate(movieId,cityId,date);
        List<CityEntity> cities = cityService.getAllCity();

        modelAndView.addObject("movieId", movieId);
        modelAndView.addObject("cityId", cityId);
        modelAndView.addObject("date", date);
        modelAndView.addObject("cities", cities);
        modelAndView.addObject("cinemas", cinemas);

        return modelAndView;
    }
}
