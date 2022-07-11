package com.project.movietickets.controller.web.user;

import com.project.movietickets.entity.TicketEntity;
import com.project.movietickets.service.user.BookingTicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
public class BookingTicketController {

    private final BookingTicketService bookingTicketService;

    @GetMapping(value = "/booking/ticket")
    public ModelAndView index(@RequestParam("scheduleId") int scheduleId,
                              @RequestParam("roomChairId") int roomChairId,
                              Authentication authentication) {
        var modelAndView = new ModelAndView("user/booking-ticket");

        var username = authentication.getName();

        TicketEntity ticket = bookingTicketService.buyTicket(
                scheduleId,
                roomChairId,
                username
        );

        modelAndView.addObject("ticket", ticket);

        return modelAndView;
    }
}
