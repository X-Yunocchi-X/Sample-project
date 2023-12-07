package com.project.hitwh.service;

import java.util.List;

import com.project.hitwh.entity.Company;
import com.project.hitwh.entity.Course;

public interface CompanyService {

    public Company getCompanyNameByID(String id);
    
    public List<Course> getCoursesByCompanyID(String id);
    
    public int insertCompany(Company company);
    
    public int findNewestCompanyID();

}
