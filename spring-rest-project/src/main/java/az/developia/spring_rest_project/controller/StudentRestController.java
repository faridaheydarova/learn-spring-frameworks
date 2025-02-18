package az.developia.spring_rest_project.controller;


import az.developia.spring_rest_project.dto.StudentAddRequestDTO;
import az.developia.spring_rest_project.exception.OurException;
import az.developia.spring_rest_project.service.StudentService;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
 
@RestController
@RequestMapping(path="students")

public class StudentRestController {

	@Autowired 
	private StudentService studentService;
	
	@PostMapping
	public void add(@Valid @RequestBody StudentAddRequestDTO req, BindingResult br) {
		if(br.hasErrors()) {
			throw new OurException("melumatlari tam doldurun", null);
		}
		
		studentService.add(req);
	}
	
}
	

	
	
	
