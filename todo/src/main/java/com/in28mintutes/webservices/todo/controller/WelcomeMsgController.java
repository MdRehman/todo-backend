package com.in28mintutes.webservices.todo.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.in28mintutes.webservices.todo.entity.WelcomeBean;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class WelcomeMsgController {

	@GetMapping("/welcome")
	public String getWelcomeMessage()
	{
		return "Welcome Rehman";
	}
	
	@GetMapping("/welcome-bean")
	public WelcomeBean getWelcomeBean() {
		return new WelcomeBean("Hello-World_Bean");
	}
	
	@GetMapping("/welcome-bean/{name}")
	public WelcomeBean getWelcomeBean(@PathVariable String name) {
		return new WelcomeBean(name);
	}

}
