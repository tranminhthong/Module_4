package com.codegym.service;

import com.codegym.entities.Customer;
import com.codegym.entities.Province;
import com.codegym.repository.IProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ProvinceService implements IProvinceService{
   @Autowired
   private IProvinceRepository provinceRepository;

    @Override
    public Iterable<Province> findAll() {
        return provinceRepository.findAll();
    }

    @Override
    public Province findById(Long id) {
        return provinceRepository.findById(id).get();
    }

    @Override
    public Customer save(Province province) {
        provinceRepository.save(province);
        return null;
    }

    @Override
    public void remove(Long id) {
        provinceRepository.deleteById(id);
    }
}
