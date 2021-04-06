package com.codegym.service;


import com.codegym.entities.City;

public interface ICityService {
    Iterable<City> findAll();

    void create(City city);

    void update(City city);

    void delete(Long id);

    City findCityById(Long id);

}
