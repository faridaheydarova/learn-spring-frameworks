package az.developia.spring_rest_project.service;


import az.developia.spring_rest_project.dto.StudentListResponseDTO;
import org.springframework.stereotype.Service;

import az.developia.spring_rest_project.dto.StudentAddRequestDTO;
import az.developia.spring_rest_project.dto.StudentResponseDTO;
import az.developia.spring_rest_project.dto.StudentUpdateRequestDTO;
@Service
public interface StudentService {
	
	void add(StudentAddRequestDTO req);
	void update(StudentUpdateRequestDTO req);
	void deleteById(Long id);
	StudentResponseDTO findById(Long id);

	StudentListResponseDTO findAll();
	StudentListResponseDTO findAllPagination(Integer begin, Integer length);
}
