package controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import booksdto.BooksDTO;
import command.SearchCommand;
import service.SearchBookService;
import validate.SearchCommandValidator;

@Controller
public class SearchBookController {
	private SearchBookService searchBookService;

	public void setSearchBookService(SearchBookService searchBookService) {
		this.searchBookService = searchBookService;
	}
	
	@RequestMapping(value="/search", method=RequestMethod.GET)
	public String search(@ModelAttribute("command") SearchCommand searchCommand,Errors errors, Model model) {
		new SearchCommandValidator().validate(searchCommand, errors);
		List<BooksDTO> books = searchBookService.search(searchCommand);
		model.addAttribute("books", books);
		
		return "book_list";
	}
}
