package az.developia.spring_rest_project.service;



import org.springframework.stereotype.Service;

import az.developia.spring_rest_project.dto.StudentAddRequestDTO;
import az.developia.spring_rest_project.dto.StudentUpdateRequestDTO;
@Service
public interface StudentService {
	
	void add(StudentAddRequestDTO req);
	void update(StudentUpdateRequestDTO req);
	void deleteById(Long id);

}
