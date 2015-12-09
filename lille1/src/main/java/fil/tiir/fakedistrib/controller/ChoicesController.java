package fil.tiir.fakedistrib.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fil.tiir.fakedistrib.entity.Client;
import fil.tiir.fakedistrib.service.InteractionBanque;

/**
 * Controller for the "choices a user can make when logged in" function of the
 * ATM TODO
 */
@Controller
public class ChoicesController {

	@Autowired
	private InteractionBanque interactionBanque;

	@RequestMapping(value = "/choices", method = RequestMethod.GET)
	public String index(Model model, @ModelAttribute Client client) {
		return "choices";
	}

}
