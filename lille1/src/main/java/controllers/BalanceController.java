package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import model.Client;
import serviceimpl.InteractionBanqueImpl;

/**
 * Controller for the balance function of the ATM
 * TODO : Make it work ! Like other controllers..
 */
@Controller
public class BalanceController {

	private InteractionBanqueImpl interactionBanque = new InteractionBanqueImpl();

	@RequestMapping(value = "/balance", method = RequestMethod.GET)
	public String balance(@ModelAttribute("client") Client client, final BindingResult bindingResult, Model model) {
		model.addAttribute("client", new Client());
		
		System.out.println(client.getHash());
		boolean response = interactionBanque.connecter(client);
		if (response == false) {
			model.addAttribute("error", "Erreur de connexion");
			return "index";
		}
		client.setConnected(true);
		model.addAttribute("reponse", response);
		
		return "balance";
	}
}
