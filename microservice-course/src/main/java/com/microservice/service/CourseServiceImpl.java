package com.microservice.service;

import com.microservice.entities.Course;
import com.microservice.persistence.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements  CourseService{

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<Course> findAll() {
        return (List<Course>) courseRepository.findAll();
    }

    @Override
    public Course findById(Long id) {
        return courseRepository.findById(id).orElseThrow();
    }

    @Override
    public void  save(Course course) {
        courseRepository.save(course);
    }
}
