package com.busra.springbootexercises.repository;

import com.busra.springbootexercises.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    List<Student> findByFirstNameContaining(String firstName);
    Student findBySchoolNumber(long schoolNumber);
}
