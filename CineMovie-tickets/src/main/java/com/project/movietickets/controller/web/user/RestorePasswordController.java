package com.project.movietickets.controller.web.user;

import com.project.movietickets.model.Message;
import com.project.movietickets.service.RestorePasswordService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
public class RestorePasswordController {
    private final RestorePasswordService restorePasswordService;

    @GetMapping("/restore-password")
    public String index() {
        return "restore-password";
    }

    @PostMapping("/restore-password")
    public ModelAndView restorePassword(@RequestParam String username,
                                        @RequestParam String password,
                                        @RequestParam String rePassword) {
        var modelAndView = new ModelAndView("restore-password");
        var message = restorePasswordService.createToken(username, password, rePassword);
        modelAndView.addObject("message", message);

        return modelAndView;
    }

    @GetMapping("/confirm-password")
    public ModelAndView confirmPassword(@RequestParam String token) {
        var modelAndView = new ModelAndView("/confirm-password");
        var message = restorePasswordService.setNewPassword(token);
        modelAndView.addObject("message", message);

        return modelAndView;
    }
}
