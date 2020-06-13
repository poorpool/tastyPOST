package net.yxchen.service;

import net.yxchen.pojo.User;

public interface UserService {
    /**
     * 根据传入的用户注册用户到数据库
     * @param user 要注册的用户
     */
    public void registerUser(User user);

    /**
     * 根据传入的用户（的一些信息）来登录
     * @param user 传入的用户
     * @return null 为登录失败，非 null 为登录用户的完整信息
     */
    public User login(User user);

    /**
     * 判断用户名是否存在
     * @param username 用户名
     * @return true 为存在，false 为不存在
     */
    public boolean isExistsUsername(String username);
}
