package domain.entity;

import java.util.HashMap;

import persistence.foundation.XMLParser;

public class EStipendioFisso implements ECalcoloStipendio {

	public EStipendio calcolaStipendio(EDipendente dipendente, long dataInizio, long dataFine) {
		
		HashMap<String, String> mapLevel = XMLParser.parseLevel("livelli_salariali");
		
		String livello = dipendente.getLivello();
		int giorni = (int) ((dataFine - dataInizio)/86400000);
		EStipendio stipendio = new EStipendio("euro");
		int amm = Integer.parseInt(mapLevel.get(livello));
		stipendio.setAmmontare(amm*giorni);
		return stipendio;
	}

	
}