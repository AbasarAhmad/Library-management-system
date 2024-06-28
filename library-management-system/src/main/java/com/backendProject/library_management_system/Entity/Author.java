package com.backendProject.library_management_system.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor  // create default constructor
@AllArgsConstructor // create parimetrize constructor
@Setter             // create Setter
@Getter
@Entity             // it will be create table , Author in database;
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int age;
    private String mobNo;
    private String email;


    // Means One Author to Many book mapping , One yaha atuthor class and many for book class
    @OneToMany(mappedBy = "author",cascade = CascadeType.ALL)
    List<Book>books=new ArrayList<>();
}
