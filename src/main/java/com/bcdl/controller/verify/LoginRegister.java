package com.bcdl.controller.verify;

import com.bcdl.model.entity.User;
import com.bcdl.service.IUserService;
import com.bcdl.util.LoggerInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/verify",method = RequestMethod.POST)
public class LoginRegister{

    private static final Logger log = LoggerFactory.getLogger(LoginRegister.class);

    @Autowired
    @Qualifier("userService")
    private IUserService iUserService;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ModelAndView LoginVerify(@Validated User user, BindingResult result) {//Errors //RedirectAttributes 重定向

        if(result.hasErrors()){//运用@Validated进行验证
            LoggerInfo.info(result,log);
            return new ModelAndView("jsp/login","command",user);
        }

        //调用业务层
        if (iUserService.login(user.getUsername(),user.getPassword())){ //登录成功
            return new ModelAndView("jsp/index");//前往首页
        }
        ModelAndView error = new ModelAndView("jsp/login","command",user);
        //error.setViewName("jsp/login");
        //error.addObject("command",user);
        error.getModelMap().addAttribute("result","登录失败!</br>账号或密码不正确!");
        return error;//登录失败
    }

    public static ModelAndView getModelAndView(@Validated User user) {
        List<User> users = new ArrayList<User>();
        users.add(user);
        users.add(new User("A", "123456"));
        users.add(new User("B", "123456"));

        ModelAndView mav = new ModelAndView();
        mav.addObject("users", users);
        mav.setViewName("jsp/users");

        return mav;
    }
}
