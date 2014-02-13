package info.translate.domain.validator;

import info.translate.domain.User;
import info.translate.service.UserService;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

@Component
public class UserLoginValiadtor extends AbstractUserValidator {

	public UserLoginValiadtor() {
		super();
	}

	@Autowired
	public UserLoginValiadtor(UserService service) {
		super(service);
	}

	@Override
	public void validate(Object tar, Errors errors) {

		Assert.notNull(tar, "target object should not be null");

		ValidationUtils.rejectIfEmpty(errors, "username", "username.empty");
		ValidationUtils.rejectIfEmpty(errors, "password", "password.empty");

		User target = (User) tar;
		User source = service.findByUsername(target.getUsername());

		if (source == null) {
			errors.reject("user.not.exist");
			return;
		} else if (!passwordsAreEquall(source.getPassword(), target.getPassword())) {
			errors.rejectValue("password", "password.not.match");
		}

	}

	private boolean passwordsAreEquall(String source, String target) {

		return BCrypt.checkpw(target, source);
	}
}
