package com.project.movietickets.repository.custom;

import com.project.movietickets.entity.TicketEntity;

import java.util.List;

public interface SearchReportRepository {
    List<TicketEntity> searchTicket(String startDate, String endDate, String category);
}
