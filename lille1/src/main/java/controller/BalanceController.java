package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.Client;
import serviceimpl.InteractionBanqueImpl;

/**
 * Controller for the balance function of the ATM TODO : Make it work ! Like
 * other controllers..
 */
@Controller
public class BalanceController {

	@Autowired
	private InteractionBanqueImpl interactionbanque;

	/**
	 * 
	 */
	@RequestMapping(value = "/balance", method = RequestMethod.GET)
	public String balance(@ModelAttribute("client") Client client, final BindingResult bindingResult, Model model) {
		model.addAttribute("accountbalance", interactionbanque.afficherSolde(client));
		
		return "balance";
	}
}
