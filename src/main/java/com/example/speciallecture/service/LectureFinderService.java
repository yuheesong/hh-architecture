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
public class LectureFinderService {
    private final UserRepository userRepository;
    private final LectureRepository lectureRepository;
    private final RegistrationRepository registrationRepository;

    //유저 조회
    public Optional<User> findByUserId(Long userId) {
        return userRepository.findById(userId);
    }

    //특강 조회
    public Optional<SpecialLecture> findByLectureId(Long lectureId) {
        return lectureRepository.findById(lectureId);
    }

    // 특강 신청 여부 조회
    public boolean findHistoryByUserIdAndLectureId(Long userId, Long lectureId) {
        return registrationRepository.existByUserIdAndLectureId(userId, lectureId);
    }
}
