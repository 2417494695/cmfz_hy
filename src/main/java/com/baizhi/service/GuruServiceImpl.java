package com.baizhi.service;

import com.baizhi.dao.GuruDao;
import com.baizhi.entity.Guru;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class GuruServiceImpl implements GuruService {
    
    @Autowired
    private GuruDao guruDao;
    
    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Guru> findPage(int page, int rows) {
        int start=(page-1)*rows;
        List<Guru> gurus = guruDao.queryPageAll(start,rows);
        return gurus;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Long findTotals() {
        return guruDao.queryTotalAll();
    }

    @Override
    public void addGuru(Guru guru) {
        guru.setId(UUID.randomUUID().toString());
        guruDao.insertInfo(guru);
    }

    @Override
    public void removeById(String id) {
        guruDao.deleteById(id);
    }

    @Override
    public List<Guru> findAll() {
        List<Guru> gurus = guruDao.queryAll();
        return gurus;
    }

}
