package fil.tiir.fakedistrib.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fil.tiir.fakedistrib.dao.DistributeurDao;
import fil.tiir.fakedistrib.entity.Client;
import fil.tiir.fakedistrib.entity.Virement;
import fil.tiir.fakedistrib.exception.InteractionBanqueException;
import fil.tiir.fakedistrib.service.InteractionBanque;

/**
 * Controller for the money deposit function of the ATM
 */
@Controller
public class DepotController {

	@Autowired
	private InteractionBanque interactionBanque;
	
	@Autowired
	private DistributeurDao distributeurDao;
	/** Processing of a GET request for a money deposit
	 */
	@RequestMapping(value = "/depot", method = RequestMethod.GET)
	public String depot(Model model, HttpSession session) {
		Client client = (Client) session.getAttribute("client");
		if (client == null)
			return "redirect:/";
		return "depot";
	}
	
	/** Processing of a POST request for a money deposit
	 */
	@RequestMapping(value = "/depot", method = RequestMethod.POST)
	public String depot(@RequestParam("montant") int amount, 
							Model model, 
							HttpSession session) {
		Client client = (Client) session.getAttribute("client");
		if (client == null)
			return "redirect:/";
		
		//TODO : Distrib d = distribDao.getFirst() => On en stock qu'un anyway
		// d.montant = d.montant+depot.montant
		// distribdao.update(d)
		// ++ Dans tous les controller on set une erreur mais je pense qu'on l'affiche pas sur toutes les pages, check dans 
		// Depot controller + depot.html, j'ia bien geré les erreues ( enfin vite fait)
		// + Pour logout => check comment le sendRequest prend un string, regarde bien ce que j'ai fait dans les autres controller pour 
		// que le json.toString() corresponde à ce que la banque attend, j'enlève les [ ], faut surotut pas oublié de le faire, 
		//Notre lib les rajoute je sais pas pourquoi .
		try {
			interactionBanque.depot(client, amount);
		} catch (InteractionBanqueException e) {
			model.addAttribute("error", e.getMessage());
		}
		
		return "choices";
	}
}
