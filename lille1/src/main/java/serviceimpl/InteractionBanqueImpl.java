package serviceimpl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import dao.BanqueDAO;
import daoimpl.BanqueDaoImpl;
import model.Banque;
import model.Client;
import service.InteractionBanque;

@Service
@Scope("singleton")
public class InteractionBanqueImpl implements InteractionBanque {
	public static final int END_ID_BANQUE = 5;

	public boolean connecter(Client client) {
		BanqueDAO banquedao = new BanqueDaoImpl();
		Banque b = banquedao.findByIban(client.getNumeroCarte().substring(0, END_ID_BANQUE));
		return false;
	}

}
