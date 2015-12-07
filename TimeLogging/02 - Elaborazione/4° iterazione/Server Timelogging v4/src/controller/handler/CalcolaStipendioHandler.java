package controller.handler;

import java.util.Iterator;
import java.util.Set;

import domain.entity.EAzienda;
import domain.entity.EDipendente;
import domain.entity.EDirezione;
import domain.entity.EMarketing;
import Ice.Current;


public class CalcolaStipendioHandler extends Handler._CalcolaStipendioHandlerDisp {

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
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

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public double CalcolaStipendio(String codiceFiscale, Current __current) {
		EAzienda azienda = EAzienda.getInstance();
		EMarketing marketing = azienda.getMarketing();
		Set elencoDipendenti = azienda.getDirezione().getElenco_dipendenti();
		Iterator<EDipendente> iterator = elencoDipendenti.iterator();
	    while(iterator.hasNext()) {
	    	EDipendente dip = iterator.next();
			if (dip.getCodiceFiscale().equals(codiceFiscale))
				return marketing.calcolaStipendio(dip);
		}
		return 999.999;	
	}

}