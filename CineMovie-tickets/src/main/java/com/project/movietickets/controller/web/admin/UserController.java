package com.project.movietickets.controller.web.admin;

import com.project.movietickets.entity.UserEntity;
import com.project.movietickets.model.UserModel;
import com.project.movietickets.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Log4j2
@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/employees")
    public ModelAndView index() {
        var modelAndView = new ModelAndView("admin/employee/index");
        var employees = userService.getAllEmployees();
        modelAndView.addObject("employees", employees);
        return modelAndView;
    }

    @GetMapping("/employees/{id}/delete")
    public String delete(@PathVariable int id) {
        userService.deleteUser(id);
        return "redirect:/admin/employees";
    }

    @GetMapping("/employees/create")
    public ModelAndView create() {
        var modelAndView = new ModelAndView("admin/employee/create");
        modelAndView.addObject("user", new UserEntity());
        return modelAndView;
    }

    @PostMapping("/employees/create")
    public String store(@ModelAttribute UserEntity user, Model model) {
        var userEntity = userService.createUser(user);

        if (userEntity == null) {
            model.addAttribute("message", "Username hoặc Email đã trùng");
            return "admin/employee/create";
        }

        return "redirect:/admin/employees";
    }

    @GetMapping("/employees/{id}/update")
    public ModelAndView update(@PathVariable("id") int id, Model model) {
        var modelAndView = new ModelAndView("admin/employee/update");
        UserEntity user = userService.findUserById(id);
        model.addAttribute("user", user);
        return modelAndView;
    }

    @PostMapping("/employees/{id}/update")
    public String updateUser(@PathVariable("id") int id, @ModelAttribute UserModel user) {
        userService.updateUser(id, user);
        return "redirect:/admin/employees";
    }
}
