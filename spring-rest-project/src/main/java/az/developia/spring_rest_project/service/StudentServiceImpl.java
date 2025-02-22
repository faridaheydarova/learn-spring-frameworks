package az.developia.spring_rest_project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import az.developia.spring_rest_project.dto.StudentAddRequestDTO;
import az.developia.spring_rest_project.dto.StudentUpdateRequestDTO;
import az.developia.spring_rest_project.entity.Student;
import az.developia.spring_rest_project.exception.OurException;
import az.developia.spring_rest_project.repository.StudentRepository;
@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public void add(StudentAddRequestDTO req) {

			Student student=new Student();
			student.setName(req.getName());
			student.setAge(req.getAge());
			student.setPhone(req.getPhone());
			
			
			studentRepository.save(student);
		}

	@Override
	public void update(StudentUpdateRequestDTO req) {
		Long id = req.getId();
		Student student=studentRepository.findById(id).orElseThrow(()-> new OurException("telebe tapilmadi", null));
		
		student.setName(req.getName());
		student.setAge(req.getAge());
		student.setPhone(req.getPhone());
		
		
		studentRepository.save(student);
		
	}

	@Override
	public void deleteById(Long id) {
		studentRepository.deleteById(id);
		
	}



	

	}

