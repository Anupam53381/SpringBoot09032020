package com.zensar;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
	
	public HelloController() {
		System.out.println("test");
	}
	// http://localhsot:8080/spring-mvc/hello
	@RequestMapping("/hello")
	public String hello() {
		System.out.println("Hi");
		return "hello";
	}
	
	@RequestMapping("/hi")
	public String sayHi() {
		return "hi";
	}

}
