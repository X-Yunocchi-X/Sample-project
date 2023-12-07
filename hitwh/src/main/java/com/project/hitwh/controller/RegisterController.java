package com.project.hitwh.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.hitwh.service.AuthorizeService;

@RestController
@CrossOrigin("*")
@RequestMapping("/register")
public class RegisterController {
    
    @Autowired
    private AuthorizeService authorizeService;

    // 前端提供的json为    {
    //     account: "123",
    //     password: "123",
    //     role: 0, // or 1, 0 means company, 1 means student
    //     addition: {
    //         name: "123",
    //         address: "123",
    //     }
    //     if role is 1, then addtion is:
    //     addition: {
    //         name: "123",
    //         gender: "123",
    //         occupation: "123",
    //         level: "123",
    //         company_id: "123",
    //     }
    // }
    @PostMapping
    public ResponseEntity<?> register(@RequestBody JsonNode jsonNode) {
        ObjectMapper mapper = new ObjectMapper();
        int role = jsonNode.get("role").asInt();
        String account = jsonNode.get("account").asText();
        String password = jsonNode.get("password").asText();
        JsonNode additionNode = jsonNode.get("addition");
        Map<String, Object> addition = mapper.convertValue(additionNode, new TypeReference<Map<String, Object>>(){});
        authorizeService.register(role, account, password, addition);
        return ResponseEntity.ok().build();
    }

}
