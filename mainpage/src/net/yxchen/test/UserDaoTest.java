package net.yxchen.test;

import net.yxchen.dao.UserDao;
import net.yxchen.dao.impl.UserDaoImpl;
import net.yxchen.pojo.User;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {
    UserDao userDao = new UserDaoImpl();
    @org.junit.jupiter.api.Test
    void queryUserByUsername() {
        User user = userDao.queryUserByUsername("admin");
        System.out.println(user);
    }

    @org.junit.jupiter.api.Test
    void queryUserByUsernameAndPassword() {
    }

    @org.junit.jupiter.api.Test
    void saveUser() {
    }
}