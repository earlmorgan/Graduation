package com.bcdl.controller.ajax;

import com.bcdl.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class usernameState {

    private static final Logger log = LoggerFactory.getLogger(usernameState.class);

    @Autowired
    @Qualifier("userService")
    private IUserService iUserService;

    @RequestMapping(value = "Ajax/CheckWeightData",method = RequestMethod.POST)
    private boolean CheckWeightData(HttpServletRequest request, HttpServletResponse response){
        return iUserService.usernameState((String) request.getParameter("username"));
    }

}
