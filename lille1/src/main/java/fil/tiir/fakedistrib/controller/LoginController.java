package fil.tiir.fakedistrib.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fil.tiir.fakedistrib.entity.Client;
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
		model.addAttribute(model);
		return "login";
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String login(Model model, HttpSession session, @RequestParam("usercard") String usercard,
			@RequestParam("password") String password) {

		String hashofpass = HashUtil.SHA1(password);

		Client client = new Client(usercard, hashofpass);
		boolean response = interactionBanque.connecter(client);

		// Connection failed
		if (response == false) {
			model.addAttribute("error", "Erreur de connexion");
			return "redirect:/login?error=wrongloginpass";
		}

		// Connection succeeded
		client.setConnected(true);
		session.setAttribute("token", client.getToken());
		model.addAttribute("reponse", response);

		return "login";
	}
}
