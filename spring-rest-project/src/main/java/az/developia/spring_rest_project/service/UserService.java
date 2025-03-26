package az.developia.spring_rest_project.service;


import org.springframework.stereotype.Service;

import az.developia.spring_rest_project.dto.UserAddRequestDTO;


@Service
public interface UserService {
	
	void add(UserAddRequestDTO req);
	
}
