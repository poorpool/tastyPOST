package net.yxchen.dao.impl;

import net.yxchen.dao.UserDao;
import net.yxchen.pojo.User;

public class UserDaoImpl extends BaseDao implements UserDao {
    @Override
    public User queryUserByUsername(String username) {
        String sql = "select * from t_user where username=?";
        return queryForOne(User.class, sql, username);
    }

    @Override
    public User queryUserByUsernameAndPassword(String username, String password) {
        String sql = "select * from t_user where username=? and password=?";
        return queryForOne(User.class, sql, username, password);
    }

    @Override
    public int saveUser(User user) {
        String sql = "insert into t_user (`username`, `password`, `email`, `privilege`, `registerDate`)values(?,?,?,?,?)";
        return update(sql, user.getUsername(), user.getPassword(), user.getEmail(), user.getPrivilege(), user.getRegisterDate());
    }
}
