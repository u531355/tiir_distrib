package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.Client;
import service.InteractionBanque;

/**
 * Controller for the money transfert function of the ATM TODO : Make it work !
 * Like other controllers..
 */
@Controller
public class TransfertControler {

	private InteractionBanque interactionBanque;

	@RequestMapping(value = "/transfert", method = RequestMethod.GET)
	public String index(Model model) {
		model.addAttribute("client", new Client());
		model.addAttribute("connected", false);
		return "transfert";
	}

	@RequestMapping(value = "/transfert", method = RequestMethod.POST)
	public String index(@ModelAttribute Client client, @ModelAttribute Boolean connected, Model model) {
		Boolean isConnected = interactionBanque.connecter(client);
		if (isConnected == false) {
			connected = false;
			model.addAttribute("error", "Erreur de connexion");
			return "index";
		}
		connected = true;
		model.addAttribute("isConnected", isConnected);
		return "transfert";
	}
}
