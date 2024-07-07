package com.backendProject.library_management_system.Entity;


import com.backendProject.library_management_system.Enum.CardStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor  // create default constructor
@AllArgsConstructor // create parimetrize constructor
@Setter             // create Setter
@Getter             // Create Getter
public class Librarycard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cardNo;
    @Enumerated(EnumType.STRING)
    private CardStatus status;

    @CreationTimestamp // this will take date from system at the time of object creation
    private Date creationDate;

    @UpdateTimestamp // if we perform any types of operation then this date will be update
    private Date updationDate;

    @OneToOne
    @JoinColumn
    Student student; // connect libraryCard to Student class

    // make  Librarycard as parent of Transaction
    @OneToMany(mappedBy = "card", cascade = CascadeType.ALL) // Transaction class mai Librarycard entity, card naam ke variable ke through mapped hai
    List<Transaction> transactionList=new ArrayList<>();

    // Naw make Librarycard as parent of book
    @OneToMany(mappedBy = "card", cascade = CascadeType.ALL)
    List<Book>booksIssued=new ArrayList<>();
}