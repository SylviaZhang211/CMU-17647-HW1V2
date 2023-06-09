package com.example.hw1v2.controller;

import com.example.hw1v2.model.Book;
import com.example.hw1v2.model.Customer;
import com.example.hw1v2.service.BookService;
import com.example.hw1v2.service.CustomerService;
import com.example.hw1v2.utils.Validation;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.api.ErrorMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    CustomerService customerService;


    //@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping("")
    public ResponseEntity<?> addCustomer(@Valid @RequestBody Customer customer, BindingResult bindingResult) {
        log.info(customer.toString());
        log.info(bindingResult.getAllErrors().toString());
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(new ErrorMessage("Missing information"), HttpStatus.BAD_REQUEST);
        } else if (!Validation.checkState(customer.getState())) {
            return new ResponseEntity<>(new ErrorMessage("Malformed input: state"), HttpStatus.BAD_REQUEST);
        } else if (customerService.findCustomerByEmail(customer.getUserId()) != null) {
            return new ResponseEntity<>(new ErrorMessage("This user ID already exists in the system."), HttpStatus.UNPROCESSABLE_ENTITY);
        }

        return new ResponseEntity<>(customerService.addCustomer(customer), HttpStatus.CREATED);
    }


    @GetMapping({"/{id}"})
    public ResponseEntity<?> getCustomerById(@PathVariable int id) {
        var customer = customerService.findCustomerByID(id);
        if (customer != null) {
            return new ResponseEntity<>(customer, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("")
    public ResponseEntity<?> getCustomerByEmail(@RequestParam("userId") String userId) {
        userId = userId.replace("%40", "@");
        var customer = customerService.findCustomerByEmail(userId);
        if (!Validation.checkEmail(userId)) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if (customer != null) {
            return new ResponseEntity<>(customer, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
}
