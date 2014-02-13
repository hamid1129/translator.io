package info.translate.domain.validator;

import org.springframework.beans.factory.annotation.Autowired;

import info.translate.domain.User;
import info.translate.service.UserService;

public abstract class AbstractUserValidator implements UserValidator {
	UserService service;

	public AbstractUserValidator() {
	}

	@Autowired
	public AbstractUserValidator(UserService service) {
		super();
		this.service = service;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.isAssignableFrom(User.class);
	}

}
