package net.yxchen.service.impl;

import net.yxchen.dao.UserDao;
import net.yxchen.dao.impl.UserDaoImpl;
import net.yxchen.pojo.User;
import net.yxchen.service.UserService;

public class UserServiceImpl implements UserService {
    UserDao userDao = new UserDaoImpl();
    @Override
    public void registerUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public User login(User user) {
        return userDao.queryUserByUsernameAndPassword(user.getUsername(), user.getPassword());
    }

    @Override
    public boolean isExistsUsername(String username) {
        return userDao.queryUserByUsername(username) != null;
    }
}
