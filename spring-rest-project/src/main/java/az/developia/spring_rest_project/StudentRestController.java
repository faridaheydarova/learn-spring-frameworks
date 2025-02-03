package az.developia.spring_rest_project;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentRestController {
	
	@GetMapping(path="/studentInfo")
	public Student studentInfo() {
		Student student=new Student();
		student.setName("Umid");
		student.setAge(13);
		return student;
	}
	
	

	@GetMapping(path="/greet")
		public String greet(@RequestParam (name="name", required=false, defaultValue="Guest") String name) {
			return "Hello"+name;
		}
	

	
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

}