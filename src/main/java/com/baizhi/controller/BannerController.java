package com.baizhi.controller;

import com.baizhi.entity.Banner;
import com.baizhi.service.BannerService;
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
@RequestMapping("banner")
public class BannerController {
    
    @Autowired
    private BannerService bannerService;
    
    @RequestMapping("showAll")
    public @ResponseBody Map<String,Object> findAll(int page,int rows){
        HashMap<String, Object> map = new HashMap<String,Object>();
        List<Banner> banners = bannerService.findPage(page,rows);
        Long totals = bannerService.findTotals();
        map.put("total",totals);
        map.put("rows",banners);
        return map;
    }
    
    @RequestMapping("file")
    public void file(HttpServletRequest request, HttpServletResponse response, MultipartFile img, Banner banner) throws IOException {
        //获取项目绝对路径
        String realPath = request.getSession().getServletContext().getRealPath("/back/img/banner");
        //上传文件
        img.transferTo(new File(realPath,img.getOriginalFilename()));
        banner.setImgPath("/back/img/banner/"+img.getOriginalFilename());
        bannerService.addInfo(banner);
        response.getWriter().print("上传成功");
    }
    
    @RequestMapping("delete")
    public void deleteBann(String id,HttpServletResponse response) throws IOException {
        bannerService.removeById(id);
        response.getWriter().print("success");
    }
    
    @RequestMapping("upLoadBann")
    public void updateBann(Banner banner,HttpServletResponse response) throws IOException {
        bannerService.updateInfo(banner);
        response.getWriter().print("upLoatSuccess");
    }
    
    @RequestMapping("findOne")
    public @ResponseBody Banner findBann(String id){
        Banner banner = bannerService.findOne(id);
        return banner;
    }
}
