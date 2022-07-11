package com.project.movietickets.controller.web.guest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomErrorController implements ErrorController {

    @RequestMapping(value = "/error")
    public String index(){
        return "404";
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}
