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
    public Ticket bookTicket(List<Integer> showSeatIds, int userId) throws ShowSeatAlreadyBookedException {
        //checking status of all the seats if available, throwing exception if not available
        for(Integer showSeatId : showSeatIds){
            ShowSeat seat = showSeatRepository.findById(showSeatId).get(); // bulk fetch the showSeats to optimise
            if(!seat.getShowSeatStatus().equals(ShowSeatStatus.AVAILABLE)){
                throw new ShowSeatAlreadyBookedException("Show Seat is booked by someone else");
            }
        }
        //locked the seats
        for(Integer showSeatId : showSeatIds){
            ShowSeat seat = showSeatRepository.findById(showSeatId).get();
            seat.setShowSeatStatus(ShowSeatStatus.LOCKED);
            showSeatRepository.save(seat);
        }

        return new Ticket();
    }
}
