package com.codegym.service;

import com.codegym.entities.Customer;
import com.codegym.entities.Province;
import com.codegym.repository.ICustomerRepository;
import com.codegym.service.exception.DuplicateEmailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public Iterable<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findById(Long id) throws Exception{
        Customer target = customerRepository.findById(id).get();
        if (target == null) {
            throw new Exception("customer not found!");
        }
        return target;
    }

    @Override
    public Customer save(Customer customer) throws DuplicateEmailException {
        try {
            return customerRepository.save(customer);
        } catch (DataIntegrityViolationException e) {
            throw new DuplicateEmailException();
        }

    }

    @Override
    public void remove(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Iterable<Customer> findAllByProvince(Province province) {
        return customerRepository.findAllByProvince(province);
    }

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @Override
    public Page<Customer> findAllByFirstNameContaining(String firstname, Pageable pageable) {
        return  customerRepository.findAllByFirstNameContaining(firstname, pageable);
    }
}
