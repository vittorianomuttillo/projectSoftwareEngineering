package ui.CreaTask;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import ui.home.Home;
import Handler.GestisciTaskHandlerPrx;
import Handler.ProxieFactory;

public class ModificaTask extends JDialog implements ActionListener {
	
	private static final long serialVersionUID = 1L;

	private static String SALVA = "Salva";
	private static String GESTISCI = "Gestisci";

    private JFrame ff;
	private static String progetto;
	private static String sottoprogetto;
	private static String old;
	private JLabel nomeT;
	private JTextField nomeTask;
	
	public JTextField getNomeTask() {
		return nomeTask;
	}

	public void setNomeTask(JTextField nomeTask) {
		this.nomeTask = nomeTask;
	}

	
	public JTextArea getDescrizioneTask() {
		return descrizioneTask;
	}

	public void setDescrizioneTask(JTextArea descrizioneTask) {
		this.descrizioneTask = descrizioneTask;
	}

	private JPanel textPane;
	private JButton save;
	private JButton gestisci;

	private JTextArea descrizioneTask;

	private JLabel descrizioneT;
    
    public ModificaTask(JFrame f){
    	super();
    	ff = f;
    	
    	nomeT = new JLabel("Nome Task: ");
    	nomeTask = new JTextField(10);
    	descrizioneT = new JLabel("Descrizione Task: ");
    	descrizioneTask = new JTextArea();
    	descrizioneTask.setEditable(true);

    	save = new JButton("Salva");
    	save.setActionCommand(SALVA);
    	save.addActionListener(this);
    	
    	gestisci = new JButton("Gestisci");
    	gestisci.setActionCommand(GESTISCI);
    	gestisci.addActionListener(this);
    	
    	textPane = new JPanel(new GridLayout(6,2, 10,10));
    	
    	textPane.add(nomeT);
    	textPane.add(nomeTask);
    	textPane.add(descrizioneT);
    	textPane.add(descrizioneTask);
    	textPane.add(save);
    	textPane.add(gestisci);
    	f.add(textPane, BorderLayout.NORTH);

    }
    
	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
	    GestisciTaskHandlerPrx handler = (GestisciTaskHandlerPrx) ProxieFactory.factoryMethod("GestisciTaskHandler", null, null, null);

		if (GESTISCI.equals(cmd)) {
			JFrame f = new JFrame();
			f.setLayout(new BorderLayout());
			f.setMinimumSize(new Dimension(300,400));
			f.setVisible(true);
			GestisciDipendenti g = new GestisciDipendenti(f, this.nomeTask.getText(), this.descrizioneTask.getText(), ModificaTask.progetto, ModificaTask.sottoprogetto);
			
		} else {
			//System.out.println(ModificaTask.progetto+"-"+ModificaTask.sottoprogetto+"-"+this.descrizioneTask.getText()+"-"+this.nomeTask.getText()+"-"+ModificaTask.old);
			handler.modificaTask(ModificaTask.progetto, ModificaTask.sottoprogetto, this.descrizioneTask.getText(), this.nomeTask.getText(), ModificaTask.old);
			Home.AggiornaGUI(true, "Manager");
		}
		
		this.ff.dispose();
		
		
	}

	public static String getProgetto() {
		return progetto;
	}

	public static void setProgetto(String progetto) {
		ModificaTask.progetto = progetto;
	}

	public static String getSottoprogetto() {
		return sottoprogetto;
	}

	public static void setSottoprogetto(String sottoprogetto) {
		ModificaTask.sottoprogetto = sottoprogetto;
	}

	public static String getOld() {
		return old;
	}

	public static void setOld(String old) {
		ModificaTask.old = old;
	}
	
}


