package com.baizhi.entity;

/**
 * 上师
 */
public class Guru {
    /**
     * id
     */
    private String id;
    /**
     * 上师头像
     */
    private String headPic;
    /**
     * 上师名
     */
    private String name;
    /**
     * 状态
     */
    private String status;

    @Override
    public String toString() {
        return "Guru{" +
                "id='" + id + '\'' +
                ", headPic='" + headPic + '\'' +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public Guru(String id, String headPic, String name, String status) {
        this.id = id;
        this.headPic = headPic;
        this.name = name;
        this.status = status;
    }

    public Guru() {
    
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHeadPic() {
        return headPic;
    }

    public void setHeadPic(String headPic) {
        this.headPic = headPic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
