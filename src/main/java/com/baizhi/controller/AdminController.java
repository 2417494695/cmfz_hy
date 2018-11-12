package com.baizhi.controller;

import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
@RequestMapping("admin")
public class AdminController {
    
    @Autowired 
    private AdminService adminService;
    
    @RequestMapping("login")
    public String login(Admin admin, HttpServletRequest request) {
        String code = request.getParameter("code");
        HttpSession session = request.getSession();
        Admin admin1 = adminService.findAdmin(admin);
        if (admin1 != null && code.equalsIgnoreCase(session.getAttribute("code").toString())) {
            session.setAttribute("admin", admin1);
            return "/back/main/main";
        } else
            return "/back/login";
    }
    
    @RequestMapping("off")
    public String off(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.removeAttribute("admin");
        return "redirect:/back/login.jsp";
    }
    
    @RequestMapping("update")
    public @ResponseBody String update(String password, String password1,HttpServletRequest request){
        Admin admin = (Admin) request.getSession().getAttribute("admin");
        String result;
        if(!password1.equals(password)){
            result="两次密码不一致";
        }else{
            adminService.editPwd(admin.getId(),password);
            result="修改成功";
        }
        return result;
    }
}
