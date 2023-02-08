package com.example.buoi5.controller;

import com.example.buoi5.model.ClassTechMaster;
import com.example.buoi5.model.DTO.ClassDTO;
import com.example.buoi5.model.Teacher;
import com.example.buoi5.repository.ClassTechMasterRepository;
import com.example.buoi5.repository.TeacherRepository;
import jakarta.persistence.GeneratedValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClassTechMasterController {
    @Autowired
    ClassTechMasterRepository classTechMasterRepository;
    @Autowired
    TeacherRepository teacherRepository;
    @GetMapping("/class/get-all")
    public ResponseEntity<List<ClassTechMaster>> getAllClass(){
        return ResponseEntity.ok(classTechMasterRepository.findAll());
    }

    @PostMapping("/class/insert")
    public ResponseEntity<?> insertClass(@RequestBody ClassDTO newClassTechMaster){
        if (classTechMasterRepository.findById(newClassTechMaster.getId()).isPresent()){
            ClassTechMaster classTechMaster = classTechMasterRepository.findById(newClassTechMaster.getId()).get();
            classTechMaster.setName(newClassTechMaster.getName());
            classTechMaster.setAccountNum(newClassTechMaster.getAccountNum());
            /*for (Teacher t : newClassTechMaster.getTeachers()) {
                if(!classTechMasterRepository.findById(t.getId()).isPresent()){
                }
            }*/
            classTechMaster.setTeachers(newClassTechMaster.getTeachers());
            classTechMasterRepository.save(classTechMaster);
        }
        else {
            ClassTechMaster classTechMaster = new ClassTechMaster();
            classTechMaster.setName(newClassTechMaster.getName());
            classTechMaster.setAccountNum(newClassTechMaster.getAccountNum());
            classTechMaster.setTeachers(newClassTechMaster.getTeachers());
            classTechMasterRepository.save(classTechMaster);
        }
        return ResponseEntity.ok("OK");
    }

}
