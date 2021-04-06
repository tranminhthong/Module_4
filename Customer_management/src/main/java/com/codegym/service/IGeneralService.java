package com.codegym.service;

import com.codegym.entities.Customer;
import com.codegym.service.exception.DuplicateEmailException;

import java.util.List;

public interface IGeneralService<T> {
    Iterable<T> findAll();

    T findById(Long id) throws Exception;

    Customer save(T t) throws DuplicateEmailException;

    void remove(Long id);
}
