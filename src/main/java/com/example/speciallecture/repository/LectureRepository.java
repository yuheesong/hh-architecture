package com.example.speciallecture.repository;

import com.example.speciallecture.entity.SpecialLecture;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LectureRepository extends JpaRepository<SpecialLecture, Long> {
    Optional<SpecialLecture> findById(String lectureId);

    int countUserById(Long lectureId);
}
