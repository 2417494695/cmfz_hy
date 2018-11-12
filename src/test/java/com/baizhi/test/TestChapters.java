package com.baizhi.test;

import com.baizhi.entity.Chapters;
import com.baizhi.service.ChaptersService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class TestChapters {
    @Autowired
    private ChaptersService chaptersService;

    @Test
    public void testfindAll(){
        List<Chapters> chapters = chaptersService.findAll();
        for (Chapters chapter : chapters) {
            System.out.println(chapter);
        }
    }
    
    @Test
    public void delete(){
        chaptersService.removeById("ca84264f-1a0d-44f9-9d5d-b280ebc73f31");
    }
}
