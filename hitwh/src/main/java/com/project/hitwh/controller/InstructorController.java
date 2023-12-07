package com.project.hitwh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.hitwh.entity.Instructor;
import com.project.hitwh.service.InstructorService;

@RestController
@CrossOrigin("*")
@RequestMapping("/instructors")
public class InstructorController {

    @Autowired
    private InstructorService instructorService;
    
    @GetMapping("/{id}")
    public ResponseEntity<Instructor> getInstructorById(@PathVariable String id) {
        Instructor instructor = instructorService.getInstructorById(id);
        return ResponseEntity.ok(instructor);
    }
    
    @GetMapping
    public ResponseEntity<List<Instructor>> getAllInstructors() {
        List<Instructor> instructors = instructorService.getAllInstructors();
        return ResponseEntity.ok(instructors);
    }
    
    @PostMapping
    public ResponseEntity<Integer> insertInstructor(@RequestBody Instructor instructor) {
        int result = instructorService.insertInstructor(instructor);
        return ResponseEntity.ok(result);
    }
}
