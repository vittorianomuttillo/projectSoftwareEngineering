package ui.Command;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import Handler.GestisciTaskHandlerPrx;
import Handler.ProxieFactory;
import ui.GestisciTask.ModificaDipendentiTask;

public class ModificaDipendenteTask_EliminaCommand extends AbstractAction{

	private static final long serialVersionUID = 1L;
	private ModificaDipendentiTask mdt;
	public ModificaDipendenteTask_EliminaCommand( ModificaDipendentiTask md ){
		super("Elimina");
		this.mdt=md;
	}
	
		
	@Override
	public void actionPerformed(ActionEvent e) {
		
		GestisciTaskHandlerPrx prx = (GestisciTaskHandlerPrx) ProxieFactory.factoryMethod("GestisciTaskHandler", null, null, null);
		
		prx.eliminaDipendente(mdt.getNomeProgetto(),mdt.getNomeSottoprogetto(), mdt.getNomeTask(), mdt.getId().get(mdt.getConsulente().getSelectedIndex()));
		mdt.getConsulente().removeItemAt(mdt.getConsulente().getSelectedIndex());		
		mdt.getId().remove(mdt.getConsulente().getSelectedIndex());

	}
}