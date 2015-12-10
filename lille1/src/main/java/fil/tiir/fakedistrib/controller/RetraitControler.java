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
import fil.tiir.fakedistrib.service.InteractionBanque;

/**
 * Controller for the money withdrawal function of the ATM TODO : Make it work !
 * Like other controllers..
 */
@Controller
public class RetraitControler {

	@Autowired
	private InteractionBanque interactionBanque;

	@RequestMapping(value = "/retrait", method = RequestMethod.GET)
	public String retrait(Model model, HttpSession session) {
		Client client = (Client) session.getAttribute("client");
		if (client == null)
			return "redirect:/";
		return "retrait";
	}

	@RequestMapping(value = "/retrait", method = RequestMethod.POST)
	public String retrait(@ModelAttribute("retrait") Retrait retrait, Model model, HttpSession session) {
		Client client = (Client) session.getAttribute("client");
		if (client == null)
			return "redirect:/";
		
		try {
			interactionBanque.retrait(client, retrait);;
		} catch (InteractionBanqueException e) {
			model.addAttribute("error", e.getMessage());
		}
		
		return "retrait";
	}
}
