package com.project.bookmyshow.service;

import com.project.bookmyshow.exception.ShowSeatAlreadyBookedException;
import com.project.bookmyshow.models.ShowSeat;
import com.project.bookmyshow.models.Ticket;
import com.project.bookmyshow.models.User;

import java.util.List;

public interface TicketService {
    Ticket bookTicket(List<Integer> showSeatIds, User user) throws ShowSeatAlreadyBookedException;
}
