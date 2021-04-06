package com.codegym.repositories;

import com.codegym.entities.City;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ICityRepo extends PagingAndSortingRepository<City,Long> {
}
