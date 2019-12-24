package com.bcdl.service.implement;

import com.bcdl.dao.UserMapper;
import com.bcdl.model.entity.UserExample;
import com.bcdl.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Scope("prototype")
@Transactional(rollbackFor ={Exception.class,RuntimeException.class}, propagation = Propagation.REQUIRED)
public class UserService implements IUserService {

    private static final Logger log = LoggerFactory.getLogger(UserService.class);
    @Resource
    private UserMapper userMapper;

    /**
     * 登录验证
     * @param username 用户名
     * @param password 密码
     * @return 验证结果
     */
    public boolean login(String username,String password ){
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUsernameEqualTo(username).andPasswordEqualTo(password);

        if (userMapper.selectOneByExample(userExample)!=null)
            return true;
        else
            return false;
    }

    @Override
    public boolean usernameState(String username) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUsernameEqualTo(username);
        if (userMapper.selectOneByExample(userExample)!=null)
            return true;
        else
            return false;
    }

}
