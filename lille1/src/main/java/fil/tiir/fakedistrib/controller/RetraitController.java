package fil.tiir.fakedistrib.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fil.tiir.fakedistrib.entity.Client;
import fil.tiir.fakedistrib.entity.Retrait;
import fil.tiir.fakedistrib.exception.InteractionBanqueException;
import fil.tiir.fakedistrib.exception.InteractionDistributeurException;
import fil.tiir.fakedistrib.service.InteractionBanque;
import fil.tiir.fakedistrib.service.InteractionDistributeur;

/**
 * Controller for the money withdrawal function of the ATM
 */
@Controller
public class RetraitController {

	@Autowired
	private InteractionBanque interactionBanque;
	@Autowired
	private InteractionDistributeur interactionDistributeur;

	@RequestMapping(value = "/retrait", method = RequestMethod.GET)
	public String retrait(Model model, HttpSession session) {
		Client client = (Client) session.getAttribute("client");
		if (client == null)
			return "redirect:/";
		model.addAttribute("retrait", new Retrait(client));
		return "retrait";
	}

	@RequestMapping(value = "/retrait", method = RequestMethod.POST)
	public String retrait(@ModelAttribute("retrait") Retrait retrait, Model model, HttpSession session) {
		Client client = (Client) session.getAttribute("client");
		if (client == null)
			return "redirect:/";
		try {
			interactionDistributeur.isEnoughCash(retrait.getMontant());
			interactionBanque.retrait(client, retrait);
			interactionDistributeur.retireCash(retrait.getMontant());
		} catch (InteractionBanqueException | InteractionDistributeurException e) {
			model.addAttribute("error", e.getMessage());
			return "retrait";
		}
		return "redirect:/choices";
	}
}
