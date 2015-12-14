package fil.tiir.fakedistrib.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import fil.tiir.fakedistrib.entity.Client;
import fil.tiir.fakedistrib.exception.InteractionBanqueException;
import fil.tiir.fakedistrib.service.InteractionBanque;

@Controller
public class LogoutController {

	@Autowired
	private InteractionBanque interactionBanque;

	@RequestMapping(value = "/logout")
	public String logout(Model model, HttpSession session) {

		Client client = (Client) session.getAttribute("client");
		if (client == null)
			return "redirect:/";
		try {

			interactionBanque.suppressionToken(client);
			session.removeAttribute("client");

		} catch (InteractionBanqueException e) {
			model.addAttribute("error", e.getMessage());
		}

		return "redirect:/";
	}
}
