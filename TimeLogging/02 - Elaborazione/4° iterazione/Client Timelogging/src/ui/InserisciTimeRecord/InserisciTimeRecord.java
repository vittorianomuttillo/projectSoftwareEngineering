package ui.InserisciTimeRecord;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ui.Command.InserisciTimeRecordCommand;
import ui.Home.Home;

public class InserisciTimeRecord  extends JDialog{

	private static final long serialVersionUID = 1L;
	private JFrame ff;	
	private JButton inserisci;
	private JPanel textPane;
	private JLabel descrizioneT;
	private JTextField descrizioneTask;
	
	
	public JTextField getDescrizioneTask() {
		return descrizioneTask;
	}

	public void setDescrizioneTask(JTextField descrizioneTask) {
		this.descrizioneTask = descrizioneTask;
	}

	public JFrame getFf() {
		return ff;
	}

	public void setFf(JFrame ff) {
		this.ff = ff;
	}

	public InserisciTimeRecord(JFrame f, GregorianCalendar dataI, GregorianCalendar dataF, long milli, String string, String nomeTask) {
		// TODO Auto-generated constructor stub
		super();
    	ff = f;
    	
    	String[] xx = string.split("-");
 
    	descrizioneT = new JLabel("Descrizione Time Record: ");
    	descrizioneTask = new JTextField();
    	descrizioneTask.setEditable(true);
    	
    	inserisci = new JButton(new InserisciTimeRecordCommand(this, descrizioneTask, xx[0], xx[1], nomeTask, dataI.getTimeInMillis(), dataF.getTimeInMillis(), milli, Integer.parseInt(Home.getId())));
     	
    	textPane = new JPanel(new GridLayout(2,2, 10,10));    	
    	textPane.add(descrizioneT);
    	textPane.add(descrizioneTask);
    	textPane.add(inserisci);
    	
    	ff.add(textPane, BorderLayout.CENTER);
    	ff.setLocationRelativeTo(null); 

	}

}
