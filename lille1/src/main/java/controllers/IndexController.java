package controllers;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.Client;
import service.InteractionBanque;

@Controller
public class IndexController {
	 
	private InteractionBanque interactionBanque;
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String index(Model model) {
		model.addAttribute("client", new Client());
		return "index";
	}
	
	@RequestMapping(value="/",method=RequestMethod.POST)
	public String index(@ModelAttribute Client client, Model model) {
		
		return "index";
	}
}
