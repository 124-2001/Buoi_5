package com.example.buoi5.model.DTO;

import com.example.buoi5.model.Teacher;
import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Set;

@Data
public class ClassDTO {
    private int id;
    private String name;
    private String accountNum;
    private String status;
    private Set<Teacher> teachers;
}
