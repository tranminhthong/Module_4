package com.codegym.service;

import com.codegym.model.User;
import org.springframework.beans.factory.annotation.Autowired;

public interface IUserService {

    void register(User user);
}
