package com.project.bookmyshow.models;

import com.project.bookmyshow.models.constants.BaseModel;
import com.project.bookmyshow.models.constants.TicketStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
public class Ticket extends BaseModel {
    private LocalDateTime timeOfBooking;
    private double totalAmount;

    @ManyToMany
    private List<ShowSeat> showSeats;

    @ManyToOne
    private Show show;

    @Enumerated(EnumType.STRING)
    private TicketStatus ticketStatus;

}
