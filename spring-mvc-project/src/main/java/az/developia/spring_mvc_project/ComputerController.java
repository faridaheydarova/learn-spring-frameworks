package az.developia.spring_mvc_project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import az.developia.spring_mvc_project.model.Book;

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
	
	@GetMapping(path="/open-save-page")
	public String saveComputer(Model model ) {
		Computer computer = new Computer();
		model.addAttribute("computers", computer);
		return "save-computer";
	}

	@PostMapping(path="/save")
	public String saveComputer(@ModelAttribute(name="computers") Computer c) {
Integer id=	computerService.add(c);
System.out.println(id);
		return "redirect:/home";

	}
	

	@GetMapping(path="/delete/{id}")
	public String delete(@PathVariable Integer id) {
 computerService.deleteById(id);
 return "redirect:/computers";

	}


}
