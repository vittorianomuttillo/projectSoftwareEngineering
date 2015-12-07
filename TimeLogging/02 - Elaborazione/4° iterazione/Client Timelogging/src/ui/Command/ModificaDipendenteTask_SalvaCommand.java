package ui.Command;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import ui.GestisciTask.ModificaDipendentiTask;
import ui.Home.Home;

public class ModificaDipendenteTask_SalvaCommand extends AbstractAction{

	private static final long serialVersionUID = 1L;
	private ModificaDipendentiTask mdt;	
	
	public ModificaDipendenteTask_SalvaCommand(ModificaDipendentiTask md){
		super("Salva");
		this.mdt=md;
	}
	
		
	@Override
	public void actionPerformed(ActionEvent e) {
		mdt.getFf().dispose();	
		Home.AggiornaGUI("Manager");
	}
}