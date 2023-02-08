package com.example.buoi5;

import com.example.buoi5.model.ClassTechMaster;
import com.example.buoi5.model.Course;
import com.example.buoi5.model.Student;
import com.example.buoi5.model.Teacher;
import com.example.buoi5.repository.ClassTechMasterRepository;
import com.example.buoi5.repository.CourseRepository;
import com.example.buoi5.repository.StudentRepository;
import com.example.buoi5.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Set;

@SpringBootApplication
public class Buoi5Application implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(Buoi5Application.class, args);
    }
    @Autowired
    ClassTechMasterRepository classTechMasterRepository;
    @Autowired
    TeacherRepository teacherRepository;
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    CourseRepository courseRepository;
    @Override
    public void run(String... args) throws Exception {



        /*Teacher teacher = new Teacher();
        teacher.setAccountNum("");
        teacher.setName("Dat");
        //teacher.setClassTechMasters(Set.of(classTechMaster));

        Teacher teacher2 = new Teacher();
        teacher2.setAccountNum("");
        teacher2.setName("Quang");
        //teacher2.setClassTechMasters(Set.of(classTechMaster));

        ClassTechMaster classTechMaster = new ClassTechMaster();
        classTechMaster.setName("Java 14");
        classTechMaster.setTeachers(Set.of(teacher,teacher2));

        teacherRepository.saveAll(Arrays.asList(teacher,teacher2));
        classTechMasterRepository.save(classTechMaster);

        *//*Course course = new Course();
        course.setNumberOfLecture(100);
        Course course1 = new Course();
        course1.setNumberOfLecture(200);

        Student student = new Student();
        student.setName("Nam");
        student.setEmail("nam@Gmail.com");
        student.setPhone("01234567");
        student.setCourses(Set.of(course1));

        Student student1 = new Student();
        student1.setName("Long");
        student1.setEmail("long1234@Gmail.com");
        student1.setPhone("08765428");
        student1.setCourses(Set.of(course1,course));

        courseRepository.saveAll(Arrays.asList(course,course1));
        studentRepository.saveAll(Arrays.asList(student,student1));*//*
*/

    }
}
