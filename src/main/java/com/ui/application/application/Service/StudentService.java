package com.ui.application.application.Service;

import com.ui.application.application.dto.RequestStudent;
import com.ui.application.application.model.Student;
import com.ui.application.application.repository.StudentRepository;
import com.ui.application.application.repository.UsersRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Integer id) {
        Optional<Student> optionalStudent = studentRepository.findStudentByStudentId(id);
        if (optionalStudent.isPresent())
            return optionalStudent.get();
        throw new IllegalStateException("Student Not Found");
    }


    public void createStudent(RequestStudent req) {
        Student student = Student.builder()
                .firstName(req.getFirstName())
                .lastName(req.getLastName())
                .age(req.getAge())
                .email(req.getEmail())
                .build();

        studentRepository.saveAndFlush(student);
    }
}
