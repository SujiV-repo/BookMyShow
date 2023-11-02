package com.project.bookmyshow.controller;

import com.project.bookmyshow.dto.BookTicketRequestDTO;
import com.project.bookmyshow.dto.TicketResponseDTO;
import com.project.bookmyshow.exception.ShowSeatAlreadyBookedException;
import com.project.bookmyshow.models.Ticket;
import com.project.bookmyshow.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class TicketController {
    @Autowired
    private TicketService ticketService;

    @PostMapping("/ticket")
    public ResponseEntity createTicket(@RequestBody BookTicketRequestDTO bookTicketRequestDTO) throws ShowSeatAlreadyBookedException {
        //Ticket ticket = ticketService.bookTicket(bookTicketRequestDTO.getShowSeatIds(), bookTicketRequestDTO.getUserId());
        TicketResponseDTO ticket = new TicketResponseDTO();
        ticket.setAuditoriumName("AUDI 01");
        ticket.setMovieName("SUPER COMMANDO DHRUV");
        ticket.setTotalAmount(400);
        ticket.setTimeOfShow(LocalDateTime.now());
        ticket.setSeatNumbers(List.of("A01", "A02"));
        return ResponseEntity.ok(ticket);
    }
}
