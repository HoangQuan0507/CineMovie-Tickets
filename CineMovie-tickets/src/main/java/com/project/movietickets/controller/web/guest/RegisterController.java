package com.project.movietickets.controller.web.guest;

import com.project.movietickets.entity.UserEntity;
import com.project.movietickets.service.RegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class RegisterController {
    private final RegisterService service;

    @GetMapping(value = "/register")
    public String index(){
        return "register";
    }

    @PostMapping(value = "/register")
    public String register(@RequestParam String username,
                                 @RequestParam String password,
                                 @RequestParam String fullname,
                                 @RequestParam String email,
                                 @RequestParam String phone,
                                 @RequestParam String zone,
                                 @RequestParam String cinemaLove,
                                 @RequestParam String dateOfBirth,
                                 @RequestParam boolean gender,
                                 Model model){
        UserEntity result = service.registerUser(
                username,
                password,
                fullname,
                email,
                phone,
                zone,
                cinemaLove,
                gender,
                dateOfBirth
        );

        if (result != null) {
            return "redirect:/login";
        }

        model.addAttribute("message", "Đăng kí thất bại!");
        return "register";
    }
}

