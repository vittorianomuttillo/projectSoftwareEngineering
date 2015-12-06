package ui.CreaTask;

import Handler.GestisciTaskHandlerPrx;
import Handler.ProxieFactory;

import java.awt.BorderLayout;
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

public class GestisciTask extends JDialog implements ActionListener {
	
	private static final long serialVersionUID = 1L;

	private static final String MODIFICA = "Modifica";
	private static String SALVA = "Salva";

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

	public JLabel getTariffa() {
		return tariffa;
	}

	public void setTariffa(JLabel tariffa) {
		this.tariffa = tariffa;
	}

	public JTextField getQuantita() {
		return quantita;
	}

	public void setQuantita(JTextField quantita) {
		this.quantita = quantita;
	}

	public JTextField getUnita() {
		return unita;
	}

	public void setUnita(JTextField unita) {
		this.unita = unita;
	}

	public JComboBox getConsulente() {
		return consulente;
	}

	public void setConsulente(JComboBox consulente) {
		this.consulente = consulente;
	}

	public JTextArea getDescrizioneTask() {
		return descrizioneTask;
	}

	public void setDescrizioneTask(JTextArea descrizioneTask) {
		this.descrizioneTask = descrizioneTask;
	}

	private JPanel textPane;
	private JLabel tariffa;
	private JTextField quantita;
	private JTextField unita;
	private JButton save;
	private JLabel consulenteT;
	private JComboBox consulente;
	private ArrayList<String> nomi = new ArrayList<String>();
	private ArrayList<Integer> id = new ArrayList<Integer>();

	private JTextArea descrizioneTask;

	private JLabel descrizioneT;
    
    public GestisciTask(JFrame f, String tipo){
    	super();
    	ff = f;
    	
    	nomeT = new JLabel("Nome Task: ");
    	nomeTask = new JTextField(10);
    	descrizioneT = new JLabel("Descrizione Task: ");
    	descrizioneTask = new JTextArea();
    	descrizioneTask.setEditable(true);
    	tariffa = new JLabel("Tariffa: ");
    	quantita = new JTextField(10);
    	unita = new JTextField(10);
    	consulenteT = new JLabel("Consulente: ");
    	
    	//if (tipo.equals("Salva")){
	    	GestisciTaskHandlerPrx handler = (GestisciTaskHandlerPrx) ProxieFactory.factoryMethod("GestisciTaskHandler", null, null, null);
	    	String tmp = handler.getConsulenti();
	    	String[] nomitmp = tmp.split(";");
	    	for (int i=0; i<nomitmp.length; i++){
	    		nomi.add(nomitmp[i].split("-")[1]);
	    		id.add(Integer.parseInt(nomitmp[i].split("-")[0]));
	    	}
	    	consulente = new JComboBox(nomi.toArray());
	    	consulente.setSelectedIndex(0);
	    	consulente.addActionListener(this);
    	//}
    	save = new JButton("Salva");
    	
    	if (tipo.equals("Salva"))
    		save.setActionCommand(SALVA);
    	else
    		save.setActionCommand(MODIFICA);
    	
    	save.addActionListener(this);
    	
    	textPane = new JPanel(new GridLayout(8,2, 10,10));
    	
    	textPane.add(nomeT);
    	textPane.add(nomeTask);
    	textPane.add(descrizioneT);
    	textPane.add(descrizioneTask);
    	textPane.add(tariffa);
    	textPane.add(quantita);
    	textPane.add(new JLabel(""));
    	textPane.add(unita);
    	textPane.add(consulenteT);
    	//if (tipo.equals("salva"))
    		textPane.add(consulente);
    	textPane.add(save);
    	
    	f.add(textPane, BorderLayout.NORTH);

    }
    
	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		GestisciTaskHandlerPrx prx = (GestisciTaskHandlerPrx) ProxieFactory.factoryMethod("GestisciTaskHandler", null, null, null);
		
		if (SALVA.equals(cmd)) {
			
			prx.creaTask(GestisciTask.getProgetto(), GestisciTask.getSottoprogetto(), descrizioneTask.getText(), 
					 	id.get(consulente.getSelectedIndex()), 
					 	Double.parseDouble(quantita.getText()), unita.getText(), nomeTask.getText());
			Home.AggiornaGUI(true, "Manager");
			
		} else {
			prx.modificaTask(GestisciTask.getProgetto(), GestisciTask.getSottoprogetto(), descrizioneTask.getText(), nomeTask.getText(), GestisciTask.getOld());
			Home.AggiornaGUI(true, "Manager");
		}
		
		ff.dispose();
	}

	public static String getProgetto() {
		return progetto;
	}

	public static void setProgetto(String progetto) {
		GestisciTask.progetto = progetto;
	}

	public static String getSottoprogetto() {
		return sottoprogetto;
	}

	public static void setSottoprogetto(String sottoprogetto) {
		GestisciTask.sottoprogetto = sottoprogetto;
	}

	public static String getOld() {
		return old;
	}

	public static void setOld(String old) {
		GestisciTask.old = old;
	}



}
