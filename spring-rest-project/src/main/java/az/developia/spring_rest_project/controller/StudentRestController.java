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
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
 
@RestController
@RequestMapping(path="students")

public class StudentRestController {

	@Autowired 
	private StudentService studentService;

	@PostMapping(path="/save")
	@ResponseStatus(value=HttpStatus.ACCEPTED)
	@PreAuthorize(value="hasAthority('ROLE_ADD_STUDENT')")
	public void add( @RequestBody StudentAddRequestDTO req ) {

		studentService.add(req);

	}
	
	
	@PutMapping(path="/update")
	@PreAuthorize(value="hasAthority('ROLE_UPDATE_STUDENT')")
	public void update(@RequestBody StudentUpdateRequestDTO req, BindingResult br) {
		if(br.hasErrors()) {
			throw new OurException("melumatlari tam doldurun", null);
		}
		studentService.update(req);
	}
	
	@DeleteMapping(path="/{id}")
	
	@ResponseStatus(value=HttpStatus.OK)
	@PreAuthorize(value="hasAthority('ROLE_DELETE_STUDENT')")
	public void delete(@PathVariable Long id) {
	 studentService.deleteById(id);
	}

	@GetMapping(path="/{id}")
	@PreAuthorize(value="hasAthority('ROLE_SEARCH_ID_STUDENT')")
	public StudentResponseDTO findById(@PathVariable Long id){
		return studentService.findById(id);
	}

	@GetMapping(path = "all")
	@PreAuthorize(value="hasAthority('ROLE_FINDALL_STUDENT')")
public StudentListResponseDTO findAll(){
		return studentService.findAll();
}
	//localhost:8081/students/pagination/begin/4/length/2
	@GetMapping(path = "pagination/begin/{begin}/length/{length}")
	@PreAuthorize(value="hasAthority('ROLE_PAGINATION_STUDENT')")
public StudentListResponseDTO findAllPagination(@PathVariable Integer begin, @PathVariable Integer length){
		return studentService.findAllPagination(begin, length);
}

	
	
}
	

	
	
	
