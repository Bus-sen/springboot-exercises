package com.busra.springbootexercises.service;

import com.busra.springbootexercises.model.Book;
import com.busra.springbootexercises.model.Student;
import com.busra.springbootexercises.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void create(Student student) {
        if (student.getBooks() != null) {   //kitaplara öğrenci bilgisini set ediyoruz
            for (Book book : student.getBooks()) {
                book.setStudent(student);
            }
        }
        studentRepository.save(student);
    }

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public void delete (long id) {
        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
        } else {
            throw new RuntimeException("Student with id " + id + " does not exist");
        }
    }

    public Student update(long id, Student student) {
        if (studentRepository.existsById(id)) {
            Student updatedStudent = studentRepository.findById(id).get();
            updatedStudent.setFirstName(student.getFirstName());
            updatedStudent.setLastName(student.getLastName());
            updatedStudent.setSchoolNumber(student.getSchoolNumber());
            return studentRepository.save(updatedStudent);
        } else {
            throw new RuntimeException("Student with id " + id + " does not exist");
        }
    }

    public List<Student> findByFirstName(String firstName) {
        return studentRepository.findByFirstNameContaining(firstName);
    }

    public Student findBySchoolNumber(long schoolNumber) {
        return studentRepository.findBySchoolNumber(schoolNumber);
    }

    public List<Student> findByFirstNameJPQL(String firstName) {
        return studentRepository.findByFirstNameJPQL(firstName);
    }

    public Student findBySchoolNumberJPQL(long schoolNumber) {
        return studentRepository.findBySchoolNumberJPQL(schoolNumber);
    }

    public List<Student> findByFirstNameNative(String firstName) {
        return studentRepository.findByFirstNameNative(firstName);
    }

    public Student findBySchoolNumberNative(long schoolNumber) {
        return studentRepository.findBySchoolNumberNative(schoolNumber);
    }
}
