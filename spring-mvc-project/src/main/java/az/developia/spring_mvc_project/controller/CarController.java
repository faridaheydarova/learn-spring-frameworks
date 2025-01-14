package az.developia.spring_mvc_project.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import az.developia.spring_mvc_project.model.Car;


@Controller
@RequestMapping(path="/cars")
public class CarController {

	@GetMapping
	public String showCar(Model model) {
		ArrayList<String> carList =new ArrayList<String>();
		carList.add("bmw");
		carList.add("audi");
		carList.add("mercedes");
		carList.add("ferrari");
		model.addAttribute("carList", carList );
	
		return "car";
	}
	
	@GetMapping(path="/open-save-page")
	public String showSaveCar(Model model ) {
		Car car=new Car();
		
		model.addAttribute("cars", car);
		return "save-car";
	}

	@PostMapping(path="/save")
	public String saveCar(@ModelAttribute(name="cars") Car carInfo) {
		System.out.println(carInfo);
		return "redirect:/home";
		
		//redirecting-her shey deyishir(web-page+link)
		//forwarding-web page deyishir link deyishmir
	}
	
	
}
