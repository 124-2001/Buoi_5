package com.example.buoi5.controller;

import com.example.buoi5.model.Course;
import com.example.buoi5.model.DTO.CourseDTO;
import com.example.buoi5.repository.CourseRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {
    @Autowired
    CourseRepository courseRepository;
    @GetMapping("/course/get-all")
    public ResponseEntity<List<Course>> getAll(){
        return ResponseEntity.ok(courseRepository.findAll());
    }
    @PostMapping("/course/insert")
    public ResponseEntity<Course> insertCourse(@RequestBody CourseDTO courseDTO){
        if(!courseRepository.existsById(courseDTO.getId())){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        ModelMapper mapper = new ModelMapper();
        Course course = mapper.map(courseDTO,Course.class);
        courseRepository.save(course);
        return ResponseEntity.ok(course);
    }
    @PostMapping("/course/update")
    public ResponseEntity<Course> updateCourse(@RequestBody CourseDTO courseDTO){
        if(!courseRepository.existsById(courseDTO.getId())){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        Course course = new Course();
        course.setNumberOfLecture(courseDTO.getNumberOfLecture());
        courseRepository.save(course);
        return ResponseEntity.ok(course);
    }
    @DeleteMapping("/course/delete")
    public ResponseEntity<?> deleteCourse(@RequestParam int id){
        if(!courseRepository.existsById(id)){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        courseRepository.delete(courseRepository.findById(id).get());
        return ResponseEntity.ok("Delete OK");
    }

}
