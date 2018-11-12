package com.baizhi.entity;

/**
 * 章节
 */
public class Chapters {
    /**
     * 章节id
     */
    private String id;
    /**
     * 章节名
     */
    private String title;
    /**
     * 章节大小
     */
    private String size;
    /**
     * 下载路径
     */
    private String downUrl;
    /**
     * 时长
     */
    private String duration;
    /**
     * 专辑id
     */
    private String album_id;

    @Override
    public String toString() {
        return "Chapters{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", size=" + size +
                ", downUrl='" + downUrl + '\'' +
                ", duration=" + duration +
                ", album_id='" + album_id + '\'' +
                '}';
    }

    public Chapters(String id, String title, String size, String downUrl, String duration, String album_id) {
        this.id = id;
        this.title = title;
        this.size = size;
        this.downUrl = downUrl;
        this.duration = duration;
        this.album_id = album_id;
    }

    public Chapters() {
    
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

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getDownUrl() {
        return downUrl;
    }

    public void setDownUrl(String downUrl) {
        this.downUrl = downUrl;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getAlbum_id() {
        return album_id;
    }

    public void setAlbum_id(String album_id) {
        this.album_id = album_id;
    }
}
