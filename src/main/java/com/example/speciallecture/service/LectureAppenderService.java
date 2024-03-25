package com.example.speciallecture.service;

import com.example.speciallecture.entity.Registration;
import com.example.speciallecture.entity.SpecialLecture;
import com.example.speciallecture.entity.User;
import com.example.speciallecture.repository.LectureRepository;
import com.example.speciallecture.repository.RegistrationRepository;
import com.example.speciallecture.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class LectureAppenderService {

    private final RegistrationRepository registrationRepository;

    //특강 신청
    public void registerLecture(Long userId, Long lectureId){
        Registration registration = new Registration();
        registration.setUserId(userId);
        registration.setLectureId(lectureId);
        registration.setRegistrationDate(new Date());

        registrationRepository.save(registration);
    }


}
