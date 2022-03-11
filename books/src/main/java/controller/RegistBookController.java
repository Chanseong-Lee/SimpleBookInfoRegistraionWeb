package controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import command.RegistCommand;
import exceptions.AlreadyExistingBookException;
import exceptions.NoImageException;
import service.RegistBookService;
import validate.RegistCommandValidator;
@Controller
public class RegistBookController {
	private RegistBookService registBookService;
	public void setRegistBookService(RegistBookService registBookService) {
		this.registBookService = registBookService;
	}
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String goRegisterForm(@ModelAttribute("regForm") RegistCommand registCommand) {
		return "book_reg_form";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String regist(@ModelAttribute("regForm") RegistCommand registCommand, Errors errors) {
		
		//강사님께 file이 널일때, 에러메시지 출력하는법 물어보기
		new RegistCommandValidator().validate(registCommand, errors);
		
		if(errors.hasErrors()) {
			return "book_reg_form";
		}
		try {
			registBookService.register(registCommand);
			return "redirect:/list";
		}catch(AlreadyExistingBookException e) {
			errors.rejectValue("isbn", "dupBook");
			return "book_reg_form";
		}catch(NoImageException e) {
			errors.rejectValue("imgFile", "noImage");
			return "book_reg_form";
		}
	}

}
