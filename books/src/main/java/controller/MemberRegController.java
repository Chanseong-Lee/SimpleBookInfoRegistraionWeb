package controller;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import command.MemberRegistCommand;
import service.MemberRegService;

@Controller
public class MemberRegController {
	@Autowired
	private MemberRegService memberRegService;

	public void setMemberRegService(MemberRegService memberRegService) {
		this.memberRegService = memberRegService;
	}
	
	@RequestMapping(value="/addMem", method=RequestMethod.GET)
	public String goRegForm(@ModelAttribute("mrc")MemberRegistCommand memberRegistCommand) {
		
		return "member/member_reg_form";
	}
	
	@RequestMapping(value="/addMem", method=RequestMethod.POST)
	public String regMem(@ModelAttribute("mrc")MemberRegistCommand memberRegistCommand, Errors error,RedirectAttributes rttr) {
		
		try {
			memberRegService.registMem(memberRegistCommand);
			rttr.addFlashAttribute("msg", "가입이 완료되었습니다.");
			rttr.addAttribute("name", memberRegistCommand.getName());
			rttr.addAttribute("email", memberRegistCommand.getEmail());
			return "redirect:/regSuccess";
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return "exceptions/encodingEx";
		} catch (MessagingException e) {
			e.printStackTrace();
			return "exceptions/messageEx";
		}
	}
	
	@RequestMapping(value="/regSuccess", method=RequestMethod.GET)
	public String afterRegMem(HttpServletRequest request) {
		
		
		return "member/member_reg_success";
	}
}
