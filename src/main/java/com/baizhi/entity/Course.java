package com.baizhi.entity;

import java.util.Date;

/**
 * 功课
 */
public class Course {
    /**
     * id
     */
    private String id;
    /**
     * 功课名
     */
    private String name;
    /**
     * 功课添加时间
     */
    private Date createTime;
    /**
     * 标识
     */
    private String flag;
    /**
     * 用户id
     */
    private String user_id;

    @Override
    public String toString() {
        return "Course{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", createTime=" + createTime +
                ", flag='" + flag + '\'' +
                ", user_id='" + user_id + '\'' +
                '}';
    }

    public Course(String id, String name, Date createTime, String flag, String user_id) {
        this.id = id;
        this.name = name;
        this.createTime = createTime;
        this.flag = flag;
        this.user_id = user_id;
    }

    public Course() {
    
    }

    public String getId() {
    
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
}
