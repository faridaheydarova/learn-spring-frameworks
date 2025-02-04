package az.developia.spring_rest_project;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
@GetMapping(path="save")
public List<Student> save(){
	Student s=new Student("Farida",27);
	studentRepo.save(s);

	return studentRepo.findAll();
}

//localhost:9595/students/studentInfo
	
	@GetMapping(path="studentListInfo")
	public List<Student> studentListInfo() {
		List<Student> studentList =new ArrayList<Student>();
		
		Student student=new Student();
		student.setName("Umid");
		student.setAge(13);
		
		Student student2=new Student();
		student2.setName("Mert");
		student2.setAge(14);
		
		studentList.add(student2);
		studentList.add(student);
		
		return studentList;
	}
	
	/*@GetMapping(path="/search")
	public List<Student> search (
@RequestParam(name="sorgu", required =false, defaultValue="Name") String sorgu){
	
List<Student>studentList=List.of(
		new Student("Farida"),
		new Student("Esmiralda"),
		new Student("Zuleyxa"));

List<Student> studentsFiltered=studentList.stream().filter(ss->ss.getName().contains(sorgu)).collect(Collectors.toList());
return studentsFiltered;
	}*/
}
	

	
	
	
