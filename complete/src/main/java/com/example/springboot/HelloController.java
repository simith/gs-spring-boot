package com.example.springboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.google.gson.*;

@RestController
public class HelloController {

	@GetMapping("/")
	public String index() {
		return "Greetings from Spring Boot! Auto reload";
	}

	@GetMapping("/abhi")
	public String abhi() {

		Gson gson = new Gson();

		return "Greetings from Abhinav!";
	}

}
