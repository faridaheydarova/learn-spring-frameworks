package az.developia.spring_rest_project.service;


import az.developia.spring_rest_project.dto.*;

import lombok.RequiredArgsConstructor;

import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import az.developia.spring_rest_project.entity.Authorities;
import az.developia.spring_rest_project.entity.AuthorityListEntity;
import az.developia.spring_rest_project.entity.Student;
import az.developia.spring_rest_project.entity.UserEntity;
import az.developia.spring_rest_project.exception.OurException;
import az.developia.spring_rest_project.repository.AuthoriesRepository;

import az.developia.spring_rest_project.repository.StudentRepository;
import az.developia.spring_rest_project.repository.UserRepository;

import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
	
	private final UserRepository repo;
	
	@Override
	public void add(UserAddRequestDTO req) {
	
	String password =req.getPassword();
	BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
	
	
	String bcPassword= "{bcrypt}"+encoder.encode(password);
	
		UserEntity user=new UserEntity (req.getUsername(),bcPassword,1);
		repo.save(user);
		repo.addUserAuthorities(req.getUsername());
		
	}



}

