package ui.CreaTask;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTree;
import javax.swing.ToolTipManager;
import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

import Handler.GestisciTaskHandlerPrx;
import Handler.ProxieFactory;
import ui.home.ContentFactory;
import ui.home.Home;
import ui.home.Menu;

public class ContentFactoryManager implements ContentFactory, TreeSelectionListener, ActionListener {

	// attributi del treepanel
	private JPanel treePanel;
	
	public JPanel getTreePanel() {
		return treePanel;
	}

	public void setTreePanel(JPanel treePanel) {
		this.treePanel = treePanel;
	}

	protected DefaultMutableTreeNode radice;
	protected DefaultTreeModel treeModel;
	private Toolkit toolkit = Toolkit.getDefaultToolkit();
	
	private JPanel InfoPane;
	private JTree tree;
	private JScrollPane treeView;
	private JSplitPane splitPane;
	
	
    // attributi del panel
	private static String ADD_COMMAND = "Crea Task";
    private static String REMOVE_COMMAND = "Modifica Task";
    private static String UPDATE_COMMAND = "Aggiorna Elenco Task";
	
	private JPanel panel;
	private JButton addButton;
	
	public JButton getAddButton() {
		return addButton;
	}

	public void setAddButton(JButton addButton) {
		this.addButton = addButton;
	}

	private JButton updateButton;
	private JButton clearButton;

	private HashMap<String, String> groupProgetti;

	// create treepanel a metodi 
	
	public HashMap<String, String> getGroupProgetti() {
		return groupProgetti;
	}

	public void setGroupProgetti(HashMap<String, String> groupProgetti) {
		this.groupProgetti = groupProgetti;
	}

	@Override
	public JPanel createTreePanel() {
		
		treePanel = new JPanel(new GridLayout(1,0));
	
		radice = new DefaultMutableTreeNode("Elenco sottoprogetti");
	    treeModel = new DefaultTreeModel(radice);
	    treeModel.addTreeModelListener(new MyTreeModelListener());
	    
	    tree = new JTree(treeModel);
	    tree.setEditable(false);
	    tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
	    tree.setShowsRootHandles(true);
	    
	    //Enable tool tips.
	    ToolTipManager.sharedInstance().registerComponent(tree);
	    
	    //Listen for when the selection changes.
	    tree.addTreeSelectionListener(this);
		
		//Create the scroll pane and add the tree to it. 
		treeView = new JScrollPane(tree);
		
		//Create the HTML viewing pane.
		InfoPane = new JPanel();
		//InfoPane.setEditable(false);
		
		//Add the scroll panes to a split pane.
		splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		splitPane.setTopComponent(treeView);
		splitPane.setBottomComponent(InfoPane);
		
		Dimension minimumSize = new Dimension(500, 200);
		InfoPane.setMinimumSize(minimumSize);
		
		//treeView.setMinimumSize(minimumSize);
		splitPane.setDividerLocation(200); 
		//ignored in some releases
		//of Swing. bug 4101306
		//workaround for bug 4101306:
		//treeView.setPreferredSize(new Dimension(100, 100)); 
		
		splitPane.setPreferredSize(new Dimension(350, 300));
		
		//Add the split pane to this panel.
		treePanel.add(splitPane);
		aggiornaTreePanel();
		return treePanel;
	}
		
	private void displayInfoPane(String info) {  
		InfoPane.removeAll();
		String[] tmp = info.split(";");
		InfoPane = new JPanel(new GridLayout(2 + (tmp.length -2)*2, 2, 5,5));
		InfoPane.add(new JLabel("Nome:"));
		InfoPane.add(new JLabel(tmp[0]));
		InfoPane.add(new JLabel("Descrizione:"));
		InfoPane.add(new JLabel(tmp[1]));
		for (int i=2;i<tmp.length;i++){
			InfoPane.add(new JLabel("Nome Dipendente:"));
			InfoPane.add(new JLabel(tmp[i].split("-")[0]));
			InfoPane.add(new JLabel("ID:"));
			InfoPane.add(new JLabel(tmp[i].split("-")[1]));
		}
		splitPane.setBottomComponent(InfoPane);
	}
	
