package com.baizhi.test;

import com.baizhi.entity.Article;
import com.baizhi.service.ArticleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class TestArticle {
    
    @Autowired
    private ArticleService articleService;
    
    @Test
    public void testFindAll(){
        List<Article> articles = articleService.findPage(1,2);
        for (Article article : articles) {
            System.out.println(article);
        }
    }
    
    @Test
    public void testAdd(){
        Article article = new Article();
        article.setTitle("aaaaaaaa");
        article.setImgPath("1221");
        article.setContent("11111");
        article.setGuru_id("01");
        articleService.addInfo(article);
    }
}
