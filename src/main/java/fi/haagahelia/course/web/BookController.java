package fi.haagahelia.course.web;

import fi.haagahelia.course.domain.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BookController {
	@Autowired
	private BookRepository repository;
	
	@RequestMapping(value = "/booklist", method = RequestMethod.GET)
	public String showBooks(Model model) {
		model.addAttribute("books", repository.findAll());
		return "booklist";
	}
}
