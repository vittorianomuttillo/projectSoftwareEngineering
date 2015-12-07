package ui.Command;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

import Handler.GestisciTaskHandlerPrx;
import Handler.ProxieFactory;
import ui.GestisciTask.ModificaInfoTask;
import ui.Home.Home;
import ui.Login.Login;

public class ModificaInfoTask_SalvaCommand extends AbstractAction{

	private ModificaInfoTask mif;
	
	public ModificaInfoTask_SalvaCommand(ModificaInfoTask minf){
		super("Salva");
		mif=minf;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	    GestisciTaskHandlerPrx handler = (GestisciTaskHandlerPrx) ProxieFactory.factoryMethod("GestisciTaskHandler", null, null, null);

	    handler.modificaTask(mif.getProgetto(), mif.getSottoprogetto(), mif.getDescrizioneTask().getText(), mif.getNomeTask().getText(), mif.getOld());
		Home.AggiornaGUI("Manager");
		mif.getFf().dispose();
	    
	}

}