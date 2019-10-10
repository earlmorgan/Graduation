package com.bcdl.service;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    /**
     * 登录验证
     * @param username 用户名
     * @param password 密码
     * @return 验证结果
     */
    public boolean login(String username,String password ){
        if (username.equals("") && password.equals(""))
            return true;
        else
            return false;
    }

}
