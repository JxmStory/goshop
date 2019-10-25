package com.sh.goshop.entity;

import java.io.Serializable;

public class Abc implements Serializable {

    private static final long serializableID = 1L;

    private int id;

    private String username;//名称

    private String account;//账号

    private String area;//申请级别 省 市 县

    private String time;//时间

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Abc{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", account='" + account + '\'' +
                ", area='" + area + '\'' +
                ", time='" + time + '\'' +
                '}';
    }

    public Abc() {}

    public Abc(int id, String username, String account) {
        this.id = id;
        this.username = username;
        this.account = account;
    }
}
