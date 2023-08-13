package com.api.book.bootrestbook.controllers;

import com.api.book.bootrestbook.entites.Book;
import com.api.book.bootrestbook.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;
import java.util.Optional;

@RestController
public class BookController {
   // @RequestMapping(value = "/books", method = RequestMethod.GET)

   @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getBooks(){ //return object
       // Book book = new Book();
       List <Book>list=bookService.getAllBooks();  //object5
        if(list.size()<=0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(list);
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBook(@PathVariable("id") int id){
        Book book = bookService.getBookById(id);
        if(book==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(book));

    }

    @PostMapping("/books")
    public ResponseEntity<Book>addBook(@RequestBody Book book){
        Book b = null;
              try {
                  b=this.bookService.addBook(book);
                  return ResponseEntity.of(Optional.of(b));
              }catch (Exception e){
                  e.printStackTrace();

              }

              return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();


    }

    @DeleteMapping("/books/{bookId}")
    public ResponseEntity<Void> deleteBook(@PathVariable("bookId") int bookId){
        try {
            this.bookService.deleteBook(bookId);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }



    }
    ///update
    @PutMapping("/books/{bookId}")
    public ResponseEntity<Book> updateBook(@RequestBody Book book,@PathVariable("bookId")int bookId){
      try {
          this.bookService.updateBook(book,bookId );
          return ResponseEntity.ok().body(book);
      }catch (Exception e){
          e.printStackTrace();
          return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

      }

    }





}
