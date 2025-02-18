package az.developia.spring_rest_project.service;



import org.springframework.stereotype.Service;

import az.developia.spring_rest_project.dto.StudentAddRequestDTO;
@Service
public interface StudentService {
	
	void add(StudentAddRequestDTO req);

}
