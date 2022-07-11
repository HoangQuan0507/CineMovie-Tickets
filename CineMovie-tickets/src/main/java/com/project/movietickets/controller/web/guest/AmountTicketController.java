package com.project.movietickets.controller.web.guest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AmountTicketController {
    private final static String PAGE = "amount";

    @GetMapping("/amount")
    public String getIndex() {
        return PAGE;
    }
}
