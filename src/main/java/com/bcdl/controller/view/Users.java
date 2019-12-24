package com.bcdl.controller.view;

import com.bcdl.controller.Login;
import com.bcdl.dao.UserMapper;
import com.bcdl.model.entity.User;
import com.bcdl.util.LoggerInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/View")
public class Users {

    private static final Logger log = LoggerFactory.getLogger(Users.class);
    @Autowired
    private Login login;

    @RequestMapping(value = "/AllUsers",method = RequestMethod.POST)
    public ModelAndView ViewAllUsers(@Validated User user, BindingResult result) {//Errors //RedirectAttributes 重定向
        if(result.hasErrors()){
            LoggerInfo.info(result,log);
            return login.login(user);
        }
        //调用业务层获取用户信息
        List<User> users = new ArrayList<User>();

        ModelAndView mav = new ModelAndView();
        mav.addObject("users", users);
        mav.setViewName("jsp/users");

        return mav;
    }

}
