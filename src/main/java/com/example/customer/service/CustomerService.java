package com.example.customer.service;

import com.example.customer.model.Customer;

import java.util.List;

public interface CustomerService {
    //    Add a customer
    void add(Customer customer);

    //    Update a customer
    void update(Customer customer);

    //    Get a customer by id
    Customer getById(int id);

    //    Get all customers
    List<Customer> get();

    //    Delete a customer
    void delete(int id);

}
