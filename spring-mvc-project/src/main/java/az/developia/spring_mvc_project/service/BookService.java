package az.developia.spring_mvc_project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import az.developia.spring_mvc_project.model.Book;
import az.developia.spring_mvc_project.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepo;
	
	
	public List<Book> findAll(){
		return bookRepo.findAll();
	}


	public Integer add(Book bookInfo) {
		Integer id = 0;
		id=bookRepo.add(bookInfo);
		return id;
		
	}
	


	}


