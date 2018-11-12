package com.baizhi.controller;

import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {
    
    @Autowired
    private UserService userService;
    
    @RequestMapping("showAll")
    public @ResponseBody List<User> findAll(){
        List<User> users = userService.findAll();
        return users;
    }
    
    @RequestMapping("insert")
    public void insertInfo(HttpServletResponse response, User user) throws IOException {
        userService.addInfo(user);
        response.getWriter().print("success");
    }
    
    @RequestMapping("update")
    public void editInfo(HttpServletResponse response,User user) throws IOException {
        userService.editInfo(user);
        response.getWriter().print("success");
    }
    
    @RequestMapping("login")
    public String login(User user){
        User login = userService.login(user);
        return "redirect:/back/main/main.jsp";
    }
}
