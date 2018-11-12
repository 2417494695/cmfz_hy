package com.baizhi.controller;

import com.baizhi.entity.Guru;
import com.baizhi.service.GuruService;
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
@RequestMapping("guru")
public class GuruController {
    
    @Autowired
    private GuruService guruService;
    
    @RequestMapping("showAll")
    public @ResponseBody Map<String,Object> findAll(int page, int rows){
        HashMap<String, Object> map = new HashMap<String, Object>();
        List<Guru> gurus = guruService.findPage(page,rows);
        Long totals = guruService.findTotals();
        map.put("rows",gurus);
        map.put("total",totals);
        return map;
    }
    
    @RequestMapping("addGuru")
    public void save(HttpServletRequest request, HttpServletResponse response, MultipartFile file, Guru guru) throws IOException {
        String realPath = request.getSession().getServletContext().getRealPath("/back/img/guru");
        file.transferTo(new File(realPath,file.getOriginalFilename()));
        guru.setHeadPic("/back/img/guru/"+file.getOriginalFilename());
        guruService.addGuru(guru);
        response.getWriter().print("success");
    }
    
    @RequestMapping("delete")
    public void deleteGuru(HttpServletResponse response,String id) throws IOException {
        guruService.removeById(id);
        response.getWriter().print("deleteSuccess");
    }
    
    @RequestMapping("findAll")
    public @ResponseBody List<Guru> showAll(){
        List<Guru> gurus = guruService.findAll();
        return gurus;
    }
}
