package com.Online.Book.Ordering.System.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Online.Book.Ordering.System.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
}