package com.example.hw1v2.service;

import com.example.hw1v2.model.Book;

public interface BookService {

    Book findBook(String ISBN);

    Book addBook(Book book);

    Book updateBook(Book book);
}
