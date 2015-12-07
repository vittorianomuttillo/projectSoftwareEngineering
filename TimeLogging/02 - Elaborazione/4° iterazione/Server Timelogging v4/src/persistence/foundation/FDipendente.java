package persistence.foundation;

import domain.entity.EDipendente;
import persistence.DAO.EDipendenteDAO;

public class FDipendente {

	public EDipendente getDipendentebyID(int idDip){		
		return EDipendenteDAO.listEDipendenteByQuery("IdDipendente = " + idDip, null)[0];
	}

	public EDipendente getDipendentebyID(String username) {
		EDipendente[] dip = EDipendenteDAO.listEDipendenteByQuery("IdDipendente = " + username, null);
		if (dip.length != 0){
			return dip[0];
		}
		return null;
	}
	
	

}
