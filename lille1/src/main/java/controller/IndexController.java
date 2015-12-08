package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.Client;
import service.InteractionBanque;

@Controller
public class IndexController {

	@Autowired
	private InteractionBanque interactionBanque;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String index(Model model) {
		model.addAttribute("client", new Client());
		return "index";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String index(@ModelAttribute("client") Client client, final BindingResult bindingResult, Model model) {
		boolean response = interactionBanque.connecter(client);
		if (response == false) {
			model.addAttribute("error", "Erreur de connexion");
			return "index";
		}
		client.setConnected(true);
		model.addAttribute("reponse", response);
		return "index";
	}
}
