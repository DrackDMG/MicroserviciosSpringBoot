package com.microservice.controller;

import com.microservice.entities.Course;
import com.microservice.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody Course course){
        courseService.save(course);
    }

    @GetMapping("/{id}")
    public Course findById(@PathVariable Long id){
        return courseService.findById(id);
    }

    @GetMapping
    public List<Course> findAll(){
        return courseService.findAll();
    }

    @GetMapping("/{courseId}/students")
    public ResponseEntity<?> findStudentsByCourse(@PathVariable Long courseId){
        return ResponseEntity.ok(courseService.findStudentsByCourse(courseId));
    }

}