	/** Remove all nodes except the root node. */
	public void clear() {
		radice.removeAllChildren();
	    treeModel.reload();
	}
	
	/** Remove the currently selected node. */
	public void removeCurrentNode() {
	    TreePath currentSelection = tree.getSelectionPath();
	    if (currentSelection != null) {
	        DefaultMutableTreeNode currentNode = (DefaultMutableTreeNode)
	                     (currentSelection.getLastPathComponent());
	        MutableTreeNode parent = (MutableTreeNode)(currentNode.getParent());
	        if (parent != null) {
	            treeModel.removeNodeFromParent(currentNode);
	            return;
	        }
	    } 
	
	    // Either there was no selection, or the root was selected.
	    toolkit.beep();
	}
	
	/** Add child to the currently selected node. */
	public DefaultMutableTreeNode addObject(Object child) {
	    DefaultMutableTreeNode parentNode = null;
	    TreePath parentPath = tree.getSelectionPath();
	
	    if (parentPath == null) {
	        parentNode = radice;
	    } else {
	        parentNode = (DefaultMutableTreeNode)
	                     (parentPath.getLastPathComponent());
	    }
	
	    return addObject(parentNode, child, true);
	}
	
	public DefaultMutableTreeNode addObject(DefaultMutableTreeNode parent, Object child) {
	    return addObject(parent, child, false);
	}
	
	public DefaultMutableTreeNode addObject(DefaultMutableTreeNode parent, Object child, boolean shouldBeVisible) {
	    DefaultMutableTreeNode childNode = new DefaultMutableTreeNode(child);	
	    if (parent == null) {
	        parent = radice;
	    }
	
	//It is key to invoke this on the TreeModel, and NOT DefaultMutableTreeNode
	    treeModel.insertNodeInto(childNode, parent, parent.getChildCount());
	
	    //Make sure the user can see the lovely new node.
	    if (shouldBeVisible) {
	        tree.scrollPathToVisible(new TreePath(childNode.getPath()));
	    }
	    return childNode;
	}
	
	class MyTreeModelListener implements TreeModelListener {
	    public void treeNodesChanged(TreeModelEvent e) {
	    }
	    public void treeNodesInserted(TreeModelEvent e) {
	    }
	    public void treeNodesRemoved(TreeModelEvent e) {
	    }
	    public void treeStructureChanged(TreeModelEvent e) {
	    }
	}

	public void valueChanged(TreeSelectionEvent arg0) {
		DefaultMutableTreeNode node;
	    node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
	    GestisciTaskHandlerPrx handler = (GestisciTaskHandlerPrx) ProxieFactory.factoryMethod("GestisciTaskHandler", null, null, null);
	    if (node == null){
	    	return;
	    }
	    if (node.isRoot()){
	    	this.getAddButton().setEnabled(false);
	    	Menu.getCreaTask().setEnabled(false);
	    	this.updateButton.setEnabled(false);
	    	this.clearButton.setEnabled(false);
	    } else if (node.isLeaf()){
	    	this.getAddButton().setEnabled(false);
	    	Menu.getCreaTask().setEnabled(false);
	    	this.updateButton.setEnabled(true);
	    	this.clearButton.setEnabled(true);
	    	CreaTask.setSottoprogetto(node.getParent().toString());
	    	CreaTask.setProgetto(this.getGroupProgetti().get(node.getParent().toString()));
	    	displayInfoPane((handler.getInfoTask(this.getGroupProgetti().get(node.getParent().toString()), node.getParent().toString(), node.getUserObject().toString())));
	    	//InfoPane.setText(handler.getInfoTask(this.getGroupProgetti().get(node.getParent().toString()), node.getParent().toString(), node.getUserObject().toString()));
	    } else {
	    	this.getAddButton().setEnabled(true);
	    	Menu.getCreaTask().setEnabled(true);
	    	this.updateButton.setEnabled(false);
	    	this.clearButton.setEnabled(false);
	    	CreaTask.setSottoprogetto((String)node.getUserObject());
	    	CreaTask.setProgetto(this.getGroupProgetti().get((String)node.getUserObject()));
	    } 
	}

