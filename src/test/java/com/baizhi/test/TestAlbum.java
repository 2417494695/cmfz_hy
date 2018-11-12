package com.baizhi.test;

import com.baizhi.entity.Album;
import com.baizhi.service.AlbumService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class TestAlbum {
    
    @Autowired
    private AlbumService albumService;
    
    @Test
    public void testFindAll(){
        List<Album> albums = albumService.findAll();
        for (Album album : albums) {
            System.out.println(album);
        }
    }
    
    @Test
    public void testAdd(){
        Album album = new Album();
        album.setTitle("aa");
        album.setCoverImg("a");
        album.setCount(12);
        album.setScore("5");
        album.setAuthor("a");
        album.setBrief("a");
        album.setBroadCast("a");
        albumService.addInfo(album);
    }
    
    @Test
    public void testPage(){
        List<Album> pages = albumService.findPage(1,2);
        for (Album page : pages) {
            System.out.println(page);
        }
    }
}
