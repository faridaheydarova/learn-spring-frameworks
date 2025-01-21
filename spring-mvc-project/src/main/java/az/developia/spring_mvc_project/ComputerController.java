package az.developia.spring_mvc_project;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ComputerController {
	
	@GetMapping
	public String showComputer(	Model model ) {
			
			model.addAttribute("computers", computerService.findAll());
		
		return "computers";
	}
	

}
