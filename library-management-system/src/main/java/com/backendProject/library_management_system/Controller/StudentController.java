package com.backendProject.library_management_system.Controller;

import com.backendProject.library_management_system.Entity.Student;
import com.backendProject.library_management_system.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService


    @PutMapping("/add")
    public String addStudent(@RequestBody Student student)
    {
        studentService.addStudent(student);
        return "Student has been save";
    }
}
