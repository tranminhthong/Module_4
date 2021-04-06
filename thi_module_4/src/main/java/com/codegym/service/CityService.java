package com.codegym.service;

import com.codegym.entities.City;
import com.codegym.repositories.ICityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
@Transactional
public class CityService implements ICityService{
    @Autowired
    private ICityRepo cityRepo;

    @PersistenceContext
    EntityManager em;

    @Override
    public Iterable<City> findAll() {
        return cityRepo.findAll();
    }

    @Override
    public void create(City city) {
        em.persist(city);
    }

    @Override
    public void update(City city) {
        em.merge(city);
    }

    @Override
    public void delete(Long id) {
        cityRepo.delete(id);
    }

    @Override
    public City findCityById(Long id) {
        return cityRepo.findOne(id);
    }
}
