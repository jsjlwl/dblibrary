package com.mzw.study.db.dbutils.dao;

import com.mzw.study.db.dbutils.entity.User;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName UserDbutilsDao
 * @Description 使用dbutils进行数据库CRUD操作
 * @Author liwenlong
 * @Email jsjlwl@qq.com
 * @Date 2020-05-17 12:12
 * @Version 1.0
 */
public class UserDbutilsDao {
    private static final String dbDriver = "com.mysql.jdbc.Driver";
    private static final String dbUrl = "jdbc:mysql://localhost:3306/dblibrary?useUnicode=true&characterEncoding=utf-8";
    private static final String dbUser = "root";
    private static final String dbPassword = "root";

    public User selectOne(int uid) {
        Long start = System.currentTimeMillis();
        User user = null;
        Long end = System.currentTimeMillis();
        System.out.println("cost:" + (end - start) + "ms");
        return user;
    }

    public List<User> findList(User user) {
        Long start = System.currentTimeMillis();
        List<User> users = new ArrayList<>();
        Long end = System.currentTimeMillis();
        System.out.println("cost:" + (end - start) + "ms");
        return users;
    }

    public Boolean insert(User user) {
        Long start = System.currentTimeMillis();
        Boolean isOk = false;
        Long end = System.currentTimeMillis();
        System.out.println("cost:" + (end - start) + "ms");
        return isOk;
    }

    public int[] insertBatch(List<User> users) {
        Long start = System.currentTimeMillis();
        int[] result = null;
        Long end = System.currentTimeMillis();
        System.out.println("cost:" + (end - start) + "ms");
        return result;
    }

    public Boolean update(User user) {
        Long start = System.currentTimeMillis();
        Boolean isOk = false;
        Long end = System.currentTimeMillis();
        System.out.println("cost:" + (end - start) + "ms");
        return isOk;
    }

    public int[] updateBatch(List<User> users) {
        Long start = System.currentTimeMillis();
        int[] result = null;
        Long end = System.currentTimeMillis();
        System.out.println("cost:" + (end - start) + "ms");
        return result;
    }

    public Boolean delete(int uid) {
        Long start = System.currentTimeMillis();
        Boolean isOk = false;
        Long end = System.currentTimeMillis();
        System.out.println("cost:" + (end - start) + "ms");
        return isOk;
    }

    public Boolean deleteBatch(List<User> users) {
        Long start = System.currentTimeMillis();
        Boolean isOk = false;
        Long end = System.currentTimeMillis();
        System.out.println("cost:" + (end - start) + "ms");
        return isOk;
    }
}
