package com.menudesigner.sjbs.rest.wrapper;

import java.util.List;

/**
 * Created by JIN Benli on 28/01/15.
 */
public class CommandWrapper {
    int table_no;
    int client_no;
    String title;
    String msg_extra;

    List<DishWrapper> dishs;
    List<MenuWrapper> menus;
    List<ActivityWrapper> activities;

    public CommandWrapper() {
    }

    public int getTable_no() {
        return table_no;
    }

    public void setTable_no(int table_no) {
        this.table_no = table_no;
    }

    public int getClient_no() {
        return client_no;
    }

    public void setClient_no(int client_no) {
        this.client_no = client_no;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMsg_extra() {
        return msg_extra;
    }

    public void setMsg_extra(String msg_extra) {
        this.msg_extra = msg_extra;
    }

    public List<DishWrapper> getDishs() {
        return dishs;
    }

    public void setDishs(List<DishWrapper> dishs) {
        this.dishs = dishs;
    }

    public List<MenuWrapper> getMenus() {
        return menus;
    }

    public void setMenus(List<MenuWrapper> menus) {
        this.menus = menus;
    }

    public List<ActivityWrapper> getActivities() {
        return activities;
    }

    public void setActivities(List<ActivityWrapper> activities) {
        this.activities = activities;
    }
}
