package domain.entity;

import java.util.ArrayList;
import java.util.Vector;

import persistence.foundation.XMLParser;
import domain.entity.ECalcoloStipendio;

public class EStipendioComposite implements ECalcoloStipendio {
	
	public Vector<ECalcoloStipendio> RegoleCalcoloStipendio = new Vector<ECalcoloStipendio>();

	public EStipendioComposite(String tipo){
		ArrayList<String> tipi = XMLParser.parseStip(tipo);
		ECalcolaStipendioFactory factory = new ECalcolaStipendioFactory();
		for (String t : tipi){
			this.add(factory.factoryMethod(t));
		}
	}

	public void add(ECalcoloStipendio aCalcolaStipendio) {
		RegoleCalcoloStipendio.add(aCalcolaStipendio);
	}

	public void remove(ECalcoloStipendio aCalcolaStipendio) {
		RegoleCalcoloStipendio.remove(aCalcolaStipendio);
	}

	@Override
	public EStipendio calcolaStipendio(EDipendente dipendente, long dataInizio,
			long dataFine) {
		return null;
	}
}