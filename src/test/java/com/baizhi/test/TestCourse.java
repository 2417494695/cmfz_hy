package com.baizhi.test;

import com.baizhi.entity.Course;
import com.baizhi.service.CourseService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class TestCourse {
    
    @Autowired
    private CourseService courseService;
    
    @Test
    public void textQuery(){
        List<Course> courses = courseService.findAll();
        for (Course cours : courses) {
            System.out.println(cours);
        }
    }
}
