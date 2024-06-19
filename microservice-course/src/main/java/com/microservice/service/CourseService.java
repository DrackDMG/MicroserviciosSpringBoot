package com.microservice.service;

import com.microservice.entities.Course;
import com.microservice.http.response.StudentByCourseResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CourseService {
    public List<Course> findAll();

    public Course findById(Long id);

    void save(Course course);

    StudentByCourseResponse findStudentsByCourse(Long courseId);
}
