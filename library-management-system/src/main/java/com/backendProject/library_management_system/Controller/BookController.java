package com.backendProject.library_management_system.Controller;


import DTO.BookRequestDto;
import DTO.BookResponseDto;
import com.backendProject.library_management_system.Entity.Book;
import com.backendProject.library_management_system.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    BookService bookService;

   /* @PostMapping("/add")
//    public String addBook(@RequestBody Book book)
//    {
//        try{
//            bookService.addBook(book);
//        }
//        catch (Exception e)
//        {
//            throw new RuntimeException(e.getMessage()+"book is not found");
//        }
//        return "book added succesfully";
//
//    }
    */
   @PostMapping("/add")
    public BookResponseDto addBook(@RequestBody BookRequestDto bookRequestDto) throws Exception {
       return bookService.addBook(bookRequestDto);
    }

}
