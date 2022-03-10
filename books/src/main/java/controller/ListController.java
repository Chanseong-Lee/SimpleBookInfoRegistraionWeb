package controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import booksdto.BooksDTO;
import command.SearchCommand;
import service.ListService;

@Controller
public class ListController {
	private ListService listService;

	public void setListService(ListService listService) {
		this.listService = listService;
	}
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String showList(@ModelAttribute("command") SearchCommand searchCommand, Model model) {
		List<BooksDTO> books = listService.showList();
		model.addAttribute("books", books);
		return "book_list";
	}
	

}
