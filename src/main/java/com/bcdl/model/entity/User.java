package com.bcdl.model.entity;

import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Table(name = "user")
public class User {
    /**
     * 登录账号
     */
    @Id
    @NotNull
    @NotEmpty(message = "This cannot be null")
    @Size(min = 4, max = 6, message = "length is wrong")
    private String username;

    /**
     * 用户昵称
     */
    private String nickname;

    /**
     * 登录密码
     */
    @NotNull
    @NotEmpty
    @Size(min = 6, max = 10)
    private String password;

    /**
     * 用户权限
     */
    private Integer authority;

    /**
     * 注册时间
     */
    private Date registrationtime;

    /**
     * 获取登录账号
     *
     * @return username - 登录账号
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置登录账号
     *
     * @param username 登录账号
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * 获取用户昵称
     *
     * @return nickname - 用户昵称
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * 设置用户昵称
     *
     * @param nickname 用户昵称
     */
    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    /**
     * 获取登录密码
     *
     * @return password - 登录密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置登录密码
     *
     * @param password 登录密码
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 获取用户权限
     *
     * @return authority - 用户权限
     */
    public Integer getAuthority() {
        return authority;
    }

    /**
     * 设置用户权限
     *
     * @param authority 用户权限
     */
    public void setAuthority(Integer authority) {
        this.authority = authority;
    }

    /**
     * 获取注册时间
     *
     * @return registrationtime - 注册时间
     */
    public Date getRegistrationtime() {
        return registrationtime;
    }

    /**
     * 设置注册时间
     *
     * @param registrationtime 注册时间
     */
    public void setRegistrationtime(Date registrationtime) {
        this.registrationtime = registrationtime;
    }

    public User() {
    }

    public User(@NotNull @NotEmpty(message = "This cannot be null") @Size(min = 4, max = 6, message = "length is wrong") String username, @NotNull @NotEmpty @Size(min = 6, max = 10) String password) {
        this.username = username;
        this.password = password;
    }

}