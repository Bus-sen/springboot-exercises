package com.busra.springbootexercises.repository;

import com.busra.springbootexercises.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    List<Student> findByFirstNameContaining(String firstName);
    Student findBySchoolNumber(long schoolNumber);

    // JPQL ile firstName’e göre öğrenci arama
    @Query("SELECT s FROM Student s WHERE s.firstName LIKE %:firstName%")
    List<Student> findByFirstNameJPQL(@Param("firstName") String firstName);

    // JPQL ile schoolNumber’a göre öğrenci bulma
    @Query("SELECT s FROM Student s WHERE s.schoolNumber = :schoolNumber")
    Student findBySchoolNumberJPQL(@Param("schoolNumber") long schoolNumber);

    // Native SQL ile firstName bulma
    @Query(value = "SELECT * FROM students s WHERE s.first_name LIKE %:firstName%", nativeQuery = true)
    List<Student> findByFirstNameNative(@Param("firstName") String firstName);

    // Native SQL ile schoolNumber’a göre öğrenci bulma
    @Query(value = "SELECT * FROM students s WHERE s.school_number = :schoolNumber", nativeQuery = true)
    Student findBySchoolNumberNative(@Param("schoolNumber") long schoolNumber);
}
