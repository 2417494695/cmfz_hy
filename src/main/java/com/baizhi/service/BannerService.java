package com.baizhi.service;

import com.baizhi.entity.Banner;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BannerService {
    List<Banner> findPage(@Param("page") int page,@Param("rows")int rows);
    
    Long findTotals();
    
    void addInfo(Banner banner);
    
    void removeById(String id);
    
    void updateInfo(Banner banner);
    
    Banner findOne(String id);
}
