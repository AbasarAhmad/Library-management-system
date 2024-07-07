package com.backendProject.library_management_system.Service;

import DTO.StudentResponseDto;
import DTO.StudentUpdateEmailRequestDto;
import com.backendProject.library_management_system.Entity.Librarycard;
import com.backendProject.library_management_system.Entity.Student;
import com.backendProject.library_management_system.Enum.CardStatus;
import com.backendProject.library_management_system.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public void addStudent(Student student){
        // set the value of card
        Librarycard card =new Librarycard();
        card.setStatus(CardStatus.ACTIVATE);
        card.setValidTill("03/2025");
        card.setStudent(student); // librarycard mai  jo student hai ye uske liye hai

        //set the card attribute in student
        student.setCard(card);   // Student class mai jo card hai ye usko set krta hai

        studentRepository.save(student);
    }

    public String findByEmail(String email)
    {
        Student student=studentRepository.findByEmail(email); // Now The student is access whichs email id is
        return student.getName();// Now we access the name of the student
    }


    // Update Email with the help of Id
    public StudentResponseDto updateEmail(StudentUpdateEmailRequestDto studentUpdateEmailRequestDto)
    {
        Student student=studentRepository.findById(studentUpdateEmailRequestDto.getId()).get();// here we access the student which id we get
        student.setEmail(studentUpdateEmailRequestDto.getEmail());// we set new email to that  student which id we get

        // Update new email in repository
        Student updateStudent=studentRepository.save(student);

        //convert  updated student to StudentResponseDto for access , student mai bahut sare field hai but jo hamai chahiye vahi return krainge ResponseDto mai
        StudentResponseDto studentResponseDto=new StudentResponseDto();
        studentResponseDto.setId(updateStudent.getId()); // we set id,  in studentResponseDto for access;
        studentResponseDto.setName(updateStudent.getName());
        studentResponseDto.setEmail(updateStudent.getEmail());
        return studentResponseDto;

    }
}