	// create panel e metodi
	@Override
	public JPanel createPanel() {
		
		panel = new JPanel(new GridLayout(0,4));
		 
		addButton = new JButton("Crea Task");
		addButton.setActionCommand(ADD_COMMAND);
        addButton.setEnabled(false);
        addButton.addActionListener(this);
        
        updateButton = new JButton("Modifica Task");
        updateButton.setEnabled(false);
        updateButton.setActionCommand(UPDATE_COMMAND);
        updateButton.addActionListener(this);
        
        clearButton = new JButton("Elimina Task");
        clearButton.setEnabled(false);
        clearButton.setActionCommand(REMOVE_COMMAND);
        clearButton.addActionListener(this);
		
        panel.add(addButton);
        panel.add(updateButton); 
        panel.add(clearButton);
		
		return panel;
	}
	
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        DefaultMutableTreeNode node;
	    node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
        GestisciTaskHandlerPrx handler = (GestisciTaskHandlerPrx) ProxieFactory.factoryMethod("GestisciTaskHandler", null, null, null);
        
        if (ADD_COMMAND.equals(command)) {
            //Add button clicked
        	JFrame f = new JFrame();
			f.setLayout(new BorderLayout());
			f.setMinimumSize(new Dimension(300,300));
			f.setVisible(true);
			new CreaTask(f, "Salva");
        } else if (UPDATE_COMMAND.equals(command)) {
        	JFrame f = new JFrame();
			f.setLayout(new BorderLayout());
			f.setMinimumSize(new Dimension(300,300));
			f.setVisible(true);
			String infoTask = handler.getInfoTask(this.getGroupProgetti().get(node.getParent().toString()), node.getParent().toString(), (String) node.getUserObject());
			String[] task = infoTask.split(";");
			
			ModificaTask  gestisci = new ModificaTask(f);
			ModificaTask.setProgetto(this.getGroupProgetti().get(node.getParent().toString()));
			ModificaTask.setSottoprogetto(node.getParent().toString());
			gestisci.getNomeTask().setText(task[0]);
			gestisci.getDescrizioneTask().setText(task[1]);
			ModificaTask.setOld(task[0]);
        } else if (REMOVE_COMMAND.equals(command)) {
            handler.cancellaTask(this.getGroupProgetti().get(node.getParent().toString()), node.getParent().toString(), (String) node.getUserObject());
            this.removeCurrentNode();
            Home.AggiornaGUI(true, "Manager");
        }
    }
    
    public void aggiornaTreePanel(){
    	
    	GestisciTaskHandlerPrx handler = (GestisciTaskHandlerPrx) ProxieFactory.factoryMethod("GestisciTaskHandler", null, null, null);
    	String sottoprogetti = handler.getSottoprogetti(1);
    	if (sottoprogetti == ""){
    		System.out.println("stringa vuota");
    		return;
    	}
    	String[] groupSottoprogettitmp = sottoprogetti.split(";");
    	groupProgetti = new HashMap<String, String>();
    	ArrayList<String> groupSottoprogetti = new ArrayList<String>();
    	for (int i=0; i<groupSottoprogettitmp.length; i++){
    		String[] tmp = groupSottoprogettitmp[i].split("-");
    		groupProgetti.put(tmp[1], tmp[0]);
    		groupSottoprogetti.add(tmp[1]);
    	}
    	
    	ArrayList<String[]> groupTask = new ArrayList<String[]>();
    	for (int i=0; i<groupSottoprogetti.size(); i++){
    		String taskstmp = handler.getInfoSottoprogetto(groupProgetti.get(groupSottoprogetti.get(i)), groupSottoprogetti.get(i));
    		System.out.println(taskstmp);
    		String[] task = taskstmp.split(";");
    		groupTask.add(task);
    	}
    	    	
    	for (int i=0; i<groupSottoprogetti.size(); i++){
    		DefaultMutableTreeNode p1 = this.addObject(null, groupSottoprogetti.get(i));
    		for (int j=0; j<groupTask.get(i).length; j++){
    			System.out.println(groupTask.get(i)[j]);
    			addObject(p1, groupTask.get(i)[j]);
    		}
    	}
    }

   
}
