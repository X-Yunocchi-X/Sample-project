package com.project.hitwh.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.project.hitwh.entity.Course;

@Mapper
public interface CourseMapper {

    @Select("select * from Courses where CourseID = #{id}")
    Course getCourseById(String id);

    @Select("select * from Courses")
    List<Course> getAllCourses();
    
    @Insert("insert into Courses(CourseName, StartDate, DurationDays, InstructorID) values(#{courseName}, #{startDate}, #{durationDays}, #{instructorID})")
    int insertCourse(Course course);

    @Delete("delete from Courses where CourseID = #{id}")
    int deleteCourseById(String id);

}
