package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.Client;
import service.InteractionBanque;
import serviceimpl.InteractionBanqueImpl;

/**
 * Controller for the ATM functions
 * TODO : Make it work ! Like other controllers..
 */
@Controller
public class ATMController {

	@Autowired
	private InteractionBanque interactionbanque;
	
	//////////////////////
	// **** Index **** //
    /////////////////////
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String index(Model model) {
		model.addAttribute("client", new Client());
		return "index";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String index(@ModelAttribute("client") Client client, final BindingResult bindingResult, Model model) {

		// TODO : A changer, besoin d'intégrer un vrai système d'authentification,
		// genre : http://www.javaenthusiasm.com/spring-boot-security-with-thymeleaf/
		boolean response = interactionbanque.connecter(client);
		if (response == false) {
			model.addAttribute("error", "Erreur de connexion");
			return "index";
		}
		client.setConnected(true);
		model.addAttribute("reponse", response);
		return "index";
	}
	
	///////////////////////
	// **** Balance **** //
	///////////////////////
	@RequestMapping(value = "/balance", method = RequestMethod.GET)
	public String balance(@ModelAttribute("client") Client client, final BindingResult bindingResult, Model model) {
		model.addAttribute("accountbalance", interactionbanque.afficherSolde(client));
		
		return "balance";
	}
	
	///////////////////////
	// **** Choices **** //
	///////////////////////
	@RequestMapping(value = "/choices", method = RequestMethod.GET)
	public String index(Model model, @ModelAttribute Client client) {

		return "choices";
	}
		
	/////////////////////////
	// **** Transfert **** //
	/////////////////////////
	@RequestMapping(value = "/transfert", method = RequestMethod.POST)
	public String index(@ModelAttribute Client client, @ModelAttribute Boolean connected, Model model) {
		
		return "transfert";
	}
	
}
