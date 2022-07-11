package com.project.movietickets.controller.web.employee;

import com.project.movietickets.entity.TicketEntity;
import com.project.movietickets.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class EmployeeController {

    private final TicketService ticketService;

    @GetMapping("/manage")
    public ModelAndView index(
            @RequestParam(value = "code", required = false) String code,
            ModelAndView modelAndView
    ) {
        boolean isHasValue = false;
        boolean isSearched = false;

        if (code != null && !code.isBlank()) {
            Optional<TicketEntity> optTicket = ticketService.findTicketByCode(code);

            if (optTicket.isPresent()) {
                isHasValue = true;
                modelAndView.addObject("ticket", optTicket.get());
            }

            isSearched = true;
        }

        modelAndView.setViewName("employee/index");
        modelAndView.addObject("isHasValue", isHasValue);
        modelAndView.addObject("isSearched", isSearched);

        return modelAndView;
    }

    @PostMapping("/manage/checkout")
    public RedirectView checkoutTicket(@RequestParam("code") String code, RedirectView redirectView) {
        ticketService.updateCheckoutTicket(code);
        redirectView.setUrl("/manage");
        return redirectView;
    }

    @PostMapping("/manage/receive")
    public ModelAndView receiveTicket(@RequestParam("code") String code, ModelAndView modelAndView){
        var ticket = ticketService.updateReceiveTicket(code);

        modelAndView.setViewName("employee/get-ticket");
        modelAndView.addObject("ticket", ticket);
        return modelAndView;
    }
}
