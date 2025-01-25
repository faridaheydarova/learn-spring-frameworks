package az.developia.spring_mvc_project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path="/computers")
public class ComputerController {
		
	@Autowired
	private ComputerService computerService;
	
	
	@GetMapping
	public String showComputer(	Model model ) {
			
			model.addAttribute("computers", computerService.findAll());
		
		return "computers";
	}
	

}
