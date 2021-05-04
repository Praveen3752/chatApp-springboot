package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TempController 
{
	@GetMapping("/test")
	public String sampleMethod()
	{
		return "hello";
	}

}
