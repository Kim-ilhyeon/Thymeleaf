package com.kh.thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

	@GetMapping("/")
	public String in(Model model) {
		
		int[] data = {1, 2, 3};
		
		model.addAttribute("data", data);
		
		
		return "index";
		
	}
	
}
