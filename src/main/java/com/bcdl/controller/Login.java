package com.bcdl.controller;

import com.bcdl.model.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class Login {

    private static final Logger log = LoggerFactory.getLogger(Login.class);

    @RequestMapping(value = "/login")
    public ModelAndView login(@ModelAttribute("user") User user){
        return new ModelAndView("jsp/login","command",user);
    }

}
