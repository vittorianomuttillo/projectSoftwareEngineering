package ui.GestisciTask;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import ui.Command.ModificaInfoTask_GestisciCommand;
import ui.Command.ModificaInfoTask_SalvaCommand;

public class ModificaInfoTask extends JDialog{
	
	private static final long serialVersionUID = 1L;

	private static String SALVA = "Salva";
	private static String GESTISCI = "Gestisci";
    private JFrame ff;
	private static String progetto;
	private static String sottoprogetto;
	private static String old;
	private JLabel nomeT;
	private static JTextField nomeTask;
	private JPanel textPane;
	private JButton save;
	private JButton gestisci;
	private static JTextArea descrizioneTask;
	private JLabel descrizioneT;
	
	public JFrame getFf() {
		return ff;
	}

	public void setFf(JFrame ff) {
		this.ff = ff;
	}
	
	public static JTextField getNomeTask() {
		return nomeTask;
	}

	public void setNomeTask(JTextField nomeTask) {
		ModificaInfoTask.nomeTask = nomeTask;
	}
	
	public static JTextArea getDescrizioneTask() {
		return descrizioneTask;
	}

	public void setDescrizioneTask(JTextArea descrizioneTask) {
		ModificaInfoTask.descrizioneTask = descrizioneTask;
	}

    
    public ModificaInfoTask(JFrame f){
    	super();
    	ff = f;
    	ff.setLocationRelativeTo(null);
    	
    	nomeT = new JLabel("Nome Task: ");
    	nomeTask = new JTextField(10);
    	descrizioneT = new JLabel("Descrizione Task: ");
    	descrizioneTask = new JTextArea();
    	descrizioneTask.setEditable(true);

    	save = new JButton(new ModificaInfoTask_SalvaCommand(this));
    	save.setActionCommand(SALVA);
    	
    	gestisci = new JButton(new ModificaInfoTask_GestisciCommand(this));
    	gestisci.setActionCommand(GESTISCI);
    	
    	textPane = new JPanel(new GridLayout(6,2, 10,10));
    	
    	textPane.add(nomeT);
    	textPane.add(nomeTask);
    	textPane.add(descrizioneT);
    	textPane.add(descrizioneTask);
    	textPane.add(save);
    	textPane.add(gestisci);
    	f.add(textPane, BorderLayout.NORTH);

    }

	public static String getProgetto() {
		return progetto;
	}

	public static void setProgetto(String progetto) {
		ModificaInfoTask.progetto = progetto;
	}

	public static String getSottoprogetto() {
		return sottoprogetto;
	}

	public static void setSottoprogetto(String sottoprogetto) {
		ModificaInfoTask.sottoprogetto = sottoprogetto;
	}

	public static String getOld() {
		return old;
	}

	public static void setOld(String old) {
		ModificaInfoTask.old = old;
	}
	
}


