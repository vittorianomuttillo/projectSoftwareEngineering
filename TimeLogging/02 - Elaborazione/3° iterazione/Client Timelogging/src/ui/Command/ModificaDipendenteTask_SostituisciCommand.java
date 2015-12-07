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
import ui.GestisciTask.ModificaDipendentiTaskAggiungiDipendente;
import ui.GestisciTask.ModificaDipendentiTaskSostituisciDipendente;
import ui.GestisciTask.ModificaInfoTask;
import ui.Login.Login;

public class ModificaDipendenteTask_SostituisciCommand extends AbstractAction{

	private ModificaDipendentiTask mdt;	
	public ModificaDipendenteTask_SostituisciCommand(ModificaDipendentiTask md){
		super("Sostituisci");
		this.mdt=md;
	}
	
		
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		JFrame f = new JFrame();
		f.setLayout(new BorderLayout());
		f.setMinimumSize(new Dimension(300,300));
		f.setVisible(true);
		new ModificaDipendentiTaskSostituisciDipendente(f, mdt, "sostituisci", mdt.getId().get(mdt.getConsulente().getSelectedIndex()));
		mdt.getFf().dispose();
	}
}