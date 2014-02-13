package info.translate.controller;

import static org.junit.Assert.*;
import info.translate.configuration.DataJPAConfiguration;
import info.translate.domain.User;
import info.translate.repository.UserRepository;

import org.junit.Test;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = DataJPAConfiguration.class)
public class UserControllerTest extends AbstractBaseConfig {
	@Autowired
	UserRepository repository;

	@Test
	public void insertUser() {
		User user = new User();
		user.setUsername("hamid");

		User user2 = repository.save(user);
		assertEquals(user2.getId(), repository.findOne(user2.getId()).getId());

	}

	@Test
	public void hashedPassword() {
		User user = new User();
		user.setUsername("hamid");

		user.setPassword(BCrypt.hashpw("123456", BCrypt.gensalt()));
		assertTrue(BCrypt.checkpw("123456", user.getPassword()));
	}
}
