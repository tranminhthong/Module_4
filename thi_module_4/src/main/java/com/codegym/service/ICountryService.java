package com.codegym.service;

import com.codegym.entities.Country;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

@Service
public interface ICountryService {
    @Query("select c from Country c where c.id=:id")
    Country get(Long id);
}
