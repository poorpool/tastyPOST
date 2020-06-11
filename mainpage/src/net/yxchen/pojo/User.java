package net.yxchen.pojo;

import java.util.Date;

/**
 * 用户类
 */
public class User {
    private Integer userId;
    private String username;
    private String password;//sha512加密以后的
    private String email;
    private Integer privilege;//权限，5是管理员，1是普通用户
    private Date registerDate;

    public User() {
    }

    public User(Integer userId, String username, String password, String email, Integer privilege, Date registerDate) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.email = email;
        this.privilege = privilege;
        this.registerDate = registerDate;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getPrivilege() {
        return privilege;
    }

    public void setPrivilege(Integer privilege) {
        this.privilege = privilege;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", privilege=" + privilege +
                ", registerDate=" + registerDate +
                '}';
    }
}
