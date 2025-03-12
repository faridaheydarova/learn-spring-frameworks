package az.developia.spring_rest_project.service;


import az.developia.spring_rest_project.dto.*;
import lombok.RequiredArgsConstructor;

import org.modelmapper.ModelMapper;

import org.springframework.stereotype.Service;

import az.developia.spring_rest_project.entity.Authority;
import az.developia.spring_rest_project.entity.Student;
import az.developia.spring_rest_project.exception.OurException;
import az.developia.spring_rest_project.repository.AuthoriyRepository;
import az.developia.spring_rest_project.repository.StudentRepository;

import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {


	private final StudentRepository studentRepository;
	private final ModelMapper mapper;
	private final AuthoriyRepository repo;


	@Override
	public void add(StudentAddRequestDTO req) {

		Student student = new Student();
		mapper.map(req,student);

		Authority authority=new Authority();
		authority.setUsername(req.getName());
		authority.setAuthority("STUDENT");
		
		repo.save(authority);
		studentRepository.save(student);
	}

	@Override
	public void update(StudentUpdateRequestDTO req) {
		Long id = req.getId();
		Student student = studentRepository.findById(id).orElseThrow(() -> new OurException("telebe tapilmadi", null));

		student.setName(req.getName());
		student.setAge(req.getAge());
		student.setPhone(req.getPhone());


		studentRepository.save(student);

	}

	@Override
	public void deleteById(Long id) {
		studentRepository.deleteById(id);

	}

	@Override
	public StudentResponseDTO findById(Long id) {
		Student student = studentRepository.findById(id).orElseThrow(() -> new OurException("telebe tapilmadi", null));
		StudentResponseDTO dto = new StudentResponseDTO();
		mapper.map(student, dto);
		return dto;

	}

	@Override
	public StudentListResponseDTO findAll() {
		List<Student> studentEntity = studentRepository.findAll();
		StudentListResponseDTO dto =new StudentListResponseDTO();
		List<StudentResponseEntityDTO> dtoEntities=new ArrayList<StudentResponseEntityDTO>();
		for(Student s: studentEntity){
			StudentResponseEntityDTO dtoo=new StudentResponseEntityDTO();
			mapper.map(s,dtoo);
			dtoEntities.add(dtoo);
		}
		dto.setStudents(dtoEntities);
		return dto;
	}

	@Override
	public StudentListResponseDTO findAllPagination(Integer begin, Integer length) {
		
		List<Student> studentEntity = studentRepository.findAllPagination(begin,length);
		StudentListResponseDTO dto =new StudentListResponseDTO();
		List<StudentResponseEntityDTO> dtoEntities=new ArrayList<StudentResponseEntityDTO>();
		for(Student s: studentEntity){
			StudentResponseEntityDTO dtoo=new StudentResponseEntityDTO();
			mapper.map(s,dtoo);
			dtoEntities.add(dtoo);
		}
		dto.setStudents(dtoEntities);
		return dto;
	}



}

