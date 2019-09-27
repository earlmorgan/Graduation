package com.bcdl.controller;

import java.text.DateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
	@RequestMapping("/index")
	public String index(Model m){
		m.addAttribute("TIME", DateFormat.getDateTimeInstance().format(new Date()));
		return "index";
	}
	
}
