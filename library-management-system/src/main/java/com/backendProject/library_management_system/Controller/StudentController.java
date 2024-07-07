package com.backendProject.library_management_system.Controller;

import DTO.StudentResponseDto;
import DTO.StudentUpdateEmailRequestDto;
import com.backendProject.library_management_system.Entity.Student;
import com.backendProject.library_management_system.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/add")
    public String addStudent(@RequestBody Student student)
    {
        studentService.addStudent(student);
        return "Student has been save";
    }
    @GetMapping("/find_by_email")
    public String findStudentByEmail(@RequestParam("email") String email)
    {
        return studentService.findByEmail(email);
    }
    // get student of perticular age


    // try for some other attributes

    @PutMapping("/update_email")
   public StudentResponseDto updateEmail(@RequestBody StudentUpdateEmailRequestDto studentUpdateEmailRequestDto)
    {
        return studentService.updateEmail(studentUpdateEmailRequestDto);
    }
}
