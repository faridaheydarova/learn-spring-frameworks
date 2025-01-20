package az.developia.spring_mvc_project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping(path="/home")
	
	public String showHome() {
		return "home";
	}
	

}
