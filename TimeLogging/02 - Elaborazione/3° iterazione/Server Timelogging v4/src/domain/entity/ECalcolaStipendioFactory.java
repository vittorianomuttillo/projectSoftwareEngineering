package domain.entity;

public class ECalcolaStipendioFactory {
	
	public ECalcolaStipendioFactory()
	{
		
	}
	public ECalcoloStipendio factoryMethod(String tipo)
	{
		
		if(tipo.equals("EManager")){
			EStipendioManager stipendio = new EStipendioManager();
			return stipendio;
		} else if(tipo.equals("EConsulente")) {
			EStipendioConsulente stipendio = new EStipendioConsulente();
			return stipendio;
		} else if (tipo.equals("Fisso")) {
			EStipendioFisso stipendio = new EStipendioFisso();
			return stipendio;
		} else if (tipo.equals("Variabile")) {
			EStipendioVariabile stipendio = new EStipendioVariabile();
			return stipendio;
		} else if (tipo.equals("Bonus")){
			EStipendioBonus stipendio = new EStipendioBonus();
			return stipendio;
		}
		
		return null;
	}
}
