package com.codegym.dao;

import com.codegym.model.Login;
import com.codegym.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private static List<User> users;
    static {
        users = new ArrayList<>();
        User u1 = new User();
        u1.setAge(24);
        u1.setName("Thong");
        u1.setAccount("thong");
        u1.setEmail("minhthong9711@gmail.com");
        u1.setPassword("123456");
        users.add(u1);
        users.add(new User("tien","123","Tien","tien@gamil.com",25));
        users.add(new User("thai","123","Thai","thai@gamil.com",28));
    }

    public static User checkLogin(Login login){
        for (User user: users){
            if (user.getAccount().equals(login.getAccount()) && user.getPassword().equals(login.getPassword())) {
                return user;
            }
        }
        return null;
    }
}
