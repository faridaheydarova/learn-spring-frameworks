package az.developia.spring_mvc_project;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class ComputerService {
	
	@Autowired
	public ComputerRepository compRepository;
	

	public List<Computer> findAll() {
		
		return compRepository.findAll() ;
	}

	
}


