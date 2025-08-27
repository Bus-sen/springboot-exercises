package com.busra.springbootexercises.controller;

import com.busra.springbootexercises.model.Student;
import com.busra.springbootexercises.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/save")
    public void create(@RequestBody Student student) {
        studentService.create(student);
    }

    @GetMapping
    public List<Student> getStudents(){
        return studentService.getStudents();
    }

}
