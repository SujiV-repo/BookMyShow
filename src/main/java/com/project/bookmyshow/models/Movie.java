package com.project.bookmyshow.models;

import com.project.bookmyshow.models.constants.BaseModel;
import com.project.bookmyshow.models.constants.MovieFeature;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Movie extends BaseModel {
    private String name;
    private String description;
    private String language;

    @ManyToMany
    private List<Actor> actors;

    @ElementCollection
    @Enumerated(EnumType.STRING)
    private List<MovieFeature> movieFeatures;
}
