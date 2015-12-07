package controller.handler;

import domain.entity.EAzienda;
import domain.entity.EDipendente;
import persistence.foundation.FAzienda;
import persistence.foundation.FDipendente;
import Ice.Current;

public class LoginHandler extends Handler._LoginHandlerDisp{

	private static final long serialVersionUID = 1L;

	@Override
	public String authenticate(String username, String password,
			Current __current) {
		
		FAzienda faz=new FAzienda();
		EAzienda eaz=faz.getAzienda();
		
			if(eaz.getNomeAzienda().equals(username) && eaz.getPassword().equals(password)){
				return "Azienda";
			}else{
				FDipendente fdip=new FDipendente();
				EDipendente edip = fdip.getDipendentebyID(username);
				
					if(edip != null && edip.getPassword().equals(password)){
						return edip.getTipo();
					}else{
						return "Errore";			
					}
			}

		
	}

}
