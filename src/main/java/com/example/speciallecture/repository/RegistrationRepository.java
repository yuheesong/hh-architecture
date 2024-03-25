package com.example.speciallecture.repository;

import com.example.speciallecture.entity.Registration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrationRepository extends JpaRepository<Registration, Long> {
    boolean existByUserIdAndLectureId(Long userId, Long lectureId);
}
