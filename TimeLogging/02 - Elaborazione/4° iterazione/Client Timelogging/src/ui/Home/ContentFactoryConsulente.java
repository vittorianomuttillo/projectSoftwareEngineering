package ui.Home;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JSplitPane;
import javax.swing.JTree;
import javax.swing.ToolTipManager;
import javax.swing.event.TreeModelListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;



import Handler.GestisciTaskHandlerPrx;
import Handler.InserisciTimerecordHandlerPrx;
import Handler.ProxieFactory;
import ui.Command.CreaTaskCommand;
import ui.Command.EliminaTaskCommand;
import ui.Command.ModificaTaskCommand;
import ui.GestisciTask.CreaInfoTask;
import ui.GestisciTask.CreaTaskAggiungiDipendenti;
import ui.Home.ContentFactoryManager.MyTreeModelListener;
import ui.InserisciTimeRecord.InserisciTimeRecord;

public class ContentFactoryConsulente implements ContentFactory, TreeSelectionListener, ActionListener {

	// attributi del TreePanel
	private JPanel treePanel;
	private JSplitPane splitPane;	
	// albero	
	protected DefaultMutableTreeNode radice;
	private static DefaultTreeModel treeModel;
	private Toolkit toolkit = Toolkit.getDefaultToolkit();
	private static JTree tree;
	private static String nomeTask;
	private JScrollPane treeView;
	private static HashMap<String, String> chiave = new HashMap<String, String>();

	// informazioni	
	private JPanel InfoPane;	
	
    // attributi del Panel	
	private JPanel panel;	
	private JButton addButton;
	private JButton stopButton;
	private JButton pauseButton;
	private JButton playButton;
	
	private static GregorianCalendar dataInizio;
	private GregorianCalendar dataI;	
	private GregorianCalendar dataF;
	private static GregorianCalendar dataFine;
	private static long milli = 0;
	private static int cont = 0;

	// getter e setter
	
	public static HashMap<String, String> getChiave() {
		return chiave;
	}

	public static void setChiave(HashMap<String, String> chiave) {
		ContentFactoryConsulente.chiave = chiave;
	}

	public JButton getStopButton() {
		return stopButton;
	}

	public void setStopButton(JButton stopButton) {
		this.stopButton = stopButton;
	}

	public JButton getPauseButton() {
		return pauseButton;
	}

	public void setPauseButton(JButton pauseButton) {
		this.pauseButton = pauseButton;
	}

	public JButton getPlayButton() {
		return playButton;
	}

	public void setPlayButton(JButton playButton) {
		this.playButton = playButton;
	}

