package com.baizhi.entity;

import java.util.List;

public class Menu {
    /**
     * 菜单id
     */
    private String id;
    /**
     * 菜单名
     */
    private String name;
    /**
     * 图标
     */
    private String iconCls;
    /**
     * 路径
     */
    private String href;
    /**
     * 父id
     */
    private String parentId;
    /**
     * 菜单对象
     */
    private Menu menu;
    /**
     * 子菜单集合
     */
    private List<Menu> menus;

    @Override
    public String toString() {
        return "Menu{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", iconCls='" + iconCls + '\'' +
                ", href='" + href + '\'' +
                ", parentId='" + parentId + '\'' +
                ", menu=" + menu +
                ", menus=" + menus +
                '}';
    }

    public Menu(String id, String name, String iconCls, String href, String parentId, Menu menu, List<Menu> menus) {
        this.id = id;
        this.name = name;
        this.iconCls = iconCls;
        this.href = href;
        this.parentId = parentId;
        this.menu = menu;
        this.menus = menus;
    }

    public Menu() {
    
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

    public String getIconCls() {
        return iconCls;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }
}
