package com.youtube.mongodb.service;

import com.youtube.mongodb.model.StudentRequest;
import com.youtube.mongodb.model.StudentResponse;

import java.util.List;

public interface StudentService {

    StudentResponse create(StudentRequest request);

    List<StudentResponse> getAll();
}
