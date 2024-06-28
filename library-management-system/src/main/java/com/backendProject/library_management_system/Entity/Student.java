package com.backendProject.library_management_system.Entity;

import com.backendProject.library_management_system.Enum.Department;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.Getter;

@Entity
@NoArgsConstructor  // create default constructor
@AllArgsConstructor // create parimetrize constructor
@Setter             // create Setter
@Getter             // create Getter
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // taki id automatically generate and increment ho
    private int id;
    private String name;
    private int age;

    @Enumerated(EnumType.STRING)
    private Department department;
    private String email;

    @OneToOne(mappedBy = "student",cascade = CascadeType.ALL) // All the crud operation perform in student class
            // this should  perform with child class (card ) as well;
    Librarycard card; // join Student class to Librarycard class
}
