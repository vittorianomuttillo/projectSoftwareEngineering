package persistence.foundation;

import domain.entity.EDipendente;
import persistence.DAO.EDipendenteDAO;

public class FDipendente {

	public EDipendente getDipendentebyID(int idDip){		
		return EDipendenteDAO.listEDipendenteByQuery("IdDipendente = " + idDip, null)[0];
	}
}
