package com.project.movietickets.controller.web.user;

import com.project.movietickets.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
public class HistoryController {

    private final TicketService ticketService;

    @GetMapping(value = "/history")
    public ModelAndView index(Authentication authentication){
        var modelAndView = new ModelAndView("user/history");
        var username = authentication.getName();
        var tickets = ticketService.getAllByUser(username);

        modelAndView.addObject("tickets", tickets);

        return modelAndView;
    }

    @GetMapping(value = "/history/{id}/delete")
    public String delete(@PathVariable("id") int id){
        ticketService.deleteTicket(id);
        return "redirect:/history";
    }
}
