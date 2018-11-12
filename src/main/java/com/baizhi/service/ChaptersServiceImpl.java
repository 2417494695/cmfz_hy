package com.baizhi.service;

import com.baizhi.dao.ChaptersDao;
import com.baizhi.entity.Chapters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class ChaptersServiceImpl implements ChaptersService {
    
    @Autowired
    private ChaptersDao chaptersDao;
    
    @Override
    public void addInfo(Chapters chapters) {
        chapters.setId(UUID.randomUUID().toString());
        chaptersDao.insertInfo(chapters);    
    }

    @Override
    public void removeById(String id) {
        chaptersDao.deleteById(id);
    }

    @Override
    public List<Chapters> findAll() {
        List<Chapters> chapters = chaptersDao.queryAll();
        return chapters;
    }
}
