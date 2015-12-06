package ui.CreaTask;

import Handler.GestisciTaskHandlerPrx;
import Handler.ProxieFactory;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ui.home.Home;

public class GestisciDipendenti extends JDialog implements ActionListener {
	
	private static final long serialVersionUID = 1L;

	private static final String SALVA = "Salva";
	private static String AGGIUNGI = "Aggiungi";
	private static String ELIMINA = "Elimina";
	private static String SOSTITUISCI = "Sostituisci";
	private static String CONSULENTE = "Consulente";
	
	private String nomeProgetto;
	public String getNomeProgetto() {
		return nomeProgetto;
	}

	public void setNomeProgetto(String nomeProgetto) {
		this.nomeProgetto = nomeProgetto;
	}

	public String getNomeSottoprogetto() {
		return nomeSottoprogetto;
	}

	public void setNomeSottoprogetto(String nomeSottoprogetto) {
		this.nomeSottoprogetto = nomeSottoprogetto;
	}

	private String nomeSottoprogetto;
	private String nomeTask;
	private String descTask;	
	private List<String[]> l = new ArrayList<String[]>();
	
    private JFrame ff;

	private JPanel textPane;
	private JButton save;
	private JButton aggiungi;
	private JButton elimina;
	private JButton sostituisci;
	private JLabel consulenteT;
	public static JComboBox consulente;
	private ArrayList<String> nomi = new ArrayList<String>();
	public static ArrayList<Integer> id = new ArrayList<Integer>();
    
    public GestisciDipendenti(JFrame f, String nome, String desc, String nomeProgetto, String nomeSottoprogetto){
    	super();
    	ff = f;
    	
    	this.nomeTask = nome;
    	this.descTask = desc;
       	
    	consulenteT = new JLabel("Dipendente: ");
    	this.nomeProgetto = nomeProgetto;
    	this.nomeSottoprogetto = nomeSottoprogetto;
	    GestisciTaskHandlerPrx handler = (GestisciTaskHandlerPrx) ProxieFactory.factoryMethod("GestisciTaskHandler", null, null, null);
	    String tmp = handler.getInfoTask(this.nomeProgetto, this.nomeSottoprogetto, this.nomeTask);
	    nomi.add("Seleziona un dipendente... ");
	    id.add(0);
	    String[] nomitmp = tmp.split(";");
	    for (int i=2; i<nomitmp.length; i++){
	    	this.nomi.add(nomitmp[i].split("-")[0]);
	    	this.id.add(Integer.valueOf(nomitmp[i].split("-")[1]));
	    }
	    
	    consulente = new JComboBox(nomi.toArray());
	    consulente.setSelectedIndex(0);
	    consulente.addActionListener(this);
	    consulente.setActionCommand(CONSULENTE);
	    	    
    	elimina = new JButton("Elimina");
    	elimina.setEnabled(false);
    	elimina.addActionListener(this);
    	
    	sostituisci = new JButton("Sostituisci");
    	sostituisci.setEnabled(false);   	
    	sostituisci.addActionListener(this);
    	
    	save = new JButton("Salva");
    	save.addActionListener(this);
    	
    	aggiungi = new JButton("Aggiungi");
    	aggiungi.addActionListener(this);
    	
    	textPane = new JPanel(new GridLayout(3,2, 10,10));
    	
    	
    	textPane.add(consulenteT);
    	textPane.add(consulente);
    	textPane.add(elimina);
    	textPane.add(sostituisci);
    	textPane.add(aggiungi);
    	textPane.add(save);
    	
    	f.add(textPane, BorderLayout.NORTH);

    }
    
	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		GestisciTaskHandlerPrx prx = (GestisciTaskHandlerPrx) ProxieFactory.factoryMethod("GestisciTaskHandler", null, null, null);
		
		if (SALVA.equals(cmd)) {
			
			this.ff.dispose();	
			Home.AggiornaGUI(true, "Manager");
		} else if (AGGIUNGI.equals(cmd)){
			
			JFrame f = new JFrame();
			f.setLayout(new BorderLayout());
			f.setMinimumSize(new Dimension(300,300));
			f.setVisible(true);
			new AggiungiDipendente(f, this.nomeTask, "aggiungi", 0);
			
		} else if (SOSTITUISCI.equals(cmd)){
			
			JFrame f = new JFrame();
			f.setLayout(new BorderLayout());
			f.setMinimumSize(new Dimension(300,300));
			f.setVisible(true);
			new AggiungiDipendente(f, this.nomeTask, "sostituisci", this.id.get(this.consulente.getSelectedIndex()));
			
		} else if (ELIMINA.equals(cmd)){
			
			prx.eliminaDipendente(this.nomeProgetto, this.nomeSottoprogetto, this.nomeTask, this.id.get(consulente.getSelectedIndex()));
			this.consulente.removeItemAt(this.consulente.getSelectedIndex());		
			this.id.remove(this.consulente.getSelectedIndex());
			
		} else if (CONSULENTE.equals(cmd)){
			
			if (consulente.getSelectedIndex() != 0){
				sostituisci.setEnabled(true);
				elimina.setEnabled(true);
			} else {
				sostituisci.setEnabled(false);
				elimina.setEnabled(false);
			}
			
		}
	
	}


}

