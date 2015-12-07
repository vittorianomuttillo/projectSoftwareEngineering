package ui.Command;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JFrame;

import ui.GestisciTask.ModificaDipendentiTask;
import ui.GestisciTask.ModificaDipendentiTaskAggiungiDipendente;

public class ModificaDipendenteTask_AggiungiCommand extends AbstractAction{

	private static final long serialVersionUID = 1L;
	private ModificaDipendentiTask mdt;
	
	public ModificaDipendenteTask_AggiungiCommand(ModificaDipendentiTask md){
		super("Aggiungi");
		this.mdt=md;
	}
	
		
	@Override
	public void actionPerformed(ActionEvent e) {
		JFrame f = new JFrame();
		f.setLayout(new BorderLayout());
		f.setMinimumSize(new Dimension(300,300));
		f.setVisible(true);
		new ModificaDipendentiTaskAggiungiDipendente(f, mdt , "aggiungi", 0);
		mdt.getFf().dispose();
	}
}