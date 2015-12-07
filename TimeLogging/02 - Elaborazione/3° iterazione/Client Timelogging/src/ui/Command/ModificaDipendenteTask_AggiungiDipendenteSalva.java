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
import ui.GestisciTask.CreaInfoTask;
import ui.GestisciTask.ModificaDipendentiTask;
import ui.GestisciTask.ModificaDipendentiTaskAggiungiDipendente;
import ui.GestisciTask.ModificaInfoTask;
import ui.Login.Login;

public class ModificaDipendenteTask_AggiungiDipendenteSalva extends AbstractAction{

	private ModificaDipendentiTaskAggiungiDipendente mdtad;
	public ModificaDipendenteTask_AggiungiDipendenteSalva( ModificaDipendentiTaskAggiungiDipendente modta ){
		super("Salva");
		this.mdtad=modta;
	}
		
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		GestisciTaskHandlerPrx prx = (GestisciTaskHandlerPrx) ProxieFactory.factoryMethod("GestisciTaskHandler", null, null, null);
		
		prx.aggiungiDipendente(CreaInfoTask.getProgetto(), CreaInfoTask.getSottoprogetto(), mdtad.getNomeTask(), mdtad.getId().get(mdtad.getConsulente().getSelectedIndex()), mdtad.getUnita().getText(), Double.parseDouble(mdtad.getQuantita().getText()));
		mdtad.getConsulente().addItem(mdtad.getNomi().get(mdtad.getConsulente().getSelectedIndex()));
		mdtad.getId().add(mdtad.getId().get(mdtad.getConsulente().getSelectedIndex()));
		
		mdtad.getFf().dispose();
		
	}
}