package serviceImpl;

import dao.BanqueDAO;
import daoimpl.BanqueDaoImpl;
import model.Banque;
import model.Client;


public class InteractionBanqueImpl implements service.InteractionBanque {
	public static final int END_ID_BANQUE = 5;
	public boolean connecter(Client client) {
		BanqueDAO banquedao = new BanqueDaoImpl();
		Banque b = banquedao.findByIban(client.getIban().substring(0, END_ID_BANQUE));
		return false;
	}

}
