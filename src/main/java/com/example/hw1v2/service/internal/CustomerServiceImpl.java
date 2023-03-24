package com.example.hw1v2.service.internal;

import com.example.hw1v2.model.Customer;
import com.example.hw1v2.repository.BookRepository;
import com.example.hw1v2.repository.CustomerRepository;
import com.example.hw1v2.service.CustomerService;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
    CustomerRepository cr;

    public CustomerServiceImpl(CustomerRepository cr){
        this.cr = cr;
    }
    @Override
    public Customer addCustomer(Customer customer) {
        return cr.save(customer);
    }

    @Override
    public Customer findCustomerByID(int ID) {
        return cr.findById(Integer.toString(ID)).orElse(null);
    }

    @Override
    public Customer findCustomerByEmail(String email) {
        return cr.findByUserId(email);
    }
}
