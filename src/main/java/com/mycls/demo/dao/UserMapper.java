package com.mycls.demo.dao;


import com.mycls.demo.entities.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


@Repository
@Mapper
public interface UserMapper {
    User login(String username, String password);

    int register(String username,String password);
}
