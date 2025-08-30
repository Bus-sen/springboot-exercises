package com.busra.springbootexercises.controller;

import com.busra.springbootexercises.model.Student;
import com.busra.springbootexercises.service.StudentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
/*
    @GetMapping("/search/name/{firstName}")
    public List<Student> findByFirstName(@PathVariable String firstName){
        return studentService.findByFirstName(firstName);
    }
*/
    @GetMapping("/search")
    public Page<Student> findByFirstNameContaining(@RequestParam String firstName, Pageable pageable) {
        return studentService.findByFirstNameContaining(firstName, pageable);
    }

    @GetMapping("/search/number/{schoolNumber}")
    public Student findBySchoolNumber(@PathVariable long schoolNumber){
        return studentService.findBySchoolNumber(schoolNumber);
    }

    @GetMapping("/search/jpql/name/{firstName}")
    public List<Student> findByFirstNameJPQL(@PathVariable String firstName){
        return studentService.findByFirstNameJPQL(firstName);
    }

    @GetMapping("/search/jpql/number/{schoolNumber}")
    public Student findBySchoolNumberJPQL(@PathVariable long schoolNumber){
        return studentService.findBySchoolNumberJPQL(schoolNumber);
    }

    @GetMapping("/search/native/name/{firstName}")
    public List<Student> findByFirstNameNative(@PathVariable String firstName){
        return studentService.findByFirstNameNative(firstName);
    }

    @GetMapping("/search/native/number/{schoolNumber}")
    public Student findBySchoolNumberNative(@PathVariable long schoolNumber){
        return studentService.findBySchoolNumberNative(schoolNumber);
    }

}
