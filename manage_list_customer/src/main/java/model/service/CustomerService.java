package model.service;

import model.entities.Customer;
import model.repository.ICustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepo customerRepo;

    @Override
    public List<Customer> getAll() {
        List<Customer> customers = customerRepo.get();
        return customers;
    }

    @Override
    public boolean delete(int id) {
        return true;
    }

    @Override
    public boolean add(Customer customer) {
        return  true;
    }

    @Override
    public boolean update(Customer customer) {
        return true;
    }
}
