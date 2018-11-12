package com.baizhi.service;

import com.baizhi.entity.Article;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ArticleService {
    List<Article> findPage(@Param("page")int page,@Param("rows")int rows);
    
    void removeById(String id);
    
    Long findTotals();
    
    void addInfo(Article article);
}
