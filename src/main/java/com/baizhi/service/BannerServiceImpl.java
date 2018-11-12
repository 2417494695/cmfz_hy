package com.baizhi.service;

import com.baizhi.dao.BannerDao;
import com.baizhi.entity.Banner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class BannerServiceImpl implements BannerService {
    
    @Autowired
    private BannerDao bannerDao;
    
    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Banner> findPage(int page, int rows) {
        int start=(page-1)*rows;
        List<Banner> banners = bannerDao.queryPageAll(start, rows);
        return banners;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Long findTotals() {
        return bannerDao.queryTotalAll();
    }

    @Override
    public void addInfo(Banner banner) {
        banner.setId(UUID.randomUUID().toString());
        banner.setAddDate(new Date());
        bannerDao.insertInfo(banner);
    }

    @Override
    public void removeById(String id) {
        bannerDao.deleteById(id);
    }

    @Override
    public void updateInfo(Banner banner) {
        banner.setAddDate(new Date());
        bannerDao.updateInfo(banner);
    }

    @Override
    public Banner findOne(String id) {
        Banner banner = bannerDao.queryOne(id);
        return banner;
    }

}
