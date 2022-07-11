package com.project.movietickets.service.user;

import com.project.movietickets.entity.TicketEntity;
import com.project.movietickets.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookingTicketService {

    private final UserRepository userRepository;

    private final RoomChairRepository roomChairRepository;

    private final RoomMovieScheduleRepository roomMovieScheduleRepository;

    private final TicketRepository ticketRepository;

    public TicketEntity buyTicket(int scheduleId, int roomChairId, String username) {
        if ( !isTicketValid(scheduleId, roomChairId)) {
            return null;
        }

        var roomChair = roomChairRepository.getOne(roomChairId);
        var roomChairSchedule = roomMovieScheduleRepository.getOne(scheduleId);
        var code = UUID.randomUUID().toString().substring(0, 13).toUpperCase();
        var user = userRepository.findUserEntityByUsername(username).get();

        roomChair.setStatus(true);
        roomChairRepository.save(roomChair);

        // set amount
        // nguoi lon 60k
        // tre em 40k
        int amount = 60;

        if (LocalDate.now().getYear() - user.getDateOfBirth().getYear() < 18) {
            amount = 40;
        }

        var ticket = TicketEntity.builder()
                .date(LocalDate.now())
                .code(code)
                .roomChair(roomChair)
                .roomMovieSchedule(roomChairSchedule)
                .user(user)
                .amount(amount)
                .build();

        return ticketRepository.save(ticket);
    }

    public boolean isTicketValid(int scheduleId, int roomChairId){
        var tickets = ticketRepository.findTicketEntitiesByRoomMovieSchedule_Id(scheduleId);
        for (var ticket : tickets){
            if (ticket.getRoomChair().getId() == roomChairId)
                return false;
        }

        return true;
    }
}
