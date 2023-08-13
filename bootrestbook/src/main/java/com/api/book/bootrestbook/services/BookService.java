package com.api.book.bootrestbook.services;

import com.api.book.bootrestbook.dao.BookRepository;
import com.api.book.bootrestbook.entites.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    //    private static List<Book> list = new ArrayList<>();
//    static {
//        list.add(new Book(12,"java","XYZ"));
//        list.add(new Book(36,"react js","MNC"));
//        list.add(new Book(129,"java","ABC"));
//
//    }
    //get all book
    public List<Book> getAllBooks() {
        List<Book> list = (List<Book>) this.bookRepository.findAll();
        return list;
    }
    //get single book by id

    public Book getBookById(int id) {
        Book book = null;
        try {
            // book= list.stream().filter(e->e.getId()==id).findFirst().get();
          book=this.bookRepository.findById(id);
        } catch (Exception e) {
            e.printStackTrace();

        }

        return book;
    }

    //add book
    public Book addBook(Book b) {

        Book result = bookRepository.save(b);
        return result;

    }

    //delete method
    public void deleteBook(int bid) {

        // list = list.stream().filter(book -> book.getId()!=bid).
        //   collect(Collectors.toList());
        bookRepository.deleteById(bid);

    }

    //update
    public void updateBook(Book book, int bookId) {
//       list = list.stream().map(b ->{
//            if(b.getId()==bookId){
//                b.setTitle(book.getTitle());
//                b.setAuthor(book.getAuthor());
//
//            }
//            return b;
//        } ).collect(Collectors.toList());
         book.setId(bookId);
        bookRepository.save(book);
    }
}