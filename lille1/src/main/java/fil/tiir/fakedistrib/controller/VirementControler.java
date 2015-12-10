package fil.tiir.fakedistrib.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fil.tiir.fakedistrib.entity.Client;
import fil.tiir.fakedistrib.entity.Virement;
import fil.tiir.fakedistrib.exception.InteractionBanqueException;
import fil.tiir.fakedistrib.service.InteractionBanque;

/**
 * Controller for the money transfert function of the ATM TODO : Make it work !
 * Like other controllers..
 */
@Controller
public class VirementControler {

	@Autowired
	private InteractionBanque interactionBanque;

	@RequestMapping(value = "/virement", method = RequestMethod.GET)
	public String virement(Model model, HttpSession session) {
		Client client = (Client) session.getAttribute("client");
		if (client == null)
			return "redirect:/";
		return "virement";
	}

	@RequestMapping(value = "/virement", method = RequestMethod.POST)
	public String virement(@ModelAttribute("virement") Virement virement, 
							Model model, 
							HttpSession session,
							@RequestParam("accountfrom") String accountfrom,
							@RequestParam("accountto") String accountto, 
							@RequestParam("amount") String amount) {
								
		Client client = (Client) session.getAttribute("client");
		
		if (client == null)
			return "redirect:/";
		
		if(!client.isConnected()) {
			try {
				model.addAttribute("accountbalance", interactionBanque.afficherSolde(client));
				model.addAttribute("accountfrom", accountfrom);
				model.addAttribute("accountto", accountto);
			} catch (InteractionBanqueException e) {
				model.addAttribute("error", e.getMessage());
				
			}
		}
		
		return "virement";
	}
}
