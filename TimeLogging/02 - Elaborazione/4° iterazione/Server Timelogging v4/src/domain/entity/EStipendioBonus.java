package domain.entity;

import java.sql.Date;
import java.util.GregorianCalendar;

public class EStipendioBonus implements ECalcoloStipendio {

	public EStipendio calcolaStipendio(double aBonus) {
		EStipendio stipendio = new EStipendio("euro");
		stipendio.setAmmontare(aBonus);
		return stipendio;
	}

	@Override
	public EStipendio calcolaStipendio(EDipendente dipendente, long dataInizio,
			long dataFine) {
		// TODO Auto-generated method stub
		return null;
	}

}