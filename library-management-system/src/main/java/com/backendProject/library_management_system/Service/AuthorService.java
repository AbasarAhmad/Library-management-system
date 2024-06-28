package com.backendProject.library_management_system.Service;

import com.backendProject.library_management_system.Entity.Author;
import com.backendProject.library_management_system.Repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    @Autowired
    AuthorRepository authorRepository;
    public void addAuthor(Author author)
    {
        authorRepository.save(author);
    }
}
