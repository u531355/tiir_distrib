package fil.tiir.fakedistrib.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fil.tiir.fakedistrib.dao.RetraitDao;
import fil.tiir.fakedistrib.dao.VirementDao;
import fil.tiir.fakedistrib.entity.Client;
import fil.tiir.fakedistrib.entity.Virement;
import fil.tiir.fakedistrib.exception.InteractionBanqueException;
import fil.tiir.fakedistrib.service.InteractionBanque;

/**
 * Controller for the money transfer function of the ATM
 */
@Controller
public class VirementControler {
	
	@Autowired
	private VirementDao virementDao;
	@Autowired
	private InteractionBanque interactionBanque;
	//TODO commentaire
	@RequestMapping(value = "/virement", method = RequestMethod.GET)
	public String virement(Model model, HttpSession session) {
		Client client = (Client) session.getAttribute("client");
		if (client == null)
			return "redirect:/";
		model.addAttribute("virement", new Virement());
		return "virement";
	}
	//TODO commentaire
	@RequestMapping(value = "/virement", method = RequestMethod.POST)
	public String virement(@ModelAttribute("virement") Virement virement, 
							Model model, 
							HttpSession session) {
		
		Client client = (Client) session.getAttribute("client");
		
		if (client == null)
			return "redirect:/";
		virement.setBanque(client.getBank());
		virement.setIbanFrom(client.getIdAccount());
		virement.setDate(new Date());
		
		try {
			if(interactionBanque.virement(client, virement)){
				virementDao.insert(virement);
			}
		} catch (InteractionBanqueException e) {
			model.addAttribute("error", e.getMessage());
		}
		
		return "choices";
	}
}
