package com.youtube.mongodb.controller;

import com.youtube.mongodb.model.StudentRequest;
import com.youtube.mongodb.model.StudentResponse;
import com.youtube.mongodb.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public ResponseEntity<StudentResponse> create(@RequestBody StudentRequest request){
        return ResponseEntity.ok(studentService.create(request));
    }

    @GetMapping
    public ResponseEntity<List<StudentResponse>> getAll(){
        return ResponseEntity.ok(studentService.getAll());
    }
}
