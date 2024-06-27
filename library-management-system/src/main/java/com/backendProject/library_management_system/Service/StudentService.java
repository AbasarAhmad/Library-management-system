package com.backendProject.library_management_system.Service;

import com.backendProject.library_management_system.Entity.Student;
import com.backendProject.library_management_system.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public void addStudent(Student student){
        studentRepository.save(student);
    }
}
