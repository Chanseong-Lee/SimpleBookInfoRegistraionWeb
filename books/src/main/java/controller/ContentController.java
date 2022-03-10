package controller;

import org.springframework.beans.TypeMismatchException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import booksdto.BooksDTO;
import exceptions.BookNotFoundException;
import service.ContentService;

@Controller
public class ContentController {
	private ContentService contentService;
	
	public void setContentService(ContentService contentService) {
		this.contentService = contentService;
	}
	@RequestMapping("/read/{num}")
	public String content(@PathVariable("num") Long num,Model model) {
		BooksDTO book = (BooksDTO) contentService.showContent(num);
		if(book == null) {
			throw new BookNotFoundException();
		}
		model.addAttribute("book", book);
		return "book_detail";
	}
	
	@ExceptionHandler(TypeMismatchException.class)
	public String bookNumberTypeMismatch() {
		return "exceptions/numTypeEx";
	}
	
	@ExceptionHandler(BookNotFoundException.class)
	public String noBook() {
		return "exceptions/noBook";
	}
	
	
}
