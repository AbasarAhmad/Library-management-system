package com.backendProject.library_management_system.Entity;


import com.backendProject.library_management_system.Enum.CardStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@NoArgsConstructor  // create default constructor
@AllArgsConstructor // create parimetrize constructor
@Setter             // create Setter
@Getter             // Create Getter
public class Librarycard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int cardNo;
    private Date validTill;
    @Enumerated(EnumType.STRING)
    private CardStatus status;

    @OneToOne
    @JoinColumn
    Student student; // connect libraryCard to Student class
}
