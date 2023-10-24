package com.project.bookmyshow.models;

import com.project.bookmyshow.models.constants.BaseModel;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Actor extends BaseModel {
    private String name;
}
