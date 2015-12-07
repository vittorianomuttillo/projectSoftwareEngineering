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

public class ModificaDipendenteTask_EliminaCommand extends AbstractAction{

	private ModificaDipendentiTask mdt;
	public ModificaDipendenteTask_EliminaCommand( ModificaDipendentiTask md ){
		super("Elimina");
		this.mdt=md;
	}
	
		
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		GestisciTaskHandlerPrx prx = (GestisciTaskHandlerPrx) ProxieFactory.factoryMethod("GestisciTaskHandler", null, null, null);
		
		prx.eliminaDipendente(mdt.getNomeProgetto(),mdt.getNomeSottoprogetto(), mdt.getNomeTask(), mdt.getId().get(mdt.getConsulente().getSelectedIndex()));
		mdt.getConsulente().removeItemAt(mdt.getConsulente().getSelectedIndex());		
		mdt.getId().remove(mdt.getConsulente().getSelectedIndex());

	}
}