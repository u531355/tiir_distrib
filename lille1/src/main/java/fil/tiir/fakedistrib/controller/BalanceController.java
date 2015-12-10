package fil.tiir.fakedistrib.controller;

import java.io.IOException;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fil.tiir.fakedistrib.entity.Client;
import fil.tiir.fakedistrib.service.InteractionBanque;

/**
 * Controller for the balance function of the ATM TODO : Make it work ! Like
 * other controllers..
 */
@Controller
public class BalanceController {

	@Autowired
	private InteractionBanque interactionBanque;

	/**
	 * Est sensé fonctionner de base (tant que afficherSolde marche)
	 */
	@RequestMapping(value = "/balance", method = RequestMethod.GET)
	public String balance(@ModelAttribute("client") Client client, final BindingResult bindingResult, Model model) {
		try {
			model.addAttribute("accountbalance", interactionBanque.afficherSolde(client));
		} catch (JSONException e) {
			model.addAttribute("error", "Erreur de communication avec le serveur");
			return "error";
		} catch (IOException e) {
			model.addAttribute("error", "Erreur de connection avec le serveur");
			return "error";
		}
		return "balance";
	}
}
