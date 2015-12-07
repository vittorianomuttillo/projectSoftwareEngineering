package ui.Command;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import Handler.GestisciTaskHandlerPrx;
import Handler.ProxieFactory;
import ui.GestisciTask.CreaInfoTask;
import ui.GestisciTask.ModificaDipendentiTaskSostituisciDipendente;

public class ModificaDipendenteTask_SostituisciDipendenteSalvaCommand  extends AbstractAction{

	private static final long serialVersionUID = 1L;
	private ModificaDipendentiTaskSostituisciDipendente mdtad;
	
	public ModificaDipendenteTask_SostituisciDipendenteSalvaCommand( ModificaDipendentiTaskSostituisciDipendente modta ){
		super("Salva");
		this.mdtad=modta;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		GestisciTaskHandlerPrx prx = (GestisciTaskHandlerPrx) ProxieFactory.factoryMethod("GestisciTaskHandler", null, null, null);

		prx.sostituisciDipendente(CreaInfoTask.getProgetto(), CreaInfoTask.getSottoprogetto(), mdtad.getNomeTask(), mdtad.getId().get(mdtad.getConsulente().getSelectedIndex()), mdtad.getUnita().getText(), Double.parseDouble(mdtad.getQuantita().getText()),  mdtad.getOldId());
		mdtad.getFf().dispose();
	}
}
