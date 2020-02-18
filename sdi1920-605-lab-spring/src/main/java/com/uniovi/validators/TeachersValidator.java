package com.uniovi.validators;

import com.uniovi.entities.Mark;
import com.uniovi.entities.Teacher;
import com.uniovi.entities.User;
import com.uniovi.services.TeacherService;
import com.uniovi.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.*;

@Component
public class TeachersValidator implements Validator {

	private TeacherService teachersService;

	@Override
	public boolean supports(Class<?> aClass) {
		return User.class.equals(aClass);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Teacher user = (Teacher) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dni", "Error.empty");
		if (user.getDni().length() != 9) {
			errors.rejectValue("dni", "Error.signup.dni.length");
		}
		if (!Character.isLetter(user.getDni().charAt(user.getDni().length()-1))) {
			errors.rejectValue("dni", "Error.signup.dni.letter");
		}
		if (user.getName().length() < 5 || user.getName().length() > 24) {
			errors.rejectValue("name", "Error.signup.name.length");
		}
	}
}