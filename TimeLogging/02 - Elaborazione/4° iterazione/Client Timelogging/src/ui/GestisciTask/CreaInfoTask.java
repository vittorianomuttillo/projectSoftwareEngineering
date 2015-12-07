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

import ui.Command.CreaInfoTaskCommand;

public class CreaInfoTask extends JDialog{
	
	private static final long serialVersionUID = 1L;

	private static String AVANTI = "Avanti";

    private JFrame ff;
	private static String progetto;
	private static String sottoprogetto;
	private static String old;
	private JLabel nomeT;
	private JTextField nomeTask;
	private JPanel textPane;
	private JButton save;
	private static JTextArea descrizioneTask;
	private JLabel descrizioneT;
	
	public JTextField getNomeTask() {
		return nomeTask;
	}

	public void setNomeTask(JTextField nomeTask) {
		this.nomeTask = nomeTask;
	}
	
	public static JTextArea getDescrizioneTask() {
		return CreaInfoTask.descrizioneTask;
	}

	public void setDescrizioneTask(JTextArea descrizioneTask) {
		CreaInfoTask.descrizioneTask = descrizioneTask;
	}
    
	public JFrame getFf() {
		return ff;
	}

	public void setFf(JFrame ff) {
		this.ff = ff;
	}
	
    public CreaInfoTask(JFrame f, String tipo){
    	
    	super();
    	ff = f;
    	ff.setLocationRelativeTo(null);
    	
    	nomeT = new JLabel("Nome Task: ");
    	nomeTask = new JTextField(10);
    	descrizioneT = new JLabel("Descrizione Task: ");
    	descrizioneTask = new JTextArea(3,8);
    	descrizioneTask.setEditable(true);

    	save = new JButton(new CreaInfoTaskCommand(this));
    	save.setActionCommand(AVANTI);
    	
    	textPane = new JPanel(new GridLayout(6,2));
    	
    	textPane.add(nomeT);
    	textPane.add(nomeTask);
    	textPane.add(descrizioneT);
    	textPane.add(descrizioneTask);
    	textPane.add(save);
    	
    	f.add(textPane, BorderLayout.NORTH);

    }
    
	
	public static String getProgetto() {
		return progetto;
	}

	public static void setProgetto(String progetto) {
		CreaInfoTask.progetto = progetto;
	}

	public static String getSottoprogetto() {
		return sottoprogetto;
	}

	public static void setSottoprogetto(String sottoprogetto) {
		CreaInfoTask.sottoprogetto = sottoprogetto;
	}

	public static String getOld() {
		return old;
	}

	public static void setOld(String old) {
		CreaInfoTask.old = old;
	}



}
