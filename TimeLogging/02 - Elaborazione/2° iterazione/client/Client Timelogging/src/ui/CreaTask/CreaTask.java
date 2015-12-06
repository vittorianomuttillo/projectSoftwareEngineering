package ui.CreaTask;

import Handler.GestisciTaskHandlerPrx;
import Handler.ProxieFactory;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import ui.home.Home;

public class CreaTask extends JDialog implements ActionListener {
	
	private static final long serialVersionUID = 1L;

	private static String AVANTI = "Avanti";

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

	private JTextArea descrizioneTask;

	private JLabel descrizioneT;
    
    public CreaTask(JFrame f, String tipo){
    	super();
    	ff = f;
    	
    	nomeT = new JLabel("Nome Task: ");
    	nomeTask = new JTextField(10);
    	descrizioneT = new JLabel("Descrizione Task: ");
    	descrizioneTask = new JTextArea();
    	descrizioneTask.setEditable(true);

    	save = new JButton("Avanti");
    	save.setActionCommand(AVANTI);
    	save.addActionListener(this);
    	
    	textPane = new JPanel(new GridLayout(6,2, 10,10));
    	
    	textPane.add(nomeT);
    	textPane.add(nomeTask);
    	textPane.add(descrizioneT);
    	textPane.add(descrizioneTask);
    	textPane.add(new JLabel(""));
    	textPane.add(save);
    	
    	f.add(textPane, BorderLayout.NORTH);

    }
    
	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
	
		if (AVANTI.equals(cmd)) {
			JFrame f = new JFrame();
			f.setLayout(new BorderLayout());
			f.setMinimumSize(new Dimension(300,400));
			f.setVisible(true);
			new AggiungiDipendenti(f, this.descrizioneTask.getText(), this.nomeTask.getText());
		} 
		
		ff.dispose();
	}

	public static String getProgetto() {
		return progetto;
	}

	public static void setProgetto(String progetto) {
		CreaTask.progetto = progetto;
	}

	public static String getSottoprogetto() {
		return sottoprogetto;
	}

	public static void setSottoprogetto(String sottoprogetto) {
		CreaTask.sottoprogetto = sottoprogetto;
	}

	public static String getOld() {
		return old;
	}

	public static void setOld(String old) {
		CreaTask.old = old;
	}



}
