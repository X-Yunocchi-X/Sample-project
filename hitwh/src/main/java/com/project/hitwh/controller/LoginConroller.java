package com.project.hitwh.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.project.hitwh.entity.RolePointer;
import com.project.hitwh.service.AuthorizeService;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@CrossOrigin("*")
@RequestMapping("/login")
public class LoginConroller {
    
    @Autowired
    private AuthorizeService authorizeService;
    
    // { account: "xxx", password: "xxx" }
    // return { entity: "xxx", entityID: xxx } or null
    // cookie entity: "xxx"|xxx (entity|entityID)
    @PostMapping
    public ResponseEntity<?> login(HttpServletResponse response, @RequestBody JsonNode jsonNode) {
        Cookie cookieTemp = new Cookie("entity", null);
        cookieTemp.setMaxAge(-1);
        response.addCookie(cookieTemp);
        String account = jsonNode.get("account").asText();
        String password = jsonNode.get("password").asText();
        RolePointer rolePointer = authorizeService.login(account, password);
        if (rolePointer == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
        String cookieEntity = rolePointer.entity() + "|" + String.valueOf(rolePointer.entityID());
        Cookie cookie = new Cookie("entity", cookieEntity);
        response.addCookie(cookie);
        return ResponseEntity.ok(rolePointer);
    }

}
