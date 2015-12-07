package ui.Command;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import ui.GestisciTask.ModificaDipendentiTask;
import ui.GestisciTask.ModificaInfoTask;

public class ModificaInfoTask_GestisciCommand extends AbstractAction{

	private static final long serialVersionUID = 1L;
	private ModificaInfoTask mif;
	
	public ModificaInfoTask_GestisciCommand(ModificaInfoTask minf){
		super("Gestisci");
		mif=minf;
	}	
		
	@Override
	public void actionPerformed(ActionEvent e) {
		JFrame f = new JFrame();
		f.setLayout(new BorderLayout());
		f.setMinimumSize(new Dimension(300,400));
		f.setVisible(true);
		new ModificaDipendentiTask(f, ModificaInfoTask.getNomeTask().getText(), ModificaInfoTask.getDescrizioneTask().getText(), ModificaInfoTask.getProgetto(), ModificaInfoTask.getSottoprogetto());
		mif.getFf().dispose();
	}

}
