package fil.tiir.fakedistrib.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fil.tiir.fakedistrib.service.InteractionBanque;

/**
 * Controller for the money transfert function of the ATM TODO : Make it work !
 * Like other controllers..
 */
@Controller
public class TransfertControler {

	@Autowired
	private InteractionBanque interactionBanque;

	@RequestMapping(value = "/transfert", method = RequestMethod.GET)
	public String transfert(Model model, HttpSession session) {
		model.addAttribute(model);
		return "transfert";
	}

	@RequestMapping(value = "/transfert", method = RequestMethod.POST)
	public String transfert(Model model, HttpSession session, @RequestParam("accountfrom") String accountfrom,
			@RequestParam("accountto") String accountto, @RequestParam("amount") String amount) {

		model.addAttribute(model);
		// TODO : handling the money transfert transfert
		return "transfert";

	}
}
