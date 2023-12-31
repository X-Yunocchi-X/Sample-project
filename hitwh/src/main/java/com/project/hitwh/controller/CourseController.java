package com.project.hitwh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.hitwh.entity.Course;
import com.project.hitwh.service.CourseService;

@RestController
@CrossOrigin("*")
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
    
    // delete course by id, AND delete course from company_course table
    // the company should use CompanyController.removeCourseByID to remove course
    @DeleteMapping("/{id}")
    public ResponseEntity<Integer> deleteCourse(@PathVariable("id") String courseId) {
        int result = courseService.deleteCourseById(courseId);
        return ResponseEntity.ok(result);
    }
    
}
