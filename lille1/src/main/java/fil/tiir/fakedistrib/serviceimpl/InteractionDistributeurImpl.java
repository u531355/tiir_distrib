package fil.tiir.fakedistrib.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fil.tiir.fakedistrib.dao.DistributeurDao;
import fil.tiir.fakedistrib.entity.Distributeur;
import fil.tiir.fakedistrib.exception.InteractionDistributeurException;
import fil.tiir.fakedistrib.service.InteractionDistributeur;

/**
 * A implementation of the distributor service interface
 * 
 * @author blanquart
 *
 */
@Service
public class InteractionDistributeurImpl implements InteractionDistributeur {
	@Autowired
	private DistributeurDao d;

	@Override
	public void isEnoughCash(int montant) throws InteractionDistributeurException {
		// TODO Auto-generated method stub
		Distributeur dd = d.getAll().get(0);
		if (dd.getMontant() < montant)
			throw new InteractionDistributeurException("Pas assez d'argent dans le distributeur.");
	}

	@Override
	public void retireCash(int montant) {
		// TODO Auto-generated method stub
		Distributeur dd = d.getAll().get(0);
		dd.diminuerMontant(montant);
		d.update(dd);
	}

}
