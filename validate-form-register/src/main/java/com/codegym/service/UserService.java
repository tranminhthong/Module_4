package com.codegym.service;

import com.codegym.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class UserService implements IUserService {
    @PersistenceContext
    EntityManager em;

    @Override
    @Transactional
    public void register(User user) {
        em.persist(user);
    }


}
