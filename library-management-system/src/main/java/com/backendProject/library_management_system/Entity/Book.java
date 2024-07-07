package com.backendProject.library_management_system.Entity;

import com.backendProject.library_management_system.Enum.Genre;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private int price;

    @Enumerated(EnumType.STRING)
    private Genre genre;
    private boolean isIssued;

    @ManyToOne
    @JoinColumn
    Author author;

    // Make book class , parent class of transaction class
    @OneToMany(mappedBy = "book" ,cascade = CascadeType.ALL) // iska matlb mai ki child class mai "book" naame se map kiya gya hai Book clas ko
            List<Transaction> transaction=new ArrayList<>();

    // Book to Librarycard relation
    @ManyToOne
    @JoinColumn
    Librarycard card;

}
