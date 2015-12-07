package controller.handler;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import persistence.foundation.XMLParser;
import domain.entity.EAzienda;
import domain.entity.EDipendente;
import domain.entity.EDirezione;
import domain.entity.EMarketing;
import domain.entity.ETimeRecord;
import Ice.Current;


public class CalcolaStipendioHandler extends Handler._CalcolaStipendioHandlerDisp {

	@Override
	public String getDipendenti(Current __current) {
		String ret = "";
		EAzienda azienda = EAzienda.getInstance();
		EDirezione direzione = azienda.getDirezione();
		
		Iterator<EDipendente> iterator = direzione.getElenco_dipendenti().iterator();
	    while(iterator.hasNext()) {
	    	EDipendente c = iterator.next();
	    	ret += c.getCodiceFiscale()+"-"+c.getNomeDipendente()+";";
	    }
	    
		return ret;
	}

	@Override
	public double CalcolaStipendio(String codiceFiscale, Current __current) {
		EAzienda azienda = EAzienda.getInstance();
		System.out.println(azienda);
		EMarketing marketing = azienda.getMarketing();
		System.out.println(marketing);
		Set elencoDipendenti = azienda.getDirezione().getElenco_dipendenti();
		System.out.println(elencoDipendenti);
		Iterator<EDipendente> iterator = elencoDipendenti.iterator();
	    while(iterator.hasNext()) {
	    	EDipendente dip = iterator.next();
	    	System.out.println("dipendenti "+ dip.getCodiceFiscale()+"cod"+ codiceFiscale);
			if (dip.getCodiceFiscale().equals(codiceFiscale))
				return marketing.calcolaStipendio(dip);
		}
		return 999.999;	
	}

}