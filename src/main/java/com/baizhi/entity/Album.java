package com.baizhi.entity;

import java.util.Date;
import java.util.List;

/**
 * 专辑
 */
public class Album {
    /**
     * id
     */
    private String id;
    /**
     * 专辑名
     */
    private String title;
    /**
     * 封面
     */
    private String coverImg;
    /**
     * 集数
     */
    private int count;
    /**
     * 评分
     */
    private String score;
    /**
     * 作者
     */
    private String author;
    /**
     * 播音
     */
    private String broadCast;
    /**
     * 简介
     */
    private String brief;
    /**
     * 发布日期
     */
    private Date publishDate;
    /**
     * 章节集合
     */
    private List<Chapters> children;

    @Override
    public String toString() {
        return "Album{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", coverImg='" + coverImg + '\'' +
                ", count=" + count +
                ", score='" + score + '\'' +
                ", author='" + author + '\'' +
                ", broadCast='" + broadCast + '\'' +
                ", brief='" + brief + '\'' +
                ", publishDate=" + publishDate +
                ", children=" + children +
                '}';
    }

    public Album(String id, String title, String coverImg, int count, String score, String author, String broadCast, String brief, Date publishDate, List<Chapters> children) {
        this.id = id;
        this.title = title;
        this.coverImg = coverImg;
        this.count = count;
        this.score = score;
        this.author = author;
        this.broadCast = broadCast;
        this.brief = brief;
        this.publishDate = publishDate;
        this.children = children;
    }

    public Album() {
    
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

    public String getCoverImg() {
        return coverImg;
    }

    public void setCoverImg(String coverImg) {
        this.coverImg = coverImg;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBroadCast() {
        return broadCast;
    }

    public void setBroadCast(String broadCast) {
        this.broadCast = broadCast;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public List<Chapters> getChildren() {
        return children;
    }

    public void setChildren(List<Chapters> children) {
        this.children = children;
    }
}