	@Override
	public JPanel createTreePanel() {
		// TODO Auto-generated method stub
		treePanel = new JPanel(new GridLayout(1,0));
		
		radice = new DefaultMutableTreeNode("Elenco task");
	    treeModel = new DefaultTreeModel(radice);
	    //treeModel.addTreeModelListener(new MyTreeModelListener());
	    
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

	@Override
	public JPanel createPanel() {
		panel = new JPanel(new GridLayout(0,4));
		 
		/*addButton = new JButton("Inserisci time record");
        addButton.setEnabled(false);
              	
        panel.add(addButton);*/
		
		return panel;
	}
	
	//InfoPane.removeAll();
	//splitPane.setBottomComponent(InfoPane);

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


	
	 public void aggiornaTreePanel(){
	    	
		 InserisciTimerecordHandlerPrx handler = (InserisciTimerecordHandlerPrx) ProxieFactory.factoryMethod("InserisciTimerecordHandler", null, null, null);
		 String task = handler.getElencoTask(Integer.parseInt(Home.getId()));
		 //String task = "P-s-task1;p2-s2-Task2;p2-s2-Task31";
	
		 if (task == ""){
			 System.out.println("stringa vuota");
			 return;
		 }
		 
		 HashMap<String, String> chiave2 = new HashMap<>();
		 
    	String[] groupTask = task.split(";");	    	
    	//ArrayList<String> groupSottoprogetti = new ArrayList<String>();
    	for (String t: groupTask){
    		String[] temp = t.split("-");
    		DefaultMutableTreeNode p1 = this.addObject(null, temp[2], false);	    		
			//addObject(p1, "Id Task: " + temp[3], false);
    		chiave2.put(temp[2], temp[0] + "-" + temp[1] + "-" + temp[3]); 	    			    		
    	}
    	this.setChiave(chiave2);
	    	
	 }
	 
		public void valueChanged(TreeSelectionEvent arg0) {
			DefaultMutableTreeNode node;
		    node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
		  //  GestisciTaskHandlerPrx handler = (GestisciTaskHandlerPrx) ProxieFactory.factoryMethod("GestisciTaskHandler", null, null, null);
		    if (node == null){
		    	return;
		    }
		    if (node.isRoot()){
		    	
		    } else if (node.isLeaf()){
		    	this.nomeTask = node.getUserObject().toString();
		    	displayInfoPane(node.getUserObject().toString());
		    	//InfoPane.setText(handler.getInfoTask(this.getGroupProgetti().get(node.getParent().toString()), node.getParent().toString(), node.getUserObject().toString()));
		    } else {
		    	
		    } 
		}

		private void displayInfoPane(String nomeTask) {

			InfoPane.removeAll();
		    JLabel timeLabel = new JLabel("Tempo:");
		    JLabel time = new JLabel("hh:mm:ss");
			JPanel comandi = new JPanel(new GridLayout(2, 3));
		    		   
		    ImageIcon stop = createImageIcon("../images/stop.png");
		    stopButton = new JButton();
		    stopButton.setIcon(stop);
		    stopButton.setActionCommand("stop");
		    stopButton.setDisabledIcon(stop);
		    stopButton.setEnabled(false);
		    stopButton.addActionListener(this);		    
		   // stopButton.setToolTipText("Stop");
		    
		    ImageIcon pause = createImageIcon("../images/pause.png");
		    pauseButton = new JButton();
		    pauseButton.setIcon(pause);
		    pauseButton.setActionCommand("pause");
		    pauseButton.setDisabledIcon(pause);
		    pauseButton.setEnabled(false);
		    pauseButton.addActionListener(this);
		    
		   // pauseButton.setToolTipText("Play/pause");
		    
		    ImageIcon play = createImageIcon("../images/play.png");
		    playButton = new JButton();
		    playButton.setIcon(play);
		    playButton.setActionCommand("play");
		    playButton.addActionListener(this);
		   // playButton.setToolTipText("Play");
		    
		    comandi.add(playButton);
		    comandi.add(pauseButton);
		    comandi.add(stopButton);
		    comandi.add(timeLabel);
		    comandi.add(time);
		    
		    InfoPane.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
	        InfoPane.add(comandi, BorderLayout.CENTER);
			
			splitPane.setBottomComponent(InfoPane);
		}
		
		protected static ImageIcon createImageIcon(String path) {
	        java.net.URL imgURL = Splash.class.getResource(path);
	        if (imgURL != null) {
	            return new ImageIcon(imgURL);
	        } else {
	            System.err.println("Couldn't find file: " + path);
	            return null;
	        }
	    }

		@Override
		public void actionPerformed(ActionEvent e) {
			
			String command = e.getActionCommand();
			
			if(command.equals("play")){
				if(cont == 0){
					dataInizio = new GregorianCalendar();
					dataI = new GregorianCalendar();
				}else{
					GregorianCalendar data = new GregorianCalendar();
					dataI = data;
				}
				this.getPlayButton().setEnabled(false);
				this.getPauseButton().setEnabled(true);
				this.getStopButton().setEnabled(true);
			}else if(command.equals("stop")){
				
				dataFine = new GregorianCalendar();
				dataF = new GregorianCalendar();
				milli += dataFine.getTimeInMillis() - dataI.getTimeInMillis();
				//System.out.println(dataInizio.getTimeInMillis());
				//System.out.println(dataFine.getTimeInMillis());
				//System.out.println(dataI.getTimeInMillis());
				//System.out.println(dataF.getTimeInMillis());
				//System.out.println(milli);
				cont = 0;
				JFrame f = new JFrame();
				f.setLayout(new BorderLayout());
				f.setMinimumSize(new Dimension(300,300));
				f.setVisible(true);
				InserisciTimeRecord x = new InserisciTimeRecord(f, dataI, dataF, milli, this.getChiave().get(this.nomeTask), this.nomeTask);
			}else if(command.equals("pause")){
			
				GregorianCalendar dataff = new GregorianCalendar();
				dataF = dataff;
				milli += dataF.getTimeInMillis() - dataI.getTimeInMillis();
				cont = 1;
				this.getPlayButton().setEnabled(true);
				this.getPauseButton().setEnabled(false);
				this.getStopButton().setEnabled(true);
			}
		}
}
