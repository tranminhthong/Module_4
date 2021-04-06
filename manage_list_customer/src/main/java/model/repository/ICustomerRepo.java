package model.repository;

import model.entities.Customer;

import java.util.List;

public interface ICustomerRepo {
    List<Customer> get();
}
