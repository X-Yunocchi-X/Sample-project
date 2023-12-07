package com.project.hitwh.service.Impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.hitwh.entity.Company;
import com.project.hitwh.entity.RolePointer;
import com.project.hitwh.entity.Student;
import com.project.hitwh.mapper.RoleMapper;
import com.project.hitwh.service.AuthorizeService;
import com.project.hitwh.service.CompanyService;
import com.project.hitwh.service.StudentService;

@Service
public class AuthorizeServiceImpl implements AuthorizeService {
    
    @Autowired
    private RoleMapper roleMapper;
    
    @Autowired
    private CompanyService companyService;

    @Autowired
    private StudentService studentService;
    
    private void registerCompany(String account, String password, Map<String, Object> addition) {
        String name = (String) addition.get("name");
        String address = (String) addition.get("address");
        companyService.insertCompany(new Company(-1, name, address));
        int companyID = companyService.findNewestCompanyID();
        roleMapper.insertRole(account, password, "Company", companyID);
    }
    
    private void registerStudent(String account, String password, Map<String, Object> addition) {
        String name = (String) addition.get("name");
        String gender = (String) addition.get("gender");
        String occupation = (String) addition.get("occupation");
        String level = (String) addition.get("level");
        int companyID = (int) addition.get("company_id");
        studentService.insertStudent(new Student(-1, name, gender, occupation, level, companyID, false));
        int studentID = studentService.findNewestStudentID();
        roleMapper.insertRole(account, password, "Student", studentID);
    }

    @Override
    public void register(int role, String account, String password, Map<String, Object> addition) {
        if (role == 0) {
            registerCompany(account, password, addition);
        } else if (role == 1) {
            registerStudent(account, password, addition);
        }
    }

    @Override
    public RolePointer login(String account, String password) {
        return roleMapper.getRolePointerByAccountAndPassword(account, password);
    }

}
