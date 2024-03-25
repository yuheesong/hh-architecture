package com.example.speciallecture.dto;

public class LectureRegisterRequest {
    private Long userId;
    private Long lectureId;

    public Long getUserId(){
        return userId;
    }

    public Long getLectureId(){
        return lectureId;
    }
}
