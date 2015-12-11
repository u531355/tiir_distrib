package fil.tiir.fakedistrib.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fil.tiir.fakedistrib.entity.Client;
import fil.tiir.fakedistrib.exception.InteractionBanqueException;
import fil.tiir.fakedistrib.service.InteractionBanque;

/**
 * Controller for the money transfert function of the ATM
 */
@Controller
public class CreationController {

	@Autowired
	private InteractionBanque interactionBanque;
	/**
	 * if a get request has been given in the webpage /creation, returns the demand at the POST request
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/creation", method = RequestMethod.GET)
	public String creation(Model model, HttpSession session) {
		model.addAttribute("client", new Client());
		return "creation";
	}
	/**
	 * ask to create an account at the bank service, if the response is positive, redirect the webpage
	 * @param client
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/creation", method = RequestMethod.POST)
	public String login(@ModelAttribute("client") Client client, Model model, HttpSession session) {
		try {
			interactionBanque.creerCompte(client);
		} catch (InteractionBanqueException e) {
			model.addAttribute("error", e.getMessage());
			return "creation";
		}
		return "redirect:/";
	}
}
