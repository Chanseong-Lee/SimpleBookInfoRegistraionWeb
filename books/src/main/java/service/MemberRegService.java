package service;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import booksdao.MemberDAO;
import booksdto.MemberDTO;
import command.MemberRegistCommand;
import email.MailUtils;
import email.TempKey;
@Service
public class MemberRegService {
	@Autowired
	private MemberDAO memberDAO;
	@Autowired
	private JavaMailSender mailSender;
	
	public void registMem(MemberRegistCommand mrc) throws MessagingException, UnsupportedEncodingException {
		
		//패스워드 암호화 구현
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encodedPw = encoder.encode(mrc.getPassword());
		/*
		//복호화 하는법(matchs()를 사용하면 복호화하여 비교한다.)
		if(encoder.matches(mrc.getPassword(), encodedPw)) {
			//로직
		}
		*/
		
		String validKey = "n";
		validKey = new TempKey().getKey(50, false);//대소문자구분해서 키 생성
		
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setEmail(mrc.getEmail());
		memberDTO.setName(mrc.getName());
		memberDTO.setPassword(encodedPw);
		memberDTO.setValidKey(validKey);
		memberDAO.insertMember(memberDTO);
		
		//이메일 인증 로직
		MailUtils sendMail = new MailUtils(mailSender);
		
		sendMail.setSubject("[북클럽] 이메일 인증");//제목
		sendMail.setText(
				"<h1>메일 인증</h1>"
				+ "<br>"
				+ "<p>"
				+ "<b><font color=\"pink\">" + memberDTO.getName() + "</font>님</b><br>"
				+ "북클럽에 가입해주셔서 대단히 감사합니다."
				+ "<br>아래 [이메일 인증 확인]을 눌러주세요.</p>"
				+ "<div border=\"1\" background-color=\"gray\">"
				+ "<p><a href=\"http://localhost:8080/books/verifyEmail?email="
				+ memberDTO.getEmail()+"&validKey="
				+ validKey + "\" target='_blank'><i>[이메일 인증 확인]</i></a></p>"
				+ "</div>"
				);
		sendMail.setFrom("leechanseong89@gmail.com", "이찬성");
		sendMail.setTo(memberDTO.getEmail());
		sendMail.send();//발송
	}
}
