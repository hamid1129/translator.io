package info.translate.domain.validator;

import static org.junit.Assert.*;
import info.translate.configuration.DataJPAConfiguration;
import info.translate.controller.AbstractBaseConfig;
import info.translate.domain.User;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DirectFieldBindingResult;

@ContextConfiguration(classes = DataJPAConfiguration.class)
public class UserLoginValidatorTest extends AbstractBaseConfig {
	@Autowired
	private UserValidator validator;

	BindingResult result;

	@Test
	public void clazzSupportByValidator() {
		assertTrue("does not support", validator.supports(User.class));
	}

	@Test
	public void validateUserPassword() {

		User user = new User();
		user.setUsername("hamid");
		user.setPassword("123");

		result = new DirectFieldBindingResult(user, "user");
		
		validator.validate(user, result);
		assertTrue(result.hasErrors());
	}
}
