package fil.tiir.fakedistrib.controller;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
		Client client = new Client();
		model.addAttribute("client",client); //A voir si vraiment nécessaire
		return "login";
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String login(@ModelAttribute("client") Client client, Model model) {
	
		client.setHash(HashUtil.SHA1(client.getHash())); //Change le password en un hash 
		try {
			interactionBanque.connecter(client);
		} catch (JSONException e) {
			model.addAttribute("error", "Erreure de communication avec le serveur");
			return "login";
		} catch (IOException e) {
			model.addAttribute("error", "Erreure de connexion avec le serveur");
			return "login";
		}
		if (client.isConnected()) 
			return "choices";
		//Client not connected
		model.addAttribute("error", "Vérifier vos identifiants");
		return "login";
	}
}
