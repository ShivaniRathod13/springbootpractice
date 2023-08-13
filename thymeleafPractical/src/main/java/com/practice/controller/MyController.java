package com.practice.controller;


import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MyController {
	
	@RequestMapping(value = "/about",method = RequestMethod.GET )
	public String about(Model model) 
	{
		System.out.println("Inside about handler..");
		//putting data
		model.addAttribute("name","shivi");
		model.addAttribute("currentDate",new Date().toLocaleString());
		return "about";
	}
	//handling iteration
	
	@GetMapping("/example-loop")
	public String iterateHandler(Model m) {
		List<String> names = List.of("Ankita","laxmi","riya","Jiya");
		m.addAttribute("names",names);
		return "iterate";
		
		
	}
	
	//handler for condtional statments
	
	@GetMapping("/condition")
    public String conditionHandler(Model m) {
		System.out.println("condition handler");
		m.addAttribute("isActive",false);
		m.addAttribute("gender","F");
		List<Integer> list = List.of();
		m.addAttribute("myList",list);
		return "condition";
	}
	
	//handler for including fragment
	
	@GetMapping("/service")
	public String servicesHandler(Model m) {
		m.addAttribute("title","I like to eat fruit");
		m.addAttribute("substitle",LocalDateTime.now().toString());
		return "service";
		
	}
	//for new
	
	@GetMapping("/newabout")
	public String newAbout() {
		return "aboutnew";
}
	@GetMapping("/contact")
	public String contact() {
		return "contact";
}
	
}
