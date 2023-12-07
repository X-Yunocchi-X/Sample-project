package com.project.hitwh.service;

import java.util.List;

import com.project.hitwh.entity.Instructor;

public interface InstructorService {

    Instructor getInstructorById(String id);
    
    List<Instructor> getAllInstructors();
    
    int insertInstructor(Instructor instructor);
}
