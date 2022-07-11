package com.project.movietickets.controller.web.admin;

import com.project.movietickets.model.Report;
import com.project.movietickets.service.MovieService;
import com.project.movietickets.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class ReportController {

    private final ReportService reportService;

    private final MovieService movieService;

    @GetMapping(value = "/reports")
    public ModelAndView index(@RequestParam(value = "startDate", required = false) String startDate,
                              @RequestParam(value = "endDate", required = false) String endDate,
                              @RequestParam(value = "category", required = false) String category,
                              ModelAndView modelAndView) {
        modelAndView.setViewName("admin/report/index");

        List<Report> reports = reportService.searchReport(startDate, endDate, category);
        modelAndView.addObject("reports", reports);

        Set<String> categories = movieService.getAllCategories();
        modelAndView.addObject("categories", categories);

        return modelAndView;
    }
}
