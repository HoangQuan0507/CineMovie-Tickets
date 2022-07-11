package com.project.movietickets.service;

import com.project.movietickets.entity.MovieEntity;
import com.project.movietickets.entity.TicketEntity;
import com.project.movietickets.model.Report;
import com.project.movietickets.repository.custom.SearchReportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReportService {

    private final SearchReportRepository searchReportRepository;

    public List<Report> searchReport(String startDate, String endDate, String category){

        List<TicketEntity> tickets = searchReportRepository.searchTicket(
                startDate,
                endDate,
                category);

        final var map = new HashMap<MovieEntity, Integer>();

        tickets.forEach( ticket -> {
            final var key = ticket.getRoomMovieSchedule().getMovie();
            final var value = map.getOrDefault(key, 0) + 1;
            map.put(key, value);
        });

        final var reports = new ArrayList<Report>();

        map.forEach((key, count) -> {
            final var report = new Report();
            report.setCount(count);
            report.setName(key.getName());

            reports.add(report);
        });

        return reports.stream()
                .sorted((report, t1) -> t1.getCount() - report.getCount())
                .collect(Collectors.toList());
    }
}
