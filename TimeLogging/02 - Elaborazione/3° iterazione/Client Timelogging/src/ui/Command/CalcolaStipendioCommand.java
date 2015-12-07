package ui.Command;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

import Handler.CalcolaStipendioHandlerPrx;
import Handler.GestisciTaskHandlerPrx;
import Handler.ProxieFactory;
import ui.CalcolaStipendio.CalcolaStipendio;

public class CalcolaStipendioCommand extends AbstractAction{

	private CalcolaStipendio cs;
	private String CodF;
	
	public CalcolaStipendioCommand(){		
		super("Calcola stipendio");
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		CalcolaStipendioHandlerPrx prx = (CalcolaStipendioHandlerPrx) ProxieFactory.factoryMethod("CalcolaStipendioHandler", null, null, null);
		
		Double ammontare = prx.CalcolaStipendio(this.CodF);		
		this.visualizza(ammontare);
	}
	
    public void visualizza(Double ammontare) {
    	JOptionPane.showMessageDialog(null, "Stipendio calcolato: "+ ammontare);
    }
	public void setCodF(String string) {
		// TODO Auto-generated method stub
		this.CodF=string;
	}


	
}
