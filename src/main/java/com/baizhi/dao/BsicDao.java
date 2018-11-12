package com.baizhi.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BsicDao<T> {

    void insertInfo(T t);

    void deleteById(String id);

    void updateInfo(T t);

    List<T> queryAll();
    
    List<T> queryPageAll(@Param("start") int start, @Param("rows") int rows);
    
    Long queryTotalAll();

    T queryItem(T t);
    
    T queryOne(String id);
}
