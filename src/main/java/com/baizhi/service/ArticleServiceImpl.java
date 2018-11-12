package com.baizhi.service;

import com.baizhi.dao.ArticleDao;
import com.baizhi.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {
    
    @Autowired
    private ArticleDao articleDao;
    
    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Article> findPage(int page, int rows) {
        int start=(page-1)*rows;
        List<Article> articles = articleDao.queryPageAll(start, rows);
        return articles;
    }

    @Override
    public void removeById(String id) {
        articleDao.deleteById(id);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Long findTotals() {
        return articleDao.queryTotalAll();
    }

    @Override
    public void addInfo(Article article) {
        article.setId(UUID.randomUUID().toString());
        article.setPublishTime(new Date());
        articleDao.insertInfo(article);
    }
}
