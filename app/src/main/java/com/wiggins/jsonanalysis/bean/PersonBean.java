package com.wiggins.jsonanalysis.bean;

import java.util.List;

public class PersonBean {

    private String name;
    private UserBean user;
    private List<UserBean> list;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

    public List<UserBean> getList() {
        return list;
    }

    public void setList(List<UserBean> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", user=" + user +
                ", list=" + list +
                '}';
    }
}
