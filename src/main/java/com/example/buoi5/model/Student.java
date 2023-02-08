package com.example.buoi5.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.core.SpringVersion;

import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;
    private String phone;
    @Column(columnDefinition = "varchar(30) default 'studying'")
    private String status;
    @ManyToMany(mappedBy = "students")
    private Set<Course> courses;

}
