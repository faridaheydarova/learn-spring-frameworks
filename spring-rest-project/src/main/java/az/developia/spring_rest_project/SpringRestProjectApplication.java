package az.developia.spring_rest_project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import az.developia.spring_rest_project.service.MyService;
import az.developia.spring_rest_project.service.StudentService;

@SpringBootApplication
public class SpringRestProjectApplication implements CommandLineRunner{
	
	@Autowired
	private MyService myService;
	
	@Autowired
	private StudentService studentService;

	public static void main(String[] args) {
		SpringApplication.run(SpringRestProjectApplication.class, args);
		

	}

	@Override
	public void run(String...args) {
		
		myService.doSomeThing();
		studentService.add(null);
		
	}
	


}
