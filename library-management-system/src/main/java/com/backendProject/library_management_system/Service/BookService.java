package com.backendProject.library_management_system.Service;

import DTO.BookRequestDto;
import DTO.BookResponseDto;
import com.backendProject.library_management_system.Entity.Author;
import com.backendProject.library_management_system.Entity.Book;
import com.backendProject.library_management_system.Repository.AuthorRepository;
import com.backendProject.library_management_system.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    AuthorRepository authorRepository;// we need author id that's why we have add authorRepository;
   /*
   // Create method without the help of DTO
    public void addBook(Book book) throws Exception {
        // yaha pe ham book se author id ko select kr rahe hai

        // book.getAuthor() :- it  will return author object
        // book.getAuthor().getId() :- this will give us author ID
        //get() = If a value is present, returns the value, otherwise throws NoSuchElementException.
        Author author;
        try{
        author= authorRepository.findById(book.getAuthor().getId()).get();
        }
        catch (Exception e)
        {
            throw new Exception("Author is not present");
        }

        List<Book> booksWritten=author.getBooks();
        booksWritten.add(book);
        authorRepository.save(author);
    }
    */

    // Create method with the help of DTO
    public BookResponseDto addBook(BookRequestDto bookRequestDto) throws Exception {
        // get the author object
       Author author=authorRepository.findById(bookRequestDto.getAuthorId()).get();

       Book book =new Book();
       book.setTitle(bookRequestDto.getTitle());
       book.setGenre(bookRequestDto.getGenre());
       book.setPrice(bookRequestDto.getPrice());
       book.setIssued(false);
       book.setAuthor(author);

       author.getBooks().add(book);
       authorRepository.save(author); // author is parent ,will save both book and author

        BookResponseDto bookResponseDto=new BookResponseDto();
        bookResponseDto.setTitle(book.getTitle());
        bookResponseDto.setPrice(book.getPrice());

        return  bookResponseDto;

    }
}
