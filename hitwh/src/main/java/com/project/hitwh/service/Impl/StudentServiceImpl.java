package com.project.hitwh.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.hitwh.entity.Student;
import com.project.hitwh.mapper.StudentMapper;
import com.project.hitwh.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentMapper studentMapper;
    
    @Override
    public Student getStudentById(String id) {
        return studentMapper.getStudentById(id);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentMapper.getAllStudents();
    }

    @Override
    public int insertStudent(Student student) {
        return studentMapper.insertStudent(student);
    }

    @Override
    public int findNewestStudentID() {
        return studentMapper.findNewestStudentID();
    }

}
