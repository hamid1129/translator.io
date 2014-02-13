package info.translate.controller;

import info.translate.domain.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

	private static final Logger LOG = LoggerFactory.getLogger(LoginController.class);

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String getLogin(@ModelAttribute("user") User user, BindingResult result, Model model) {

		System.out.println(user.hashCode());
		LOG.debug(String.valueOf(user.hashCode()));
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String postLogin(@ModelAttribute("user") User user, BindingResult result, Model model) {

		LOG.info(user.getUsername());
		LOG.info(user.getPassword());
		return "login";
	}

}
