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

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id){
        studentService.delete(id);
    }

    @PutMapping("/{id}")
    public Student update(@PathVariable long id, @RequestBody Student student){
        return studentService.update(id, student);
    }

    @GetMapping("/search/name/{firstName}")
    public List<Student> findByFirstName(@PathVariable String firstName){
        return studentService.findByFirstName(firstName);
    }

    @GetMapping("/search/number/{schoolNumber}")
    public Student findBySchoolNumber(@PathVariable long schoolNumber){
        return studentService.findBySchoolNumber(schoolNumber);
    }
}
