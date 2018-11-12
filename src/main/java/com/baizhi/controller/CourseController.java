package com.baizhi.controller;

import com.baizhi.entity.Course;
import com.baizhi.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("course")
public class CourseController {
    
    @Autowired
    private CourseService courseService;
    
    @RequestMapping("showAll")
    public @ResponseBody List<Course> findAll(){
        List<Course> courses = courseService.findAll();
        return courses;
    }
}
