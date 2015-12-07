package ui.Command;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JFrame;

import ui.GestisciTask.CreaInfoTask;
import ui.GestisciTask.CreaTaskAggiungiDipendenti;

public class CreaInfoTaskCommand extends AbstractAction{
	
	private static final long serialVersionUID = 1L;
	private CreaInfoTask cit;
	public CreaInfoTaskCommand(CreaInfoTask ct){
		super("Avanti");
		cit=ct;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//Add button clicked
    	
		JFrame f = new JFrame();
		f.setLayout(new BorderLayout());
		f.setMinimumSize(new Dimension(300,400));
		f.setVisible(true);
		new CreaTaskAggiungiDipendenti(f, CreaInfoTask.getDescrizioneTask().getText(), cit.getNomeTask().getText());
		cit.getFf().dispose();
	}
}
