package info.translate.service;

import info.translate.domain.User;
import info.translate.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Autowired
	private UserRepository repository;

	public User findByUsername(String username) {
		return repository.findByUsername(username);
	}

}
