package com.wiggins.jsonanalysis.bean;

public class UserBean {

    private String age;
    private String sex;

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "User{" +
                "age='" + age + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
