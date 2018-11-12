package com.baizhi.service;

import com.baizhi.entity.User;

import java.util.List;

public interface UserService {
    
    List<User> findAll();
    
    void addInfo(User user);
    
    void editInfo(User user);
    
    User login(User user);
}
