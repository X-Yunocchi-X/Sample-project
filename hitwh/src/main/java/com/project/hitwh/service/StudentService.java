package com.project.hitwh.service;

import java.util.List;

import com.project.hitwh.entity.Student;

public interface StudentService {
    
    Student getStudentById(String id);
    
    List<Student> getAllStudents();

    int insertStudent(Student student);
    
    int findNewestStudentID();

}
