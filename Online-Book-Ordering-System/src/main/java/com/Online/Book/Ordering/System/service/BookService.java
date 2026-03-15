package com.Online.Book.Ordering.System.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Online.Book.Ordering.System.entity.Book;
import com.Online.Book.Ordering.System.repository.BookRepository;

@Service
public class BookService {

    @Autowired
    private BookRepository repository;

    public Book addBook(Book book){
        return repository.save(book);
    }

    public List<Book> getBooks(){
        return repository.findAll();
    }

    public Book updateBook(Long id, Book book){

        Book existing = repository.findById(id).orElseThrow();

        existing.setTitle(book.getTitle());
        existing.setAuthor(book.getAuthor());
        existing.setPrice(book.getPrice());
        existing.setStock(book.getStock());

        return repository.save(existing);
    }

    public void reduceStock(Long bookId, int quantity){

        Book book = repository.findById(bookId).orElseThrow();

        book.setStock(book.getStock() - quantity);

        repository.save(book);
    }
}