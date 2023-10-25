package com.project.bookmyshow.service;

import com.project.bookmyshow.exception.ShowSeatAlreadyBookedException;
import com.project.bookmyshow.models.ShowSeat;
import com.project.bookmyshow.models.Ticket;
import com.project.bookmyshow.models.User;
import com.project.bookmyshow.models.constants.ShowSeatStatus;
import com.project.bookmyshow.repository.ShowSeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class TicketServiceImpl implements TicketService{
    @Autowired
    private ShowSeatRepository showSeatRepository;
    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Ticket bookTicket(List<Integer> showSeatIds, User user) throws ShowSeatAlreadyBookedException {
        //checking status of all the seats if available, throwing exception if not available
        List<ShowSeat> seats = showSeatRepository.findAllById(showSeatIds);
        for(ShowSeat seat : seats){
            if(!seat.getShowSeatStatus().equals(ShowSeatStatus.AVAILABLE)){
                throw new ShowSeatAlreadyBookedException("Show Seat is booked already by someone else");
            }
        }

        //locking the seats and save into db
        seats.forEach(seat -> seat.setShowSeatStatus(ShowSeatStatus.LOCKED));
        showSeatRepository.saveAll(seats);

        return new Ticket();
    }
}
