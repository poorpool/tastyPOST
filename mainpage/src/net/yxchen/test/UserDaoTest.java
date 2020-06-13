package net.yxchen.test;

import net.yxchen.dao.UserDao;
import net.yxchen.dao.impl.UserDaoImpl;
import net.yxchen.pojo.User;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserDaoTest {
    UserDao userDao = new UserDaoImpl();
    @Test
    public void queryUserByUsername() {
        User user = userDao.queryUserByUsername("admin");
        System.out.println(user.getPassword());
    }

    @Test
    public void queryUserByUsernameAndPassword() {
    }

    @Test
    public void saveUser() {
    }
}