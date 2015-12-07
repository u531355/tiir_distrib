package controllers;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.Banque;
import model.Client;
import service.InteractionBanque;

/**
 * Controller for the "choices a user can make when logged in" function of the ATM
 * TODO
 */
@Controller
public class ChoicesController {
	 
	private InteractionBanque interactionBanque;
	
	@RequestMapping(value="/choices",method=RequestMethod.GET)
	public String index(Model model, @ModelAttribute Client client) {

		return "choices";
	}
	
	
}
