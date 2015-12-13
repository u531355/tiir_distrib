package fil.tiir.fakedistrib.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fil.tiir.fakedistrib.entity.Client;
import fil.tiir.fakedistrib.entity.Virement;
import fil.tiir.fakedistrib.exception.InteractionBanqueException;
import fil.tiir.fakedistrib.service.InteractionBanque;

/**
 * Controller for the money deposit function of the ATM
 */
@Controller
public class DepotControler {

	@Autowired
	private InteractionBanque interactionBanque;
	
	/** Processing of a GET request for a money deposit
	 */
	@RequestMapping(value = "/depot", method = RequestMethod.GET)
	public String login(Model model, HttpSession session) {
		Client client = (Client) session.getAttribute("client");
		if (client != null)
			return "redirect:/";
		return "depot";
	}
	
	/** Processing of a POST request for a money deposit
	 */
	@RequestMapping(value = "/depot", method = RequestMethod.POST)
	public String login(@ModelAttribute("virement") Virement virement, 
							Model model, 
							HttpSession session) {
					
		Client client = (Client) session.getAttribute("client");
		if (client == null)
			return "redirect:/";
		
		try {
			interactionBanque.depot(client, virement.getMontant());
		} catch (InteractionBanqueException e) {
		model.addAttribute("error", e.getMessage());
		}
		
		session.setAttribute("virement", virement);
		return "depot";
	}
}
