package com.project.bookmyshow.models;

import com.project.bookmyshow.models.constants.BaseModel;
import com.project.bookmyshow.models.constants.PaymentMethod;
import com.project.bookmyshow.models.constants.Status;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Payment extends BaseModel {
    private LocalDateTime paymentTime;
    private double amount;
    private String referenceId;
    @Enumerated(EnumType.STRING)
    private Status status;
    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;
    @ManyToOne
    private Ticket ticket;
}
