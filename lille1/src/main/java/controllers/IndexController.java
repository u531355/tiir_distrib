package controllers;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.Banque;
import model.Client;
import service.InteractionBanque;

@Controller
public class IndexController {
	 
	private InteractionBanque interactionBanque;
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String index(Model model) {
		model.addAttribute("client", new Client());
		model.addAttribute("connected", false);
		return "index";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String index(@ModelAttribute("client") Client client,final BindingResult bindingResult, @ModelAttribute Boolean connected, Model model) {
		boolean response = interactionBanque.connecter(client);
		if(response == false){
			connected = false;
			model.addAttribute("error","Erreur de connexion");
			return "index";
		}
		System.out.println("test");
		System.out.println(client.getToken());
		connected = true;
		model.addAttribute("reponse",response);
		return "index";
	}
}
