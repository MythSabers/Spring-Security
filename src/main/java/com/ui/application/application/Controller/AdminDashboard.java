package com.ui.application.application.Controller;

import com.ui.application.application.Service.StudentService;
import com.ui.application.application.dto.RequestStudent;
import com.ui.application.application.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/dashboard")
public class AdminDashboard {

    @Autowired
    private StudentService service;

    @GetMapping("/fetch")
    public ResponseEntity<List<Student>> getAllStudent() {
        List<Student> studentList =  service.getAllStudent();
        return ResponseEntity.ok(studentList);
    }

    @PostMapping("/create/student")
    public ResponseEntity<String> createStudent(@RequestBody RequestStudent student) {
        this.service.createStudent(student);
        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }
}
