package com.project.hitwh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.project.hitwh.entity.Company;
import com.project.hitwh.entity.Course;
import com.project.hitwh.service.CompanyService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/companies")
public class CompanyController {

    @Autowired
    private CompanyService companyService;
    
    @GetMapping("/{id}")
    public ResponseEntity<Company> getCompanyById(@PathVariable String id) {
        Company company = companyService.getCompanyNameByID(id);
        return ResponseEntity.ok(company);
    }
    
    @GetMapping("/{id}/courses")
    public ResponseEntity<List<Course>> getCoursesByCompanyID(@PathVariable String id) {
        List<Course> courses = companyService.getCoursesByCompanyID(id);
        return ResponseEntity.ok(courses);
    }
    
    @PostMapping
    public ResponseEntity<Integer> insertCompany(@RequestBody Company company) {
        int result = companyService.insertCompany(company);
        return ResponseEntity.ok(result);
    }
}
