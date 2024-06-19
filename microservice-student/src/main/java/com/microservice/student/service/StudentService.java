package com.microservice.student.service;

import com.microservice.student.entities.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
    List<Student> findAll();
    Student findById(Long id);
    List<Student> findByCourseId(Long courseId);

    void save(Student student);

}
