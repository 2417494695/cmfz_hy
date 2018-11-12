package com.baizhi.controller;

import com.baizhi.entity.Album;
import com.baizhi.service.AlbumService;
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
@RequestMapping("album")
public class AlbumController {
    
    @Autowired
    private AlbumService albumService;
    
    @RequestMapping("showAll")
    public @ResponseBody
    List<Album> findAll(){
        List<Album> albums = albumService.findAll();
        return albums;
    }
    
    @RequestMapping("showPage")
    public @ResponseBody Map<String,Object> findPage(int page, int rows){
        Map<String, Object> map = new HashMap<String,Object>();
        List<Album> albums = albumService.findPage(page, rows);
        Long totals = albumService.findTotals();
        map.put("total",totals);
        map.put("rows",albums);
        return map;
    }
    
    @RequestMapping("addAlbum")
    public void saveAblum(HttpServletResponse response, HttpServletRequest request, MultipartFile file,Album album) throws IOException {
        String realPath = request.getSession().getServletContext().getRealPath("/back/img/album");
        file.transferTo(new File(realPath,file.getOriginalFilename()));
        album.setCoverImg("/back/img/album/"+file.getOriginalFilename());
        albumService.addInfo(album);
        response.getWriter().print("addSuccess");
    }
}
