package ui.Command;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreePath;

import Handler.GestisciTaskHandlerPrx;
import Handler.ProxieFactory;
import ui.Home.ContentFactoryManager;
import ui.Home.Home;


public class EliminaTaskCommand extends AbstractAction{

	private static final long serialVersionUID = 1L;
	private ContentFactoryManager cfm;
		
	public EliminaTaskCommand(ContentFactoryManager cfman){
		super("Elimina Task");
		this.cfm=cfman;
	}
	
		
	public void removeCurrentNode() {
	    TreePath currentSelection = cfm.getTree().getSelectionPath();
	    if (currentSelection != null) {
	        DefaultMutableTreeNode currentNode = (DefaultMutableTreeNode)
	                     (currentSelection.getLastPathComponent());
	        MutableTreeNode parent = (MutableTreeNode)(currentNode.getParent());
	        if (parent != null) {
	            cfm.getTreeModel().removeNodeFromParent(currentNode);
	            return;
	        }
	    } 
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		DefaultMutableTreeNode node;
	    node = (DefaultMutableTreeNode) cfm.getTree().getLastSelectedPathComponent();
        GestisciTaskHandlerPrx handler = (GestisciTaskHandlerPrx) ProxieFactory.factoryMethod("GestisciTaskHandler", null, null, null);
		
		handler.cancellaTask(cfm.getGroupProgetti().get(node.getParent().toString()), node.getParent().toString(), (String) node.getUserObject());
        this.removeCurrentNode();
        Home.AggiornaGUI("Manager");
	}

}