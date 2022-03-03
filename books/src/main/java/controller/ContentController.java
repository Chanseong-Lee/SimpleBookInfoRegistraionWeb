package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import booksdto.BooksDTO;

@Controller
public class ContentController {
	private BooksDAO booksDAO;
	
	public void setBooksDTO(BooksDAO booksDAO) {
		this.booksDAO = booksDAO;
	}
	@RequestMapping("/read/{num}")
	public String content(@PathVariable("num") int num, Model model) {
		BooksDTO booksDTO = 
		return "";
	}
	
	
}
