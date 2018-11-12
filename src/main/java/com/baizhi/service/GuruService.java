package com.baizhi.service;

import com.baizhi.entity.Guru;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GuruService {
    List<Guru> findPage(@Param("page")int page,@Param("rows") int rows);
    
    Long findTotals();
    
    void addGuru(Guru guru);
    
    void removeById(String id);
    
    List<Guru> findAll();
}
