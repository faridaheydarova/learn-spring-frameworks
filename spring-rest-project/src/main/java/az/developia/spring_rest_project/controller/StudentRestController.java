package az.developia.spring_rest_project.controller;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import az.developia.spring_rest_project.entity.Student;
import az.developia.spring_rest_project.exception.OurException;
import az.developia.spring_rest_project.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="students")
public class StudentRestController {
	
	@Autowired
	private StudentRepository studentRepo;
	
	@GetMapping(path="/studentInfo")
	public Student studentInfo() {
		Student student=new Student();
		student.setName("Umid");
		student.setAge(13);
		return student;
	}
@GetMapping(path="{id}")

public Student findById(@PathVariable Long id){

	Student s=new Student("Farida",27);

	studentRepo.save(s);

	Optional<Student>result=studentRepo.findById(id);
	if(result.isPresent()) {
		return result.get();
	}else {
		throw new OurException("telebe tapilmadi id="+id,"student not found");
	}





}

@GetMapping(path="/search")
public List<Student> findAll(){
		List<Student>students=studentRepo.findAllByAge(25);
		return students;
}
@ExceptionHandler
public String handleOurException(OurException exc) {
	return exc.getMessage();
}




}
	

	
	
	
