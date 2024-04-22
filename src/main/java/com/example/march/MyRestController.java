package com.example.march;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MyRestController {
	@GetMapping("/hello")
	public String hello() {
		return "Hello Test API";
	}
	
	@PostMapping("/returnTest")
	public String returnTest(@RequestBody(required = false) String msg) {
		return "You Said"+msg;
	}

}
