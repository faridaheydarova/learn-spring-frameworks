package az.developia.spring_rest_project.controller;


import az.developia.spring_rest_project.dto.StudentAddRequestDTO;
import az.developia.spring_rest_project.dto.StudentListResponseDTO;
import az.developia.spring_rest_project.dto.StudentResponseDTO;
import az.developia.spring_rest_project.dto.StudentUpdateRequestDTO;
import az.developia.spring_rest_project.exception.OurException;
import az.developia.spring_rest_project.service.StudentService;
import jakarta.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
 
@RestController
@RequestMapping(path="students")

public class StudentRestController {

	@Autowired 
	private StudentService studentService;

	@PostMapping(path="/save")
	@ResponseStatus(value=HttpStatus.ACCEPTED)
	public void add( @RequestBody StudentAddRequestDTO req ) {

		studentService.add(req);

	}
	
	
	@PutMapping(path="/update")
	public void update(@RequestBody StudentUpdateRequestDTO req, BindingResult br) {
		if(br.hasErrors()) {
			throw new OurException("melumatlari tam doldurun", null);
		}
		studentService.update(req);
	}
	
	@DeleteMapping(path="/{id}")
	@ResponseStatus(value=HttpStatus.OK)
	public void delete(@PathVariable Long id) {
	 studentService.deleteById(id);
	}

	@GetMapping(path="/{id}")
	public StudentResponseDTO findById(@PathVariable Long id){
		return studentService.findById(id);
	}

	@GetMapping(path = "all")
public StudentListResponseDTO findAll(){
		return studentService.findAll();
}
	//localhost:8081/students/pagination/begin/4/length/2
	@GetMapping(path = "pagination/begin/{begin}/length/{length}")
public StudentListResponseDTO findAllPagination(@PathVariable Integer begin, @PathVariable Integer length){
		return studentService.findAllPagination(begin, length);
}

	
	
}
	

	
	
	
