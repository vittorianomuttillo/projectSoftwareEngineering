package domain.entity;

public class ECalcolaStipendioFactory {
	
	private ECalcoloStipendio stipendio;
	
	public ECalcolaStipendioFactory()
	{
		
	}
	public ECalcoloStipendio factoryMethod(String tipo)
	{
		
		if(tipo.equals("EManager")){
			this.stipendio = new EStipendioManager();
			return this.stipendio;
		} else if(tipo.equals("EConsulente")) {
			this.stipendio = new EStipendioConsulente();
			return this.stipendio;
		} else if (tipo.equals("Fisso")) {
			this.stipendio = new EStipendioFisso();
			return this.stipendio;
		} else if (tipo.equals("Variabile")) {
			this.stipendio = new EStipendioVariabile();
			return this.stipendio;
		} else if (tipo.equals("Bonus")){
			this.stipendio = new EStipendioBonus();
			return this.stipendio;
		}
		
		return null;
	}
}
