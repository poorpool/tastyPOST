package net.yxchen.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Jdbc操作数据库的工具类
 */
public class JdbcUtils {
    public static DataSource dataSource = null;
    public static ThreadLocal<Connection> connectionThreadLocal = new ThreadLocal<>();
    static {
        Properties prop = new Properties();
        try {
            prop.load(JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties"));
            dataSource = DruidDataSourceFactory.createDataSource(prop);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        Connection conn = connectionThreadLocal.get();
        if (conn == null) {
            try {
                conn = dataSource.getConnection();
                connectionThreadLocal.set(conn);
                conn.setAutoCommit(false);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return conn;
    }

    /**
     * 提交事务，关闭连接。
     */
    public static void commitAndClose() {
        Connection conn = connectionThreadLocal.get();
        if (conn != null) {
            try {
                conn.commit();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                   conn.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        connectionThreadLocal.remove();
    }

    /**
     * 回滚事务，关闭连接。
     */
    public static void rollbackAndClose() {
        Connection conn = connectionThreadLocal.get();
        if (conn != null) {
            try {
                conn.rollback();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    conn.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        connectionThreadLocal.remove();
    }

}
