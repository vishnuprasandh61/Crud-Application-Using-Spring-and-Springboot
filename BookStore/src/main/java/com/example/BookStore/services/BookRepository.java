package com.example.BookStore.services;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.BookStore.models.Book;

public interface BookRepository extends JpaRepository<Book, Integer>
{

}
