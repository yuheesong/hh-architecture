package com.example.speciallecture.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class SpecialLecture {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long lectureId;

    private String lectureName;

    private String description;

    private Integer capacity;

    private Date lectureDate;
}
