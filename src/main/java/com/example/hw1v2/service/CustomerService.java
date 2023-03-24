package com.example.hw1v2.service;


import com.example.hw1v2.model.Customer;

public interface CustomerService {
    Customer addCustomer(Customer customer);
    Customer findCustomerByID(int ID);

    Customer findCustomerByEmail(String email);
}
