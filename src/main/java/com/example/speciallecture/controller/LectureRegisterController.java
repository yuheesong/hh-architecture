package com.example.speciallecture.controller;

import com.example.speciallecture.dto.LectureRegisterRequest;
import com.example.speciallecture.service.LectureRegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/special-lecture")
@RequiredArgsConstructor
@RestController
public class LectureRegisterController {

    // LectureRegisterService에만 접근 가능하다.
    private final LectureRegisterService lectureRegisterService;

    // 특강 신청
    @PostMapping("/register")
    public void lectureRegister(@RequestBody LectureRegisterRequest request) throws Exception {
        lectureRegisterService.registerLecture(request);
    }

    // 특강 신청 여부 조회
    @GetMapping("/check")
    public void checkRegister(@RequestBody LectureRegisterRequest request) throws Exception {
        lectureRegisterService.checkLecture(request);
    }
}