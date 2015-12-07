package persistence.foundation;

import persistence.DAO.ETimeRecordDAO;
import domain.entity.ETimeRecord;

public class FTimerecord {

	public void save(ETimeRecord t) {
		ETimeRecordDAO.save(t);
	}
	
}
