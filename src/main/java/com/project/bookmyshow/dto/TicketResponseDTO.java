package com.project.bookmyshow.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TicketResponseDTO {
    private double totalAmount;
    private LocalDateTime timeOfShow;
    private List<String> seatNumbers;
    private String movieName;
    private String auditoriumName;
}
