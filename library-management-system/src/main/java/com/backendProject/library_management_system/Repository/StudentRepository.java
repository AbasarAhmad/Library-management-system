package com.backendProject.library_management_system.Repository;

import com.backendProject.library_management_system.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Integer> {

        Student findByEmail(String email); // This will return Student details through email id
        List<Student> findByAge(int age); // Return List of student whose age will match
}