package az.developia.spring_mvc_project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path="/home")
public class HomeController {
	
	@GetMapping
	
	public String showHome() {
		return "home";
		
	}
	

}
