package ui.Command;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

import Handler.CalcolaStipendioHandlerPrx;
import Handler.ProxieFactory;

public class CalcolaStipendioCommand extends AbstractAction{

	private static final long serialVersionUID = 1L;
	private String CodF;
	
	public CalcolaStipendioCommand(){		
		super("Calcola stipendio");
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		CalcolaStipendioHandlerPrx prx = (CalcolaStipendioHandlerPrx) ProxieFactory.factoryMethod("CalcolaStipendioHandler", null, null, null);
		
		Double ammontare = prx.CalcolaStipendio(this.CodF);		
		this.visualizza(ammontare);
	}
	
    public void visualizza(Double ammontare) {
    	JOptionPane.showMessageDialog(null, "Stipendio calcolato: "+ ammontare);
    }
	public void setCodF(String string) {
		this.CodF=string;
	}


	
}
