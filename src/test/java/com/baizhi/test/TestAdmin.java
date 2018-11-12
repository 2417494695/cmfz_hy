package com.baizhi.test;

import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class TestAdmin {
    
    @Autowired
    private AdminService adminService;
    
    @Test
    public void testFind(){
        Admin admin = new Admin();
        admin.setName("zhangsan");
        admin.setPassword("aaaaaa");
        System.out.println(adminService.findAdmin(admin));
    }
    
    @Test
    public void testUpdate(){
        adminService.editPwd("aaa","123");
    }
}
