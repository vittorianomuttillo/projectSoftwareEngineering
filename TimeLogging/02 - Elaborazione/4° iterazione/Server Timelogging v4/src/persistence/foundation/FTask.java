package persistence.foundation;

import persistence.DAO.ETaskDAO;
import domain.entity.ETask;

public class FTask {
	
	
	public void save(ETask task) {
		ETaskDAO.save(task);
	}

	public void update(ETask t) {
		ETaskDAO.save(t);
		//ETaskDAO.refresh(t);
	}

	public void delete(ETask t) {
		ETaskDAO.delete(t);
	}
	
	
	
}
