package validate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import command.RegistCommand;


public class RegistCommandValidator implements Validator {
	@Override
	public boolean supports(Class<?> arg0) {
		return RegistCommand.class.isAssignableFrom(arg0);
	}
	@Override
	public void validate(Object target, Errors errors) {
		RegistCommand rc = (RegistCommand) target;
		if(rc.getImgFile().isEmpty()) {
			errors.rejectValue("imgFile", "required");
		}
		/*
		String regExp = "^[0-9]*$";
		Pattern pattern = Pattern.compile(regExp);
		Matcher matcher = pattern.matcher(rc.getPrice().toString());
		if(!matcher.matches()) {
			errors.rejectValue("price", "notNumber");
		}
		*/
		
//		if(rc.getPrice() == -1L) {
//			errors.rejectValue("price", "notNumber");
//		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "isbn", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "bookname", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "writer", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "publisher", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "price", "required");
		ValidationUtils.rejectIfEmpty(errors, "imgFile", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "content", "required");
	}
}
