package controllers;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import model.Client;
import serviceimpl.InteractionBanqueImpl;

@RestController
public class IndexController {

	private InteractionBanqueImpl interactionBanque = new InteractionBanqueImpl();

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(Model model) {
		model.addAttribute("client", new Client());
		return "index";
	}

	@RequestMapping(value = "/index", method = RequestMethod.POST)
	public String index(@ModelAttribute("client") Client client, final BindingResult bindingResult, Model model) {
		System.out.println("test");
		System.out.println(client.getHash());
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
