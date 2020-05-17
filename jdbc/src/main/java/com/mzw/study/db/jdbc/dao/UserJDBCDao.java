package com.mzw.study.db.jdbc.dao;

import com.mzw.study.db.jdbc.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName UserJDBCDao
 * @Description 采用原生JDBC进行数据库增删改查操作
 * @Author liwenlong
 * @Email jsjlwl@qq.com
 * @Date 2020-05-17 10:19
 * @Version 1.0
 */
public class UserJDBCDao {
    private static final String dbDriver = "com.mysql.jdbc.Driver";
    private static final String dbUrl = "jdbc:mysql://localhost:3306/dblibrary?useUnicode=true&characterEncoding=utf-8";
    private static final String dbUser = "root";
    private static final String dbPassword = "root";

    public User selectOne(int uid) {
        Connection conn = null;
        Statement stmt = null;
        User user = null;
        try {
            // 打开连接
            conn = getConnection();
            // 执行查询
            stmt = getStatement(conn);
            String sql = "SELECT uid, user_name, user_age, user_pwd FROM user where uid = " + uid;
            ResultSet rs = stmt.executeQuery(sql);
            // 获取结果集
            while (rs.next()) {
                Integer uidr = rs.getInt("uid");
                String userName = rs.getString("user_name");
                String userPwd = rs.getString("user_pwd");
                Integer userAge = rs.getInt("user_age");
                user = new User(uidr, userName, userAge, userPwd);
                System.out.println(user);
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException se2) {
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        return user;
    }

    public List<User> findList(User user) {
        Connection conn = null;
        Statement stmt = null;
        List<User> users = new ArrayList<>();
        try {
            // 打开连接
            conn = getConnection();
            // 执行查询
            stmt = getStatement(conn);
            String sql = "SELECT uid, user_name, user_age, user_pwd FROM user where 1=1 ";
            if (-1 != user.getUid()) {
                sql += " and uid=" + user.getUid();
            }
            if (null != user.getUserName() && user.getUserName().length() > 0) {
                sql += " and user_name like concat('%','" + user.getUserName() + "','%')";
            }
            ResultSet rs = stmt.executeQuery(sql);
            // 获取结果集
            while (rs.next()) {
                Integer uidr = rs.getInt("uid");
                String userName = rs.getString("user_name");
                String userPwd = rs.getString("user_pwd");
                Integer userAge = rs.getInt("user_age");
                User u = new User(uidr, userName, userAge, userPwd);
                users.add(u);
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException se2) {
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        return users;
    }

    public Boolean insert(User user) {
        Connection conn = null;
        Statement stmt = null;
        Boolean isOk = false;
        try {
            // 打开连接
            conn = getConnection();
            // 执行查询
            stmt = getStatement(conn);
            String sql = "insert into user (uid, user_name, user_age, user_pwd) values (" + user.getUid() + ",'" + user.getUserName() + "'," + user.getUserAge() + ",'" + user.getUserPwd() + "')";
            isOk = stmt.execute(sql);
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException se2) {
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        return isOk;
    }

    public int[] insertBatch(List<User> users) {
        Connection conn = null;
        PreparedStatement ps = null;
        int[] result = null;
        try {
            Long start = System.currentTimeMillis();
            // 打开连接
            conn = getConnection(true);
            ps = conn.prepareStatement("insert into user (uid, user_name, user_age, user_pwd) values (?,?,?,?)");
            for (User user : users) {
                ps.setInt(1, user.getUid());
                ps.setString(2, user.getUserName());
                ps.setInt(3, user.getUserAge());
                ps.setString(4, user.getUserPwd());
                ps.addBatch();
            }
            result = ps.executeBatch();
            ps.close();
            conn.close();
            Long end = System.currentTimeMillis();
            System.out.println("cost:" + (end - start) + "ms");
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException se2) {
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        return result;
    }

    public Boolean update(User user) {
        Connection conn = null;
        Statement stmt = null;
        Boolean isOk = false;
        try {
            // 打开连接
            conn = getConnection();
            // 执行查询
            stmt = getStatement(conn);
            String sql = "update user set user_name='" + user.getUserName() + "',user_age=" + user.getUserAge() + ",user_pwd='" + user.getUserPwd() + "' where uid=" + user.getUid();
            isOk = stmt.execute(sql);
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException se2) {
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        return isOk;
    }

    public int[] updateBatch(List<User> users) {
        Connection conn = null;
        PreparedStatement ps = null;
        int[] result = null;
        try {
            Long start = System.currentTimeMillis();
            // 打开连接
            conn = getConnection(true);
            ps = conn.prepareStatement("update user set user_name=?, user_age=?, user_pwd=? where uid=?");
            for (User user : users) {
                ps.setString(1, user.getUserName());
                ps.setInt(2, user.getUserAge());
                ps.setString(3, user.getUserPwd());
                ps.setInt(4, user.getUid());
                ps.addBatch();
            }
            result = ps.executeBatch();
            ps.close();
            conn.close();
            Long end = System.currentTimeMillis();
            System.out.println("cost:" + (end - start) + "ms");
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException se2) {
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        return result;
    }

    public Boolean delete(int uid) {
        Connection conn = null;
        Statement stmt = null;
        Boolean isOk = false;
        try {
            Long start = System.currentTimeMillis();
            // 打开连接
            conn = getConnection();
            stmt = getStatement(conn);
            String sql = "delete from user where uid = " + uid;
            isOk = stmt.execute(sql);
            stmt.close();
            conn.close();
            Long end = System.currentTimeMillis();
            System.out.println("cost:" + (end - start) + "ms");
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException se2) {
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        return isOk;
    }

    public Boolean deleteBatch(List<User> users) {
        Connection conn = null;
        Statement stat = null;
        Boolean isOk = false;
        try {
            Long start = System.currentTimeMillis();
            StringBuilder sbId = new StringBuilder();
            for (User user : users) {
                sbId.append("," + user.getUid());
            }
            // 打开连接
            conn = getConnection();
            stat = getStatement(conn);
            String sql = "delete from user where uid in (" + sbId.toString().substring(1) + ")";
            isOk = stat.execute(sql);
            stat.close();
            conn.close();
            Long end = System.currentTimeMillis();
            System.out.println("cost:" + (end - start) + "ms");
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stat != null) {
                    stat.close();
                }
            } catch (SQLException se2) {
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        return isOk;
    }

    private Connection getConnection() throws SQLException, ClassNotFoundException {
        return getConnection(false);
    }

    private Connection getConnection(Boolean isBatch) throws ClassNotFoundException, SQLException {
        // 注册 JDBC 驱动, 高版本中会在DriverManager.getConnection中自动注册，不再需要单独注册。
        Class.forName(dbDriver);
        String dbUrlTemp = dbUrl;
        if (isBatch) {
            dbUrlTemp += dbUrlTemp.contains("?") ? "&rewriteBatchedStatements=true" : "?rewriteBatchedStatements=true";
        }
        Connection conn = DriverManager.getConnection(dbUrlTemp, dbUser, dbPassword);
        return conn;
    }

    private Statement getStatement(Connection conn) throws SQLException {
        if (null == conn || conn.isClosed()) {
            return null;
        }
        Statement statement = conn.createStatement();
        return statement;
    }
}
