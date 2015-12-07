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
import ui.GestisciTask.ModificaDipendentiTask;
import ui.GestisciTask.ModificaInfoTask;
import ui.Login.Login;

public class ModificaInfoTask_GestisciCommand extends AbstractAction{

	private ModificaInfoTask mif;
	
	public ModificaInfoTask_GestisciCommand(ModificaInfoTask minf){
		super("Gestisci");
		mif=minf;
	}	
		
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	    GestisciTaskHandlerPrx handler = (GestisciTaskHandlerPrx) ProxieFactory.factoryMethod("GestisciTaskHandler", null, null, null);
			    
		JFrame f = new JFrame();
		f.setLayout(new BorderLayout());
		f.setMinimumSize(new Dimension(300,400));
		f.setVisible(true);
		ModificaDipendentiTask g = new ModificaDipendentiTask(f, mif.getNomeTask().getText(), mif.getDescrizioneTask().getText(), mif.getProgetto(), mif.getSottoprogetto());
		mif.getFf().dispose();
	}

}
