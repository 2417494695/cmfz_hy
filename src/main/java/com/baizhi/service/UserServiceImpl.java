package com.baizhi.service;

import com.baizhi.dao.UserDao;
import com.baizhi.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    
    @Autowired
    private UserDao userDao;

    @Override
    public List<User> findAll() {
        List<User> users = userDao.queryAll();
        return users;
    }

    @Override
    public void addInfo(User user) {
        user.setId(UUID.randomUUID().toString());
        user.setBir(new Date());
        userDao.insertInfo(user);
    }

    @Override
    public void editInfo(User user) {
        user.setBir(new Date());
        userDao.updateInfo(user);
    }

    @Override
    public User login(User user) {
        User user1 = userDao.queryOne(user);
        return user1;
    }
}
