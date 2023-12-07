package com.project.hitwh.service;

import java.util.List;

import com.project.hitwh.entity.Course;

public interface CourseService {

    Course getCourseById(String id);

    List<Course> getAllCourses();
    
    int insertCourse(Course course);
    
    int deleteCourseById(String id);
}
