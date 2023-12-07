package com.project.hitwh.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.hitwh.entity.Instructor;
import com.project.hitwh.mapper.InsturctorMapper;
import com.project.hitwh.service.InstructorService;

@Service
public class InstructorServiceImpl implements InstructorService{

    @Autowired
    InsturctorMapper insturctorMapper;
    
    @Override
    public Instructor getInstructorById(String id) {
        return insturctorMapper.getInstructorById(id);
    }

    @Override
    public List<Instructor> getAllInstructors() {
        return insturctorMapper.getAllInstructors();
    }

    @Override
    public int insertInstructor(Instructor instructor) {
        return insturctorMapper.insertInstructor(instructor);
    }

}
