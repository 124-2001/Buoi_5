package com.example.buoi5.controller;

import com.example.buoi5.model.DTO.TeacherDTO;
import com.example.buoi5.model.Teacher;
import com.example.buoi5.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TeacherController {
    @Autowired
    TeacherRepository teacherRepository;

    @GetMapping("/teacher/get-all")
    public ResponseEntity<List<Teacher>> getAllTeacher(){
        return ResponseEntity.ok(teacherRepository.findAll());
    }

    @PostMapping("/teacher/insert")
    public ResponseEntity<?> ínsertTeacher(@RequestBody TeacherDTO teacherDTO){
        Teacher teacher = new Teacher();
        if(!teacherRepository.findById(teacherDTO.getId()).isPresent()){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        teacher.setName(teacherDTO.getName());
        teacher.setAccountNum(teacher.getAccountNum());
        teacherRepository.save(teacher);
        return ResponseEntity.ok("Insert OK");
    }
    @PostMapping("/teacher/update")
    public ResponseEntity<?> updateTeacher(@RequestBody TeacherDTO teacherDTO){
        if(!teacherRepository.findById(teacherDTO.getId()).isPresent()){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        Teacher teacher = teacherRepository.findById(teacherDTO.getId()).get();
        teacher.setName(teacherDTO.getName());
        teacher.setAccountNum(teacherDTO.getAccountNum());
        teacherRepository.save(teacher);
        return ResponseEntity.ok("Update OK");
    }
    @DeleteMapping("/teacher/delete")
    public ResponseEntity<?> deleteTeacher(@RequestParam int id){
        if(!teacherRepository.findById(id).isPresent()){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        teacherRepository.delete(teacherRepository.findById(id).get());
        return ResponseEntity.ok("Delete Ok");
    }

}
