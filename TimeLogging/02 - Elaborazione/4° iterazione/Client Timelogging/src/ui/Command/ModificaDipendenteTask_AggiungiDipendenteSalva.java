package ui.Command;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import Handler.GestisciTaskHandlerPrx;
import Handler.ProxieFactory;
import ui.GestisciTask.CreaInfoTask;
import ui.GestisciTask.ModificaDipendentiTaskAggiungiDipendente;

public class ModificaDipendenteTask_AggiungiDipendenteSalva extends AbstractAction{

	private static final long serialVersionUID = 1L;
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