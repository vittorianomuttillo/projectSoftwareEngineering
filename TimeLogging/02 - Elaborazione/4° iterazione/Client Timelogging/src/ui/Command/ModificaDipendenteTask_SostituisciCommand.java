package ui.Command;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import ui.GestisciTask.ModificaDipendentiTask;
import ui.GestisciTask.ModificaDipendentiTaskSostituisciDipendente;

public class ModificaDipendenteTask_SostituisciCommand extends AbstractAction{

	private static final long serialVersionUID = 1L;
	private ModificaDipendentiTask mdt;	
	public ModificaDipendenteTask_SostituisciCommand(ModificaDipendentiTask md){
		super("Sostituisci");
		this.mdt=md;
	}
	
		
	@Override
	public void actionPerformed(ActionEvent e) {
		JFrame f = new JFrame();
		f.setLayout(new BorderLayout());
		f.setMinimumSize(new Dimension(300,300));
		f.setVisible(true);
		new ModificaDipendentiTaskSostituisciDipendente(f, mdt, "sostituisci", mdt.getId().get(mdt.getConsulente().getSelectedIndex()));
		mdt.getFf().dispose();
	}
}