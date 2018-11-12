package com.baizhi.dao;

import com.baizhi.entity.User;

public interface UserDao extends BsicDao<User> {
    User queryOne(User user);
}
