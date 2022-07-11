package com.project.movietickets.controller.web.admin;

import com.project.movietickets.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class RoomController {

    private final RoomService roomService;

    @PostMapping(value = "/rooms")
    public String create(@RequestParam("name") String name,
                         @RequestParam("cinemaId") int cinemaId){
        roomService.create(name, cinemaId);

        return "redirect:/admin/cinemas";
    }
}
