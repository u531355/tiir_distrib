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
import fil.tiir.fakedistrib.util.HashUtil;

/**
 * Controller for the money transfert function of the ATM TODO : Make it work !
 * Like other controllers..
 */
@Controller
public class LoginController {

	@Autowired
	private InteractionBanque interactionBanque;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String login(Model model, HttpSession session) {
		Client client = (Client) session.getAttribute("client");
		if (client != null)
			return "redirect:/choices";
		return "login";
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String login(@ModelAttribute("client") Client client, Model model, HttpSession session) {
		// Change le password en hash
		client.setHash(HashUtil.SHA1(client.getHash()));
		try {
			interactionBanque.connecter(client);
		} catch (InteractionBanqueException e) {
			model.addAttribute("error", e.getMessage());
			return "login";
		}
		session.setAttribute("client", client);
		return "redirect:/choices";
	}
}
