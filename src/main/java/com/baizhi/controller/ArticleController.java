package com.baizhi.controller;

import com.baizhi.entity.Article;
import com.baizhi.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("article")
public class ArticleController {
    
    @Autowired
    private ArticleService articleService;
    
    @RequestMapping("showAll")
    public @ResponseBody Map<String,Object> findAll(int page, int rows){
        HashMap<String, Object> map = new HashMap<String,Object>();
        List<Article> articles = articleService.findPage(page,rows);
        Long totals = articleService.findTotals();
        map.put("total",totals);
        map.put("rows",articles);
        return map;
    }
    
    @RequestMapping("delete")
    public void deleteArt(HttpServletResponse response,String id) throws IOException {
        System.out.println(id);
        articleService.removeById(id);
        response.getWriter().print("deleteSuccess");
    }
    
    @RequestMapping("save")
    public void addArt(HttpServletRequest request, HttpServletResponse response, Article article, MultipartFile file) throws IOException {
        String realPath = request.getSession().getServletContext().getRealPath("/back/img/article");
        file.transferTo(new File(realPath,file.getOriginalFilename()));
        article.setImgPath("/back/img/article/"+file.getOriginalFilename());
        articleService.addInfo(article);
        response.getWriter().print("addSuccess");
    }
}

