package com.busra.springbootexercises.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstName;
    private String lastName;
    private long schoolNumber;

    @OneToMany (mappedBy = "student", cascade = CascadeType.ALL)
    @JsonManagedReference   //(DTO kullanılmadığında) sonsuz döngüye girmeyi engeller
    private List<Book> books;
}
