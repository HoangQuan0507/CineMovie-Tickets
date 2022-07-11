package com.project.movietickets.controller.web.guest;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Log4j2
public class LoginController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(@RequestParam(value = "error", required = false) String error, Model model){
        if (error != null) {
            log.info("User login failed");
            model.addAttribute("message", "Mật khẩu hoặc tên đăng nhập sai!");
        }

        return "login";
    }
}
