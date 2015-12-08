package controller;

import org.springframework.beans.factory.annotation.Autowired;
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

	@Autowired
	private InteractionBanque interactionbanque;

	@RequestMapping(value = "/transfert", method = RequestMethod.GET)
	public String transfert(Model model) {
		model.addAttribute("client", new Client());
		model.addAttribute("connected", false);
		return "transfert";
	}

	@RequestMapping(value = "/transfert", method = RequestMethod.POST)
	public String transfert(Model model, @ModelAttribute Client client) {
		return null;
		
	}
}
