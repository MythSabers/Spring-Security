package com.ui.application.application.Controller;

import com.ui.application.application.Service.StudentService;
import com.ui.application.application.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student/dashboard")
public class StudentDashboard {
    @Autowired
    private StudentService service;

    @GetMapping("/get")
    public ResponseEntity<Student> getStudent(@RequestParam("id") Integer id) {
        Student student = this.service.getStudentById(id);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }


}
