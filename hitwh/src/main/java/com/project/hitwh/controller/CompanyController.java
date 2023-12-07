package com.project.hitwh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.hitwh.entity.Company;
import com.project.hitwh.entity.Course;
import com.project.hitwh.service.CompanyService;

@RestController
@CrossOrigin("*")
@RequestMapping("/companies")
public class CompanyController {

    @Autowired
    private CompanyService companyService;
    
    @GetMapping
    public ResponseEntity<List<Company>> getAllCompanies() {
        List<Company> companies = companyService.getAllCompanies();
        return ResponseEntity.ok(companies);
    }

    @PostMapping
    public ResponseEntity<Integer> insertCompany(@RequestBody Company company) {
        int result = companyService.insertCompany(company);
        return ResponseEntity.ok(result);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Company> getCompanyById(@PathVariable String id) {
        Company company = companyService.getCompanyNameByID(id);
        return ResponseEntity.ok(company);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Integer> deleteCompanyById(@PathVariable String id) {
        int result = companyService.deleteCompanyByID(id);
        return ResponseEntity.ok(result);
    }
    
    @GetMapping("/{id}/courses")
    public ResponseEntity<List<Course>> getCoursesByCompanyID(@PathVariable String id) {
        List<Course> courses = companyService.getCoursesByCompanyID(id);
        return ResponseEntity.ok(courses);
    }
    
}
