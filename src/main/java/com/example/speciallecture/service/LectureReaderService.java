package com.example.speciallecture.service;

import com.example.speciallecture.entity.SpecialLecture;
import com.example.speciallecture.entity.User;
import com.example.speciallecture.repository.LectureRepository;
import com.example.speciallecture.repository.RegistrationRepository;
import com.example.speciallecture.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LectureReaderService {

    private final LectureRepository lectureRepository;

    // 현재 수강 인원 조회
    public int countUserById (Long lectureId) {
        return lectureRepository.countUserById(lectureId);
    }

}
