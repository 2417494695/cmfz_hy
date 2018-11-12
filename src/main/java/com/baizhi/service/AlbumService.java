package com.baizhi.service;

import com.baizhi.entity.Album;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AlbumService {
    
    List<Album> findPage(@Param("page")int page,@Param("rows")int rows);
    
    List<Album> findAll();
    
    void addInfo(Album album);
    
    Long findTotals();
}
