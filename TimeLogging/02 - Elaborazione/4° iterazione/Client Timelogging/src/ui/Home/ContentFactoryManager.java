package ui.Home;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
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
import ui.Command.CreaTaskCommand;
import ui.Command.EliminaTaskCommand;
import ui.Command.ModificaTaskCommand;
import ui.GestisciTask.CreaInfoTask;


public class ContentFactoryManager implements ContentFactory, TreeSelectionListener {
	
	// attributi del TreePanel
	private JPanel treePanel;
	private JSplitPane splitPane;	
	// albero
	protected DefaultMutableTreeNode radice;
	private static DefaultTreeModel treeModel;
	private Toolkit toolkit = Toolkit.getDefaultToolkit();
	private static JTree tree;
	private JScrollPane treeView;
	
	// informazioni
	
	private JPanel InfoPane;	
	
    // attributi del Panel	
	private JPanel panel;	
	private static String ADD_COMMAND = "Crea Task";
    private static String REMOVE_COMMAND = "Modifica Task";
    private static String UPDATE_COMMAND = "Aggiorna Elenco Task";	
	private JButton addButton;
	private JButton updateButton;
	private JButton clearButton;	
	private HashMap<String, String> groupProgetti;
	
	// metodi getter e setter
	public HashMap<String, String> getGroupProgetti() {
		return groupProgetti;
	}

	public void setGroupProgetti(HashMap<String, String> groupProgetti) {
		this.groupProgetti = groupProgetti;
	}
	
	
	public DefaultTreeModel getTreeModel() {
		return treeModel;
	}

	public void setTreeModel(DefaultTreeModel treeModel) {
		this.treeModel = treeModel;
	}

	public JTree getTree() {
		return tree;
	}

	public void setTree(JTree tree) {
		this.tree = tree;
	}
	
	public JButton getAddButton() {
		return addButton;
	}
	
	public void setAddButton(JButton addButton) {
		this.addButton = addButton;
	}
	
	public JButton getUpdateButton() {
		return updateButton;
	}
	
	public void setUpdateButton(JButton updateButton) {
		this.updateButton = updateButton;
	}
	
	public JButton getClearButton() {
		return clearButton;
	}
	
	public void setClearButton(JButton clearButton) {
		this.clearButton = clearButton;
	}

	// implementa metodo createTreePanel() definito nell'AbstractFactory
	
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
		
		//Create the info panel.
		InfoPane = new JPanel();
		
		//Add the scroll panes to a split pane.
		splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		splitPane.setTopComponent(treeView);
		splitPane.setBottomComponent(InfoPane);
		
		Dimension minimumSize = new Dimension(500, 200);
		InfoPane.setMinimumSize(minimumSize);
		
		splitPane.setDividerLocation(200);  
		splitPane.setPreferredSize(new Dimension(350, 300));
		
		//Add the split pane to this panel.
		treePanel.add(splitPane);
		aggiornaTreePanel();
		return treePanel;
	}

	private void displayInfoPane(String info) {   // tabella da rivedere
				
		InfoPane.removeAll();
		String[] tmp = info.split(";");
		
		//Create the labels.
		JLabel nomeLabel=new JLabel("Nome Task : ");
		JLabel descrizioneLabel=new JLabel("Descrizione Task : ");
		
		//Create the text fields and set them up.
		JFormattedTextField  nameField = new JFormattedTextField();
		nameField.setValue(tmp[0]);
		nameField.setColumns(15);
		nameField.setEditable(false);
		//nameField.setForeground(Color.red);	
		
		JFormattedTextField  descrizioneField = new JFormattedTextField();
		descrizioneField.setValue(tmp[1]);
		descrizioneField.setColumns(15);
		descrizioneField.setEditable(false);
		
		//Tell accessibility tools about label/textfield pairs.
		nomeLabel.setLabelFor(nameField);
		descrizioneLabel.setLabelFor(descrizioneField);
		
		//Lay out the labels in a panel.
        JPanel labelPane = new JPanel(new GridLayout(0,1,2,2));
        labelPane.add(nomeLabel);
        labelPane.add(descrizioneLabel);
        
        //Layout the text fields in a panel.
        JPanel fieldPane = new JPanel(new GridLayout(0,1,2,2));
        fieldPane.add(nameField);
        fieldPane.add(descrizioneField);
        
        for (int i=2;i<tmp.length;i++){
        	JLabel nomeDipendenteLabel=new JLabel("Nome Dipendente : ");
        	JLabel idLabel=new JLabel("ID : ");
        	
        	JFormattedTextField  nameDipendenteField = new JFormattedTextField();
        	nameDipendenteField.setValue(tmp[i].split("-")[0]);
        	nameDipendenteField.setColumns(15);
        	nameDipendenteField.setEditable(false);
    		
    		JFormattedTextField  idField = new JFormattedTextField();
    		idField.setValue(tmp[i].split("-")[1]);
    		idField.setColumns(15);
    		idField.setEditable(false);
    		
    		nomeDipendenteLabel.setLabelFor(nameDipendenteField);
    		idLabel.setLabelFor(idField);

    		
    		labelPane.add(nomeDipendenteLabel);
            labelPane.add(idLabel);
            
            fieldPane.add(nameDipendenteField);
            fieldPane.add(idField);
		}
                
        //Put the panels in this panel, labels on left,
        //text fields on right.
        InfoPane.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        InfoPane.add(labelPane, BorderLayout.CENTER);
        InfoPane.add(fieldPane, BorderLayout.LINE_END);
		
		splitPane.setBottomComponent(InfoPane);
	}
	
	// metodi per gestire tree di swing
	
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
	    	this.updateButton.setEnabled(false);
	    	this.clearButton.setEnabled(false);
	    } else if (node.isLeaf()){
	    	this.getAddButton().setEnabled(false);
	    	this.updateButton.setEnabled(true);
	    	this.clearButton.setEnabled(true);
	    	CreaInfoTask.setSottoprogetto(node.getParent().toString());
	    	CreaInfoTask.setProgetto(this.getGroupProgetti().get(node.getParent().toString()));
	    	displayInfoPane((handler.getInfoTask(this.getGroupProgetti().get(node.getParent().toString()), node.getParent().toString(), node.getUserObject().toString())));
	    	//InfoPane.setText(handler.getInfoTask(this.getGroupProgetti().get(node.getParent().toString()), node.getParent().toString(), node.getUserObject().toString()));
	    } else {
	    	this.getAddButton().setEnabled(true);
	    	this.updateButton.setEnabled(false);
	    	this.clearButton.setEnabled(false);
	    	CreaInfoTask.setSottoprogetto((String)node.getUserObject());
	    	CreaInfoTask.setProgetto(this.getGroupProgetti().get((String)node.getUserObject()));
	    } 
	}

	// implementa metodo createPanel() definito in AbstractFactory 
	@Override
	public JPanel createPanel() {
		
		panel = new JPanel(new GridLayout(0,4));
		 
		addButton = new JButton(new CreaTaskCommand());
		//addButton.setActionCommand(ADD_COMMAND);
        addButton.setEnabled(false);
        
        
        updateButton = new JButton(new ModificaTaskCommand(this));
        updateButton.setEnabled(false);
        //updateButton.setActionCommand(UPDATE_COMMAND);

        
        clearButton = new JButton(new EliminaTaskCommand(this));
        clearButton.setEnabled(false);
        //clearButton.setActionCommand(REMOVE_COMMAND);
       
		
        panel.add(addButton);
        panel.add(updateButton); 
        panel.add(clearButton);
		
		return panel;
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
