package com.backendProject.library_management_system.Controller;

import com.backendProject.library_management_system.Entity.Author;
import com.backendProject.library_management_system.Service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    AuthorService authorService;
    @PostMapping("/add")
    public String addAuthor(@RequestBody Author author)
    {
        authorService.addAuthor(author);
        return "Author added successfully";
    }
}

