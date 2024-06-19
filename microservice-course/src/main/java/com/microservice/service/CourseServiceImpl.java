package com.microservice.service;

import com.microservice.client.StudentClient;
import com.microservice.dto.StudentDto;
import com.microservice.entities.Course;
import com.microservice.http.response.StudentByCourseResponse;
import com.microservice.persistence.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements  CourseService{

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private StudentClient studentClient;

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

    @Override
    public StudentByCourseResponse findStudentsByCourse(Long courseId) {
        //consultar el curso
        Course course = courseRepository.findById(courseId).orElse( new Course());
        //consultar los estudiantes del curso
        List<StudentDto> students = studentClient.findAllStudentsByCourseId(courseId);
        return StudentByCourseResponse.builder()
                .courseName(course.getName())
                .teacher(course.getTeacher())
                .students(students)
                .build();
    }
}
