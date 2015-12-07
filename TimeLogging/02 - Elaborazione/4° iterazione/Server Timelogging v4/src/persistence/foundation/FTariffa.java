package persistence.foundation;

import persistence.DAO.ETariffaDAO;
import domain.entity.ETariffa;

public class FTariffa {

	public void save(ETariffa t) {
		ETariffaDAO.save(t);
	}

	public void update(ETariffa t) {
		ETariffaDAO.save(t);
		//ETariffaDAO.refresh(t);
	}

	public void delete(ETariffa t) {
		ETariffaDAO.delete(t);
	}
	
	
	
}
