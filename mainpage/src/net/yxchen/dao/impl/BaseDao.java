package net.yxchen.dao.impl;

import com.alibaba.druid.stat.JdbcTraceManagerMBean;
import net.yxchen.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * 所有 Dao 都应该继承它
 */
public abstract class BaseDao {
    private QueryRunner queryRunner = new QueryRunner();

    /**
     * 执行 insert/update/delete 的语句
     * @param sql sql 语句
     * @param args 不定长参数
     * @return -1 是失败，否则是影响的行数
     */
    public int update(String sql, Object... args) {
        Connection conn = JdbcUtils.getConnection();
        try {
            return queryRunner.update(conn, sql, args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     * 执行返回一个 JavaBean 的 query 语句
     * @param clazz 要返回的 JavaBean 的 Class
     * @param sql sql 语句
     * @param args 不定长参数
     * @param <T> 返回的类型的泛型
     * @return 一个 JavaBean
     */
    public <T> T queryForOne(Class<T> clazz, String sql, Object... args) {
        Connection conn = JdbcUtils.getConnection();
        try {
            return queryRunner.query(conn, sql, new BeanHandler<>(clazz), args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     * 执行返回一个 JavaBean 的 List 的 query 语句
     * @param clazz 要返回的 JavaBean 的 Class
     * @param sql sql 语句
     * @param args 不定长参数
     * @param <T> 返回的类型的泛型
     * @return 一个 JavaBean 的 List
     */
    public <T> List<T> queryForList(Class<T> clazz, String sql, Object... args) {
        Connection conn = JdbcUtils.getConnection();
        try {
            return queryRunner.query(conn, sql, new BeanListHandler<>(clazz), args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     * 执行返回一个值（一行一列）的 sql 语句
     * @param sql sql 语句
     * @param args 不定长参数
     * @return 查询的值的 Object
     */
    public Object queryForSingleValue(String sql, Object... args) {
        Connection conn = JdbcUtils.getConnection();
        try {
            return queryRunner.query(conn, sql, new ScalarHandler<>(), args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
