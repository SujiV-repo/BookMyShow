package com.project.bookmyshow.service;

import com.project.bookmyshow.exception.ShowSeatAlreadyBookedException;
import com.project.bookmyshow.models.ShowSeat;
import com.project.bookmyshow.models.Ticket;
import com.project.bookmyshow.models.User;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface TicketService {
    @Transactional(isolation = Isolation.SERIALIZABLE)
    Ticket bookTicket(List<Integer> showSeatIds, int userId) throws ShowSeatAlreadyBookedException;
}
