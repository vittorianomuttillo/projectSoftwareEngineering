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
import ui.Home.Home;
import ui.Login.Login;

public class ModificaDipendenteTask_SalvaCommand extends AbstractAction{

	private ModificaDipendentiTask mdt;	
	
	public ModificaDipendenteTask_SalvaCommand(ModificaDipendentiTask md){
		super("Salva");
		this.mdt=md;
	}
	
		
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		mdt.getFf().dispose();	
		Home.AggiornaGUI("Manager");
	}
}