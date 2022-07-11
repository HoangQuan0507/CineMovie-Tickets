package com.project.movietickets.service;

import com.project.movietickets.entity.TicketEntity;
import com.project.movietickets.repository.RoomChairRepository;
import com.project.movietickets.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TicketService {

    private final TicketRepository ticketRepository;

    private final RoomChairRepository roomChairRepository;

    public List<TicketEntity> getAllByUser(String username) {
        return ticketRepository.findAllByUserUsernameOrderByDateDesc(username);
    }

    @Transactional
    public void deleteTicket(int id) {
        final var ticket = ticketRepository.getOne(id);
        final var roomChair = ticket.getRoomChair();

        roomChair.setStatus(false);
        roomChairRepository.save(roomChair);
        ticketRepository.deleteById(id);

        assert ticketRepository.findById(id).isEmpty() : new RuntimeException("Can not delete ticket");
    }

    public Optional<TicketEntity> findTicketByCode(String code) {
        return ticketRepository.findTicketEntityByCode(code);
    }

    @Transactional
    public TicketEntity updateCheckoutTicket(String code){
        var optTicket = ticketRepository.findTicketEntityByCode(code);
        var ticket = optTicket.get();
        ticket.setPay(true);

        return ticketRepository.save(ticket);
    }

    @Transactional
    public TicketEntity updateReceiveTicket(String code){
        var optTicket = ticketRepository.findTicketEntityByCode(code);
        var ticket = optTicket.get();

        if (!ticket.isPay()){
            throw new RuntimeException("Checkout before receive!");
        }

        ticket.setReceived(true);

        return ticketRepository.save(ticket);
    }
}
