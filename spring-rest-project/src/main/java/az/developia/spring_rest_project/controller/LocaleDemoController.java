package az.developia.spring_rest_project.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

@RequestMapping(path="locale")
public class LocaleDemoController {

	private  MessageSource messageSource;
	
	public LocaleDemoController(MessageSource messageSource) {
		this.messageSource=messageSource;
	}
	
	@GetMapping(path="/with-headed")
	public String sayWelcome(
			@RequestHeader(name="Accept-Language", required =false)
			Locale locale
			){
		return messageSource.getMessage("hello", null, LocaleContextHolder.getLocale());
	}

}
