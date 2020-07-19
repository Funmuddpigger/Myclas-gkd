package com.mycls.demo.service;


import com.mycls.demo.dao.UserMapper;
import com.mycls.demo.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public User login(User user) {
        user = this.userMapper.login(user.getUsername(), user.getPassword());
        return user;
    }

    public int register(User user) {
        int register = 0;
        try {
            register = this.userMapper.register(user.getUsername(), user.getPassword());
            return register;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("aaaaaaaaaaaaaa"+e);
            return 0;
        }

    }

}