package net.yxchen.dao;

import net.yxchen.pojo.User;

public interface UserDao {
    /**
     * 通过用户名查询用户
     * @param username 用户名
     * @return 查询到返回一个 User，未查询到返回 null
     */
    public User queryUserByUsername(String username);

    /**
     * 通过用户名和密码查询用户
     * @param username 用户名
     * @param password 密码
     * @return 查询到返回一个 User，未查询到返回 null
     */
    public User queryUserByUsernameAndPassword(String username, String password);

    /**
     * 保存用户
     * @param user 要保存的用户
     * @return -1是保存失败，其他是影响的行数
     */
    public int saveUser(User user);

    /**
     * 根据 id 查询用户
     * @param userId 用户 id
     * @return 用户
     */
    public User queryUserByid(int userId);
}
