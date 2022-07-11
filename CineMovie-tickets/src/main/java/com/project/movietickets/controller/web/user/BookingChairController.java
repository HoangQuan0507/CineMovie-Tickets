package com.project.movietickets.controller.web.user;

import com.project.movietickets.service.user.ChoiceChairService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
public class BookingChairController {

    private final ChoiceChairService service;

    @GetMapping("/booking/chair/{scheduleId}")
    public ModelAndView selectTicket(@PathVariable int scheduleId){
        var modelAndView = new ModelAndView("user/booking-chair");
        var roomChairs = service.getAllChairOfSchedule(scheduleId);

        modelAndView.addObject("roomChairs", roomChairs);
        modelAndView.addObject("scheduleId", scheduleId);

        return modelAndView;
    }
}
