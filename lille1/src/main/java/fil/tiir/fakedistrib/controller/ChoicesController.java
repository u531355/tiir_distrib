package fil.tiir.fakedistrib.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fil.tiir.fakedistrib.entity.Client;

/**
 * Controller for the "choices a user can make when logged in" function of the
 * ATM
 */
@Controller
public class ChoicesController {

	@RequestMapping(value = "/choices", method = RequestMethod.GET)
	public String choices(Model model, HttpSession session) {
		Client client = (Client) session.getAttribute("client");
		if (client == null)
			return "redirect:/";
		return "choices";
	}

}
