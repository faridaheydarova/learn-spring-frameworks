package az.developia.spring_rest_project.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import az.developia.spring_rest_project.dto.StudentAddRequestDTO;
import az.developia.spring_rest_project.dto.UserAddRequestDTO;
import az.developia.spring_rest_project.entity.Authorities;
import az.developia.spring_rest_project.repository.AuthoriesRepository;
import az.developia.spring_rest_project.service.UserService;
import jakarta.validation.Valid;

@RestController
@RequestMapping(path="/users")

public class UserRestController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private AuthoriesRepository authRepo;
	

	@PostMapping(path="/save")
	@ResponseStatus(code=HttpStatus.CREATED)
	public void add(@RequestBody UserAddRequestDTO req ) {

		userService.add(req);

	}
	
	@GetMapping(path="/login")
	public List<String> login() {
	    String username = SecurityContextHolder.getContext().getAuthentication().getName();
	    return authRepo.findAllByUsername(username)
	                   .stream()
	                   .map(Authorities::getAuthority)
	                   .collect(Collectors.toList());
	}

	
	
}
