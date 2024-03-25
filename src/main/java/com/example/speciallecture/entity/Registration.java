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
public class Registration {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long registrationId;

    private Long userId;

    private Long lectureId;

    private Date registrationDate;
}
