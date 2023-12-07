package com.project.hitwh.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.project.hitwh.entity.Instructor;

@Mapper
public interface InsturctorMapper {
    
    @Select("select * from Instructors where InstructorID = #{id}")
    Instructor getInstructorById(String id);
    
    @Select("select * from Instructors")
    List<Instructor> getAllInstructors();
    
    @Insert("insert into Instructors(Name, Age, Gender) value (#{name}, #{age}, #{gender})")
    int insertInstructor(Instructor instructor);
    
}
