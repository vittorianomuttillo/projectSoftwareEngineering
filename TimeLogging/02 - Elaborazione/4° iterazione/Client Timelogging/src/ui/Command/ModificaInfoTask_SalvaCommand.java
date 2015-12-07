package ui.Command;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import Handler.GestisciTaskHandlerPrx;
import Handler.ProxieFactory;
import ui.GestisciTask.ModificaInfoTask;
import ui.Home.Home;

public class ModificaInfoTask_SalvaCommand extends AbstractAction{

	private static final long serialVersionUID = 1L;
	private ModificaInfoTask mif;
	
	public ModificaInfoTask_SalvaCommand(ModificaInfoTask minf){
		super("Salva");
		mif=minf;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
	    GestisciTaskHandlerPrx handler = (GestisciTaskHandlerPrx) ProxieFactory.factoryMethod("GestisciTaskHandler", null, null, null);

	    handler.modificaTask(ModificaInfoTask.getProgetto(), ModificaInfoTask.getSottoprogetto(), ModificaInfoTask.getDescrizioneTask().getText(), ModificaInfoTask.getNomeTask().getText(), ModificaInfoTask.getOld());
		Home.AggiornaGUI("Manager");
		mif.getFf().dispose();
	    
	}

}