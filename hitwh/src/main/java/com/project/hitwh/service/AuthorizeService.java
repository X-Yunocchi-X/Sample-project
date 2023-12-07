package com.project.hitwh.service;

import java.util.Map;

import com.project.hitwh.entity.RolePointer;

public interface AuthorizeService {

    public void register(int role, String account, String password, Map<String, Object> addition);
    
    public RolePointer login(String account, String password);
    
}
