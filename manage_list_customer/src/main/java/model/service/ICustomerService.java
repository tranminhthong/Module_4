package model.service;

import model.entities.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> getAll();
    boolean delete(int id);
    boolean add(Customer customer);
    boolean update(Customer customer);
}
