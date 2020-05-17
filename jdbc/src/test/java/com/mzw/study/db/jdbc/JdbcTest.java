package com.mzw.study.db.jdbc;

import com.mzw.study.db.jdbc.dao.UserJDBCDao;
import com.mzw.study.db.jdbc.entity.User;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName JdbcTest
 * @Description 原生JDBC操作数据库测试
 * @Author liwenlong
 * @Email jsjlwl@qq.com
 * @Date 2020-05-17 11:29
 * @Version 1.0
 */
public class JdbcTest {

    private static UserJDBCDao dao = null;

    @Before
    public void initDao() {
        if (null == dao) {
            dao = new UserJDBCDao();
        }
    }

    @Test
    public void testSelectOne() {
        dao.selectOne(1);
    }

    @Test
    public void testFindList() {
        List<User> users = dao.findList(new User(-1, "name", 1, "ssss"));
        System.out.println(users);
    }

    @Test
    public void testInsert() {
        dao.insert(new User(1, "name1", 1, "pwd1"));
    }

    @Test
    public void testInsertBatch() {
        List<User> users = new ArrayList();
        for (int i = 1; i < 101; i++) {
            int uid = i + 1;
            users.add(new User(uid, "name" + uid, uid, "pwd" + uid));
        }
        dao.insertBatch(users);
    }

    @Test
    public void testUpdate() {
        dao.update(new User(1, "name-1", 1, "pwd-1"));
        dao.selectOne(1);
    }

    @Test
    public void testUpdateBatch() {
        List<User> users = new ArrayList();
        for (int i = 1; i < 101; i++) {
            int uid = i + 1;
            users.add(new User(uid, "name-" + uid, uid, "pwd-" + uid));
        }
        int[] result = dao.updateBatch(users);
        System.out.println(result);
    }

    @Test
    public void testDelete() {
        dao.delete(1);
    }

    @Test
    public void testDeleteBatch() {
        List<User> users = new ArrayList();
        for (int i = 1; i < 101; i++) {
            int uid = i + 1;
            users.add(new User(uid));
        }
        dao.deleteBatch(users);
    }
}
