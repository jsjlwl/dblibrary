package com.mzw.study.db.dbutils.entity;

/**
 * @ClassName User
 * @Description 用户实体Bean
 * @Author liwenlong
 * @Email jsjlwl@qq.com
 * @Date 2020-05-17 10:17
 * @Version 1.0
 */
public class User {
    private int uid;
    private String userName;
    private int userAge;
    private String userPwd;

    public User() {

    }
    public User(int uid) {
        this.uid = uid;
    }

    public User(int uid, String userName, int userAge, String userPwd) {
        this.uid = uid;
        this.userName = userName;
        this.userAge = userAge;
        this.userPwd = userPwd;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserAge() {
        return userAge;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", userName='" + userName + '\'' +
                ", userAge=" + userAge +
                ", userPwd='" + userPwd + '\'' +
                '}';
    }
}
