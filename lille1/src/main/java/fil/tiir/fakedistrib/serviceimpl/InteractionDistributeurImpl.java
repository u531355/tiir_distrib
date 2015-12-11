package fil.tiir.fakedistrib.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;

import fil.tiir.fakedistrib.dao.DistributeurDao;
import fil.tiir.fakedistrib.entity.Distributeur;
import fil.tiir.fakedistrib.service.InteractionDistributeur;
/**
 * A implementation of the distributor service interface
 * @author blanquart
 *
 */
public class InteractionDistributeurImpl implements InteractionDistributeur {
	@Autowired
	private DistributeurDao d;
	@Override
	public boolean isEnoughCash(int montant) {
		// TODO Auto-generated method stub
		Distributeur dd = d.getAll().get(0);
		return dd.getMontant() > montant;
	}

	@Override
	public void retireCash(int montant) {
		// TODO Auto-generated method stub
		Distributeur dd = d.getAll().get(0);
		dd.diminuerMontant(montant);
		d.update(dd);
	}

}
