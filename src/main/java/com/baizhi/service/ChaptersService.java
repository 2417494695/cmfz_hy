package com.baizhi.service;

import com.baizhi.entity.Chapters;

import java.util.List;

public interface ChaptersService {
    
    void addInfo(Chapters chapters);
    
    void removeById(String id);
    
    List<Chapters> findAll();
}
