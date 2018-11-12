package com.baizhi.controller;

import com.baizhi.entity.Chapters;
import com.baizhi.service.ChaptersService;
import org.apache.commons.io.IOUtils;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.mp3.MP3AudioHeader;
import org.jaudiotagger.audio.mp3.MP3File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.List;

@Controller
@RequestMapping("chpater")
public class ChaptersController {
    
    @Autowired
    private ChaptersService chaptersService;
    
    @RequestMapping("saveChpater")
    public void saveChapter(MultipartFile mp3,HttpServletRequest request, HttpServletResponse response, Chapters chapters) throws Exception {
        String realPath = request.getSession().getServletContext().getRealPath("/back/album/audio");
        mp3.transferTo(new File(realPath,mp3.getOriginalFilename()));
        //音频的保存路径
        chapters.setDownUrl("/back/album/audio/"+mp3.getOriginalFilename());
        //文件名
        chapters.setTitle(mp3.getOriginalFilename());
        //自动解析文件大小，单位B
        chapters.setSize(mp3.getSize()/1024/1024+"m");
        
        //获取文件时长
        realPath+="/"+ mp3.getOriginalFilename();
        int duration = getAudioLength(realPath);
        
        //保存文件时长，单位秒
        chapters.setDuration(duration/60+"fen");
        chaptersService.addInfo(chapters);
        response.getWriter().print("success");
    }

    //音频时长
    public int getAudioLength(String realPath) throws Exception {
        File file=new File(realPath);
        int s=0;
        MP3File f = (MP3File)AudioFileIO.read(file);
        MP3AudioHeader audioHeader = (MP3AudioHeader)f.getAudioHeader();
        s =audioHeader.getTrackLength();
        return s;
    }

    
    @RequestMapping("downLoad")
    public void downLoadFile(String fileName,HttpServletRequest request,HttpServletResponse response) throws Exception {
        //找到文件路径
        String realPath = request.getSession().getServletContext().getRealPath("/back/album/audio");
        //使用输入流读取文件
        FileInputStream fis = new FileInputStream(new File(realPath, fileName));
        //设置响应头
        response.setHeader("content-disposition","attachment;fileName="+URLEncoder.encode(fileName,"UTF-8"));
        //响应到客户端使用输出流，获取输出流
        ServletOutputStream os = response.getOutputStream();
        //io工具类输出
        IOUtils.copy(fis,os);
        IOUtils.closeQuietly(fis); 
        IOUtils.closeQuietly(os);
    }
    
    @RequestMapping("delete")
    public void remove(HttpServletResponse response,String id) throws IOException {
        chaptersService.removeById(id);
        response.getWriter().print("success");
    }
    
    @RequestMapping("showAll")
    public @ResponseBody List<Chapters> findAll(){
        List<Chapters> chapters = chaptersService.findAll();
        return chapters;
    }
}
