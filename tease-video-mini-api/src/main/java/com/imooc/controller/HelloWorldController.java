package com.imooc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试
 */
@RestController
public class HelloWorldController {
	
	@RequestMapping("/hello")
	public String Hello() {
		return "Hello Spring Boot~";
	}
	
}
