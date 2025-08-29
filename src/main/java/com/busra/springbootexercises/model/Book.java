package com.busra.springbootexercises.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String author;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    @JsonBackReference  //(DTO kullanılmadığında) sonsuz döngüye girmeyi engeller
    private Student student;
}
