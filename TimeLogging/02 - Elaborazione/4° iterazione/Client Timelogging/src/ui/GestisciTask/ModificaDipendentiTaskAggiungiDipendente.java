package ui.GestisciTask;

import Handler.GestisciTaskHandlerPrx;
import Handler.ProxieFactory;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ui.Command.ModificaDipendenteTask_AggiungiDipendenteSalva;

public class ModificaDipendentiTaskAggiungiDipendente extends JDialog{
		
	private static final long serialVersionUID = 1L;

	private String nomeTask;
	private JFrame ff;
	private JPanel textPane;
	private JLabel tariffa;
	private JTextField quantita;
	private JTextField unita;
	private JButton save;
	private JLabel consulenteT;
	private JComboBox consulente;
	private ArrayList<String> nomi = new ArrayList<String>();
	private ArrayList<Integer> id = new ArrayList<Integer>();
	private String tipo;
	private ModificaDipendentiTask mdt;
	
    
    public ModificaDipendentiTaskAggiungiDipendente(JFrame f, ModificaDipendentiTask modt, String tipo, int oldId){
    	super();
    	ff = f;
    	ff.setLocationRelativeTo(null);
    	
    	this.mdt=modt;
    	this.nomeTask = mdt.getNomeTask();    	
    	this.tipo = tipo;
    
    	tariffa = new JLabel("Tariffa: ");
    	JLabel quantitaLabel = new JLabel("Quantità: ");
    	JLabel unitaLabel = new JLabel("Unità: ");
    	quantita = new JTextField(10);
    	unita = new JTextField(10);
    	consulenteT = new JLabel("Dipendente: ");
    	
	    GestisciTaskHandlerPrx handler = (GestisciTaskHandlerPrx) ProxieFactory.factoryMethod("GestisciTaskHandler", null, null, null);
	    String tmp = handler.getDipendenti();
	    String[] nomitmp = tmp.split(";");
	    nomi.add("Seleziona un Dipendente");
	    this.id.add(0);
	    
	    for (int i=0; i<nomitmp.length; i++){	    	
	    	boolean trovato=false;
	    	int j=0;
	    	while(j<modt.getId().size() && !trovato){
	    		if(Integer.parseInt(nomitmp[i].split("-")[0]) == modt.getId().get(j)){	    			
	    			trovato = true; 			
	    		}
	    		j++;
	    	}
	    	if(!trovato){
	    		nomi.add(nomitmp[i].split("-")[1]);
	    		this.id.add(Integer.parseInt(nomitmp[i].split("-")[0]));
	    	}
	    	
	    }
	    consulente = new JComboBox(nomi.toArray());
	    consulente.setSelectedIndex(0);
 
    	save = new JButton(new ModificaDipendenteTask_AggiungiDipendenteSalva(this));
  	
    	textPane = new JPanel(new GridLayout(10,2,0,4));
    	
    	textPane.add(tariffa);
    	textPane.add(quantitaLabel);
    	textPane.add(quantita);
    	textPane.add(unitaLabel);
    	textPane.add(unita);
    	textPane.add(consulenteT);
    	textPane.add(consulente);
    	textPane.add(save);

    	
    	f.add(textPane, BorderLayout.NORTH);

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
	
	public String getNomeTask() {
		return nomeTask;
	}

	public void setNomeTask(String nomeTask) {
		this.nomeTask = nomeTask;
	}

	public JFrame getFf() {
		return ff;
	}

	public void setFf(JFrame ff) {
		this.ff = ff;
	}

	public JComboBox getConsulente() {
		return consulente;
	}

	public void setConsulente(JComboBox consulente) {
		this.consulente = consulente;
	}

	public ArrayList<String> getNomi() {
		return nomi;
	}

	public void setNomi(ArrayList<String> nomi) {
		this.nomi = nomi;
	}

	public ArrayList<Integer> getId() {
		return id;
	}

	public void setId(ArrayList<Integer> id) {
		this.id = id;
	}


}

