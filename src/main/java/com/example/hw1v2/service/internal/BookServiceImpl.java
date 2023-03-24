package com.example.hw1v2.service.internal;

import com.example.hw1v2.model.Book;
import com.example.hw1v2.repository.BookRepository;
import com.example.hw1v2.service.BookService;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
    //BookRepository bookRepository;
    //@Autowired
    BookRepository br;
    public BookServiceImpl(BookRepository bookRepository) {
        this.br = bookRepository;
    }

    @Override
    public Book findBook(String ISBN) {
        return br.findById(ISBN).orElse(null);
    }

    @Override
    public Book addBook(Book book) {
        return br.save(book);
    }

    @Override
    public Book updateBook(Book book) {
        return br.save(book);
    }


}
