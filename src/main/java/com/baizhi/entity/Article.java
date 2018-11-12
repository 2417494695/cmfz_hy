package com.baizhi.entity;

import java.util.Date;

/**
 * 文章
 */
public class Article {
    /**
     * id
     */
    private String id;
    /**
     * 文章名
     */
    private String title;
    /**
     * 封面
     */
    private String imgPath;
    /**
     * 内容
     */
    private String content;
    /**
     * 发布时间
     */
    private Date publishTime;
    /**
     * 上师id
     */
    private String guru_id;

    private Guru guru;

    @Override
    public String toString() {
        return "Article{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", imgPath='" + imgPath + '\'' +
                ", content='" + content + '\'' +
                ", publishTime=" + publishTime +
                ", guru_id='" + guru_id + '\'' +
                ", guru=" + guru +
                '}';
    }

    public Article(String id, String title, String imgPath, String content, Date publishTime, String guru_id, Guru guru) {
        this.id = id;
        this.title = title;
        this.imgPath = imgPath;
        this.content = content;
        this.publishTime = publishTime;
        this.guru_id = guru_id;
        this.guru = guru;
    }

    public Article() {
    
    }

    public String getId() {
    
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public String getGuru_id() {
        return guru_id;
    }

    public void setGuru_id(String guru_id) {
        this.guru_id = guru_id;
    }

    public Guru getGuru() {
        return guru;
    }

    public void setGuru(Guru guru) {
        this.guru = guru;
    }
}