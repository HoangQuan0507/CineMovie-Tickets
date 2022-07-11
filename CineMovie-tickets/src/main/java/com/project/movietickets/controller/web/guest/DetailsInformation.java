package com.project.movietickets.controller.web.guest;

import com.project.movietickets.entity.UserEntity;
import com.project.movietickets.repository.UserRepository;
import com.project.movietickets.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;

@Controller
@RequiredArgsConstructor
@Log4j2
public class DetailsInformation {

    private final UserService userService;

    private final UserRepository userRepository;

    @GetMapping("/information")
    public ModelAndView getInformation(Authentication authentication) {
        var modelAndView = new ModelAndView("information");
        var username = authentication.getName();
        var userEntityOpt = userService.findUserByUsername(username);
        var userEntity = userEntityOpt.orElseThrow();

        modelAndView.addObject("user", userEntity);
        return modelAndView;
    }

    @PostMapping("/information")
    public String updateInformation(@RequestParam String username,
                                    @RequestParam String fullName,
                                    @RequestParam String email,
                                    @RequestParam String phone,
                                    @RequestParam boolean gender,
                                    @RequestParam String dateOfBirth,
                                    @RequestParam String zone,
                                    @RequestParam String cinemaLove,
                                    Model model,
                                    Authentication authentication) {
        var oldUsername = authentication.getName();
        var userEntity = userRepository.findUserEntityByUsername(oldUsername).orElseThrow();

        userEntity.setUsername(username);
        userEntity.setFullName(fullName);
        userEntity.setEmail(email);
        userEntity.setPhone(phone);
        userEntity.setGender(gender);
        userEntity.setDateOfBirth(LocalDate.parse(dateOfBirth));
        userEntity.setZone(zone);
        userEntity.setCinemaLove(cinemaLove);

        try {
            userRepository.save(userEntity);
            model.addAttribute("error", "Không thể cập nhật!");
        } catch (Exception e){
            e.printStackTrace();
        }

        return "redirect:/information";
    }
}
