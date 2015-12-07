package ui.Command;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.tree.DefaultMutableTreeNode;

import ui.GestisciTask.ModificaInfoTask;
import ui.Home.ContentFactoryManager;
import Handler.GestisciTaskHandlerPrx;
import Handler.ProxieFactory;

public class ModificaTaskCommand extends AbstractAction{
	
	private static final long serialVersionUID = 1L;
	private ContentFactoryManager cfm;

	public ModificaTaskCommand(ContentFactoryManager cfman){
		super("Modifica Task");
		this.cfm=cfman;
	}
	
		
	@Override
	public void actionPerformed(ActionEvent e) {
		
		DefaultMutableTreeNode node;
	    node = (DefaultMutableTreeNode) cfm.getTree().getLastSelectedPathComponent();
        GestisciTaskHandlerPrx handler = (GestisciTaskHandlerPrx) ProxieFactory.factoryMethod("GestisciTaskHandler", null, null, null);
		
		JFrame f = new JFrame();
		f.setLayout(new BorderLayout());
		f.setMinimumSize(new Dimension(300,300));
		f.setVisible(true);
		String infoTask = handler.getInfoTask(cfm.getGroupProgetti().get(node.getParent().toString()), node.getParent().toString(), (String) node.getUserObject());
		String[] task = infoTask.split(";");
		
		new ModificaInfoTask(f);
		ModificaInfoTask.setProgetto(cfm.getGroupProgetti().get(node.getParent().toString()));
		ModificaInfoTask.setSottoprogetto(node.getParent().toString());
		ModificaInfoTask.getNomeTask().setText(task[0]);
		ModificaInfoTask.getDescrizioneTask().setText(task[1]);
		ModificaInfoTask.setOld(task[0]);
	
	}

}