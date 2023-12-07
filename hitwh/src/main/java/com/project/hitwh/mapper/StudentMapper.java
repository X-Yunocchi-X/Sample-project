package com.project.hitwh.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.project.hitwh.entity.Student;

@Mapper
public interface StudentMapper {

    @Select("select * from Students where StudentID = #{id}")
    Student getStudentById(String id);
    
    @Select("select * from Students")
    List<Student> getAllStudents();

    @Insert("insert into Students(Name, Gender, CompanyOccupation, TechLevel, CompanyID) values (#{name}, #{gender}, #{companyOccupation}, #{techLevel}, #{companyID})")
    int insertStudent(Student student);

    @Select("select max(StudentID) from Students")
    int findNewestStudentID();
}
