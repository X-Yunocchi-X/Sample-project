package com.project.hitwh.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.hitwh.entity.Company;
import com.project.hitwh.entity.Course;
import com.project.hitwh.mapper.CompanyMapper;
import com.project.hitwh.service.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService{
    
    @Autowired
    private CompanyMapper companyMapper;

    @Override
    public Company getCompanyNameByID(String id) {
        return companyMapper.getCompanyNameByID(id);
    }

    @Override
    public List<Course> getCoursesByCompanyID(String id) {
        return companyMapper.getCoursesByCompanyID(id);
    }

    @Override
    public int insertCompany(Company company) {
        return companyMapper.insertCompany(company);
    }

    @Override
    public int findNewestCompanyID() {
        return companyMapper.findNewestCompanyID();
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyMapper.getAllCompanies();
    }

    @Override
    public int deleteCompanyByID(String id) {
        return companyMapper.deleteCompanyByID(id);
    }

}
