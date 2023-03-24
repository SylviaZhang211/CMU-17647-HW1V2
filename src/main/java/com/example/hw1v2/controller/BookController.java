package com.example.hw1v2.controller;

import com.example.hw1v2.service.BookService;
import com.example.hw1v2.model.Book;
import com.example.hw1v2.utils.Validation;
import jakarta.validation.Valid;
import org.springdoc.api.ErrorMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BookController {
//    @PostMapping("books")
//    public String addBook(){
//
//    }
    @Autowired
    BookService bookService ;




    //@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping("")
    public ResponseEntity<?> addBook(@Valid @RequestBody Book book, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return new ResponseEntity<>(new ErrorMessage("Missing information"), HttpStatus.BAD_REQUEST);
        } else if(bookService.findBook(book.getISBN()) != null){
            return new ResponseEntity<>(new ErrorMessage("This ISBN already exists in the system."), HttpStatus.UNPROCESSABLE_ENTITY);
        }else if (Validation.checkPrice(book.getPrice())) {
            return new ResponseEntity<>(new ErrorMessage("Malformed input: price"), HttpStatus.BAD_REQUEST);
        }
        //response.setHeader("Location", request.getRequestURL().append("/").append(createdHotel.getId()).toString());
        return new ResponseEntity<>(bookService.addBook(book), HttpStatus.CREATED);
    }

    @PutMapping("{ISBN}")
    public ResponseEntity<?> updateBook(@PathVariable String ISBN, @Valid @RequestBody Book book, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return new ResponseEntity<>(new ErrorMessage("Missing information"), HttpStatus.BAD_REQUEST);
        } else if(bookService.findBook(book.getISBN()) == null){
            return new ResponseEntity<>(new ErrorMessage("ISBN not found"), HttpStatus.NOT_FOUND);
        }else if (Validation.checkPrice(book.getPrice())) {
            return new ResponseEntity<>(new ErrorMessage("Malformed input: price"), HttpStatus.BAD_REQUEST);
        }
        //response.setHeader("Location", request.getRequestURL().append("/").append(createdHotel.getId()).toString());
        return new ResponseEntity<>(bookService.updateBook(book), HttpStatus.OK);

    }

    @GetMapping({"isbn/{ISBN}","{ISBN}"})
    public ResponseEntity<?> getBook(@PathVariable String ISBN){
        var book = bookService.findBook(ISBN);
        if (book != null){

            return new ResponseEntity<>(book, HttpStatus.OK);
        } else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
