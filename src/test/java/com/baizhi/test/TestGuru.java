package com.baizhi.test;

import com.baizhi.dao.GuruDao;
import com.baizhi.entity.Guru;
import com.baizhi.service.GuruService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class TestGuru {
    
    @Autowired
    private GuruService guruService;
    
    @Test
    public void testquery(){
        List<Guru> page = guruService.findPage(2, 1);
        for (Guru guru : page) {
            System.out.println(guru);
        }
    }
    
    @Test
    public void testAdd(){
        Guru guru = new Guru();
        guru.setHeadPic("");
        guru.setName("zhangsan");
        guru.setStatus("1");
        guruService.addGuru(guru);
    }
}
