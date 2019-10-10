package com.bcdl.controller;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bcdl.model.entity.UserEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
	
	@RequestMapping("/index")
	public String index(Model m){
		m.addAttribute("TIME", DateFormat.getDateTimeInstance().format(new Date()));
		return "index";
	}

	@RequestMapping(value = "/login")
	public ModelAndView login(){
		return new ModelAndView("login","command",new UserEntity());
	}

	@RequestMapping(value = "/verify",method = RequestMethod.POST)
	public ModelAndView verify(@Validated UserEntity user, ModelMap model) {
		List<UserEntity> users = new ArrayList<UserEntity>();
		users.add(user);
		users.add(new UserEntity("A", "123456"));
		users.add(new UserEntity("B", "123456"));

		ModelAndView mav = new ModelAndView();
		mav.addObject("users", users);
		mav.setViewName("users");

		return mav;
	}


	
}
