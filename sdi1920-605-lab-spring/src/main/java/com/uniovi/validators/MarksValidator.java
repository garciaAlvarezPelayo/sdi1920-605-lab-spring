package com.uniovi.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.uniovi.entities.Mark;
import com.uniovi.entities.User;
import com.uniovi.services.UsersService;

@Component
public class MarksValidator implements Validator {

	@Override
	public boolean supports(Class<?> aClass) {
		return User.class.equals(aClass);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Mark mark = (Mark) target;
		if (mark.getDescription().length() < 20) {
			errors.rejectValue("description", "Error.description.mark.length");
		}
		if (mark.getScore()<0 || mark.getScore()>10) {
			errors.rejectValue("score", "Error.score.mark.length");
		}
	}
}
