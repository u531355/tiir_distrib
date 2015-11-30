package serviceImpl;

import dao.BanqueDAO;
import daoimpl.BanqueDaoImpl;
import org.springframework.stereotype.Service;
import model.Banque;
import model.Client;

@Service
public class InteractionBanqueImpl implements service.InteractionBanque {
	public static final int END_ID_BANQUE = 5;
	public boolean connecter(Client client) {
		BanqueDAO banquedao = new BanqueDaoImpl();
		Banque b = banquedao.findByIban(client.getNumeroCarte().substring(0, END_ID_BANQUE));
		return false;
	}

}
