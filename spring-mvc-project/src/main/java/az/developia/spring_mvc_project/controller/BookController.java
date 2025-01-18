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
	
	
/*	@GetMapping
	public String showBoook(Model model,
			@RequestParam(name="q", required=false, defaultValue =" ") String b){
		
		model.addAttribute("books", bookService.findAll(b));
	
		return "books";
	}
*/

	@GetMapping
	public String showBoook(Model model, String b){
		
		model.addAttribute("books", bookService.findAll(b));
	
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
Integer id=	bookService.add(bookInfo);
System.out.println(id);
		return "redirect:/book";
		

}
}
