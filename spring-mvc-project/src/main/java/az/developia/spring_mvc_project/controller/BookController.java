package az.developia.spring_mvc_project.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import az.developia.spring_mvc_project.model.Book;
import az.developia.spring_mvc_project.service.BookService;

@Controller
@RequestMapping(path="/book")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@GetMapping
	public String showBoook(Model model) {
		
		model.addAttribute("books", bookService.findAll());
	
		return "books";
	}
	
	@GetMapping(path="/open-save-page")
	public String showSaveBook(Model model ) {
Book book=new Book();
		model.addAttribute("books", book);
		return "save-book";
	}

	@PostMapping(path="/save")
	public String saveBook(@ModelAttribute(name="books") Book bookInfo) {
		System.out.println(bookInfo);
		return "redirect:/home";
		

}
}
