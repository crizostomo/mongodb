package com.youtube.mongodb.service;

import com.youtube.mongodb.model.StudentRequest;
import com.youtube.mongodb.model.StudentResponse;
import com.youtube.mongodb.persistence.entity.Student;
import com.youtube.mongodb.persistence.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public StudentResponse create(StudentRequest request) {
        Student student = new Student();
        student.setName(request.getName());
        student.setDocument(request.getDocument());
        student.setBirthDate(request.getBirthDate());

        studentRepository.save(student);

        return createResponse(student);

    }

    private StudentResponse createResponse(Student student) {

        StudentResponse response = new StudentResponse();
        response.setId(student.getId());
        response.setName(student.getName());
        response.setDocument(student.getDocument());
        response.setBirthDate(student.getBirthDate());

        return response;

    }

    @Override
    public List<StudentResponse> getAll() {
        List<StudentResponse> responses = new ArrayList<>();

        List<Student> students = studentRepository.findAll();

        if(!students.isEmpty()){
            students.forEach(student -> responses.add(createResponse(student)));
        }

        return responses;
    }
}
