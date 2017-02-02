package fi.haagahelia.course.web;


import fi.haagahelia.course.domain.Book;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BookController {
	
@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String hello(@ModelAttribute Book book) {
		ArrayList<>
		return "index";
	}

}
