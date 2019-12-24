package com.bcdl.controller;

import java.text.DateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@Scope("prototype")
public class IndexController {

	private static final Logger log = LoggerFactory.getLogger(IndexController.class);
	
	@RequestMapping("/index_jsp")
	public String index_jsp(Model m){
		m.addAttribute("TIME", DateFormat.getDateTimeInstance().format(new Date()));
		return "jsp/index";
	}

	@RequestMapping("/index_html")
	public String index_html(Model m){
		m.addAttribute("TIME", DateFormat.getDateTimeInstance().format(new Date()));
		return "thymeleaf/index";
	}

}
