package az.developia.spring_mvc_project.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import az.developia.spring_mvc_project.model.Student;


@Controller
@RequestMapping(path="/students")
public class StudentsController {

	@GetMapping
	public String showStudent(Model model,
			@RequestParam(name="s", required=false, defaultValue =" ") String s) {
		ArrayList<String> studentList =new ArrayList<String>();
		studentList.add("Mert");
		studentList.add("Umid");
		studentList.add("Shahbaz");
		studentList.add("Shahbaz");
		studentList.add("Dashkend");
		studentList.add("Shahbaz");
		studentList.add("Farida");
		studentList.add("Shahbaz");
		studentList.add("Shahbaz");
		ArrayList<String> listFiltered =new ArrayList<String>();

		 for(String e:studentList) {
			 if(e.contains(s)) 
		 listFiltered.add(e);
			 
		 }
		model.addAttribute("studentList", listFiltered);
		//model.addAttribute("studentList", studentList);
		return "students";
	}
	
	@GetMapping(path="/open-save-page")
	public String showSaveStudent(Model model ) {
		Student student=new Student();
		
		model.addAttribute("students", student);
		return "save-students";
	}

	@PostMapping(path="/save")
	public String saveStudent(@ModelAttribute(name="students") Student studentInfo) {
		System.out.println(studentInfo);
		return "redirect:/home";
		
		//redirecting-her shey deyishir(web-page+link)
		//forwarding-web page deyishir link deyishmir
	}
	
	
}
