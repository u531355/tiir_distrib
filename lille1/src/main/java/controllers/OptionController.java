package controllers;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.Banque;
import model.Client;
import service.InteractionBanque;

@Controller
public class OptionController {
	 
	private InteractionBanque interactionBanque;
	
	@RequestMapping(value="/virement",method=RequestMethod.GET)
	public String index(Model model, @ModelAttribute Client client) {
		model.addAttribute("virement", new Virement());
		return "virement";
	}
	@RequestMapping(value="/virement",method=RequestMethod.POST)
	public String index(@ModelAttribute Virement virement, Model model) {
		
		return "options";
	}
	
}
