package com.baizhi.service;

import com.baizhi.entity.Admin;
import org.apache.ibatis.annotations.Param;

public interface AdminService {
    Admin findAdmin(Admin admin);
    
    void editPwd( @Param("id") String id,@Param("password") String password);
}
