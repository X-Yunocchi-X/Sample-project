package com.project.hitwh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.project.hitwh.entity.Course;
import com.project.hitwh.service.CourseService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;
    
    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable String id) {
        Course course = courseService.getCourseById(id);
        return ResponseEntity.ok(course);
    }
    
    @GetMapping
    public ResponseEntity<List<Course>> getAllCourses() {
        List<Course> courses = courseService.getAllCourses();
        return ResponseEntity.ok(courses);
    }
    
    @PostMapping
    public ResponseEntity<Integer> insertCourse(@RequestBody Course course) {
        int result = courseService.insertCourse(course);
        return ResponseEntity.ok(result);
    }
}
