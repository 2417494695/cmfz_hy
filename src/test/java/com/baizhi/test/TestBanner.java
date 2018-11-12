package com.baizhi.test;

import com.baizhi.entity.Banner;
import com.baizhi.service.BannerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class TestBanner {
    
    @Autowired
    private BannerService bannerService;
    
    @Test
    public void testFindAll(){
        List<Banner> banners = bannerService.findPage(2,2);
        for (Banner banner : banners) {
            System.out.println(banner);
        }
    }
    
    @Test
    public void testAdd(){
        Banner banner = new Banner();
        banner.setImgPath("");
        banner.setTitle("我的桌面");
        banner.setStatus("1");
        banner.setAddDate(new Date());
        bannerService.addInfo(banner);
    }
    
    @Test
    public void update(){
        Banner banner = new Banner();
        banner.setId("66fcfeca-d9fe-473c-b7f5-a6321fee28df");
        banner.setImgPath("aaa");
        banner.setTitle("aaa");
        banner.setStatus("1");
        bannerService.updateInfo(banner);
    }
    
    @Test
    public void testQuery(){
        Banner banner = bannerService.findOne("66fcfeca-d9fe-473c-b7f5-a6321fee28df");
        System.out.println(banner);
    }
}
