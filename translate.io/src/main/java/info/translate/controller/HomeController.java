package info.translate.controller;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		model.addAttribute("name", "hamid");
		return "home";
	}

	@RequestMapping(value = "/{word}", method = RequestMethod.GET)
	public String homeWithParam(@PathVariable String word, Model model) {
		return "redirect:/blah";
	}

}
