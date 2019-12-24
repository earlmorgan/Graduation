package com.bcdl.controller;

import com.bcdl.model.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class Register {

    private static final Logger log = LoggerFactory.getLogger(Register.class);

    @RequestMapping("/register")
    public ModelAndView register(@ModelAttribute("user")User user){
        return new ModelAndView("thymeleaf/register","command",user);
    }

}
