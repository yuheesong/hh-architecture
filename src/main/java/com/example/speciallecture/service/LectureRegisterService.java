package com.example.speciallecture.service;

import com.example.speciallecture.dto.LectureRegisterRequest;
import com.example.speciallecture.entity.Registration;
import com.example.speciallecture.entity.SpecialLecture;
import com.example.speciallecture.entity.User;
import com.example.speciallecture.repository.LectureRepository;
import com.example.speciallecture.repository.RegistrationRepository;
import com.example.speciallecture.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class LectureRegisterService {

    private final LectureRepository lectureRepository;
    private final UserRepository userRepository;
    private final RegistrationRepository registrationRepository;

    private final LectureFinderService lectureFinderService;
    private final LectureReaderService lectureReaderService;
    private final LectureAppenderService lectureAppenderService;

    @Transactional
    public void registerLecture(LectureRegisterRequest request) throws Exception{

        // 1. 사용자 확인
        User user = lectureFinderService.findByUserId(request.getUserId())
                .orElseThrow(() -> new Exception("유저를 찾을 수 없습니다."));

        // 2. 특강 확인
        SpecialLecture specialLecture = lectureFinderService.findByLectureId(request.getLectureId())
                .orElseThrow(() -> new Exception("특강을 찾을 수 없습니다."));

        // 3. 중복 신청 여부 확인
        if (lectureFinderService.findHistoryByUserIdAndLectureId(request.getUserId(), request.getLectureId())) {
            throw new Exception("이미 특강이 신청되어있습니다.");
        }

        // 4. 특강 마감 확인
        if(lectureReaderService.countUserById(request.getLectureId()) > 30) {
            throw new Exception("특강이 마감되었습니다.");
        }

        // 5. 특강 신청
        lectureAppenderService.registerLecture(request.getUserId(), request.getLectureId());

    }

    @Transactional
    public void checkLecture(LectureRegisterRequest request) throws Exception{

        // 1. 사용자 확인
        User user = lectureFinderService.findByUserId(request.getUserId())
                .orElseThrow(() -> new Exception("유저를 찾을 수 없습니다."));

        // 2. 특강 확인
        SpecialLecture specialLecture = lectureFinderService.findByLectureId(request.getLectureId())
                .orElseThrow(() -> new Exception("특강을 찾을 수 없습니다."));


        // 3. 특강 신청 여부 조회
        lectureFinderService.findHistoryByUserIdAndLectureId(request.getUserId(), request.getLectureId());

    }


}
