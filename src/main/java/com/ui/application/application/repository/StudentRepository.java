package com.ui.application.application.repository;

import com.ui.application.application.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    Optional<Student> findStudentByStudentId(Integer studentId);

}
