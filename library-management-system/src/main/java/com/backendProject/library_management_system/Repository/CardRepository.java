package com.backendProject.library_management_system.Repository;

import com.backendProject.library_management_system.Entity.Librarycard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Librarycard,Integer> {
}
