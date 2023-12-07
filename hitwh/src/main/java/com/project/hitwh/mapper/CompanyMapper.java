package com.project.hitwh.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.project.hitwh.entity.Company;
import com.project.hitwh.entity.Course;

@Mapper
public interface CompanyMapper {

    @Select("select * from Companies where CompanyID = #{id}")
    Company getCompanyNameByID(String id);
    
    @Select("select c.* from Courses c join CompanyCourses cc on c.CourseID = cc.CourseID where cc.CompanyID = #{id}")
    List<Course> getCoursesByCompanyID(String id);
    
    @Insert("insert into Companies(CompanyName) values(#{companyName})")
    int insertCompany(Company company);

    @Select("select max(CompanyID) from Companies")
    int findNewestCompanyID();

    @Delete("delete from Companies where CompanyID = #{id}")
    int deleteCompanyByID(String id);

    @Select("select * from Companies")
    List<Company> getAllCompanies();
    
}
