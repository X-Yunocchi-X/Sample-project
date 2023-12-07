package com.project.hitwh.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.hitwh.entity.Course;
import com.project.hitwh.mapper.CourseMapper;
import com.project.hitwh.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService{

    @Autowired
    CourseMapper courseMapper;
    
    @Override
    public Course getCourseById(String id) {
        return courseMapper.getCourseById(id);
    }

    @Override
    public List<Course> getAllCourses() {
        return courseMapper.getAllCourses();
    }

    @Override
    public int insertCourse(Course course) {
        return courseMapper.insertCourse(course);
    }

}
