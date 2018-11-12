package com.baizhi.test;

import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class TestUser {
    
    @Autowired
    private UserService userService;
    
    @Test
    public void tesQuery(){

        List<User> users = userService.findAll();
        for (User user : users) {
            System.out.println(user);
        }
    }
    
    @Test
    public void testquery1(){
        User user = new User();
        user.setUsername("张三");
        user.setPassword("123456");
        User user1 = userService.login(user);
        System.out.println(user1);
        if(user1==null){
            System.out.println("用户名密码不正确");
        }else{
            System.out.println("登陆成功");
        }
    }
}
