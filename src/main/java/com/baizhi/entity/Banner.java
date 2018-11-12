package com.baizhi.entity;

import java.util.Date;

/**
 * 轮播图
 */
public class Banner {
    /**
     * id
     */
    private String id;
    /**
     * 图片路径
     */
    private String imgPath;
    /**
     * 描述
     */
    private String title;
    /**
     * 状态
     */
    private String status;

    /**
     * 添加时间
     */
    private Date addDate;

    @Override
    public String toString() {
        return "Banner{" +
                "id='" + id + '\'' +
                ", imgPath='" + imgPath + '\'' +
                ", title='" + title + '\'' +
                ", status='" + status + '\'' +
                ", addDate='" + addDate + '\'' +
                '}';
    }

    public Banner(String id, String imgPath, String title, String status, Date addDate) {
        this.id = id;
        this.imgPath = imgPath;
        this.title = title;
        this.status = status;
        this.addDate = addDate;
    }

    public Banner() {
    
    }

    public String getId() {
    
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getAddDate() {
        return addDate;
    }

    public void setAddDate(Date addDate) {
        this.addDate = addDate;
    }
}
