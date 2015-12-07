package ui.GestisciTask;

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

import ui.Command.ModificaDipendenteTask_AggiungiCommand;
import ui.Command.ModificaDipendenteTask_EliminaCommand;
import ui.Command.ModificaDipendenteTask_SalvaCommand;
import ui.Command.ModificaDipendenteTask_SostituisciCommand;
import ui.Home.Home;

public class ModificaDipendentiTask extends JDialog implements ActionListener {
	
	private static final long serialVersionUID = 1L;

	private static final String SALVA = "Salva";
	private static String AGGIUNGI = "Aggiungi";
	private static String ELIMINA = "Elimina";
	private static String SOSTITUISCI = "Sostituisci";
	private static String CONSULENTE = "Consulente";
	private  String nomeProgetto;
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
	private  JComboBox consulente;
	private ArrayList<String> nomi = new ArrayList<String>();
	private ArrayList<Integer> id = new ArrayList<Integer>();
    
    public  ArrayList<Integer> getId() {
		return id;
	}
    
	public String getDescTask() {
		return descTask;
	}

	public void setDescTask(String descTask) {
		this.descTask = descTask;
	}

	public ModificaDipendentiTask(JFrame f, String nome, String desc, String nomeProgetto, String nomeSottoprogetto){
    	super();
    	ff = f;
    	ff.setLocationRelativeTo(null);
    	
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
	    	    
    	elimina = new JButton(new ModificaDipendenteTask_EliminaCommand(this));
    	elimina.setEnabled(false);
    	elimina.addActionListener(this);
    	
    	sostituisci = new JButton(new ModificaDipendenteTask_SostituisciCommand(this));
    	sostituisci.setEnabled(false);   	
    	sostituisci.addActionListener(this);
    	
    	save = new JButton(new ModificaDipendenteTask_SalvaCommand(this));
    	save.addActionListener(this);
    	
    	aggiungi = new JButton(new ModificaDipendenteTask_AggiungiCommand(this));
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
	
	public  String getNomeProgetto() {
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
	
	public JComboBox getConsulente() {
		return consulente;
	}

	public void setConsulente(JComboBox consulente) {
		this.consulente = consulente;
	}

	public JFrame getFf() {
		return ff;
	}

	public void setFf(JFrame ff) {
		this.ff = ff;
	}
    
	public String getNomeTask() {
		return nomeTask;
	}

	public void setNomeTask(String nomeTask) {
		this.nomeTask = nomeTask;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		GestisciTaskHandlerPrx prx = (GestisciTaskHandlerPrx) ProxieFactory.factoryMethod("GestisciTaskHandler", null, null, null);
		
		if (CONSULENTE.equals(cmd)){
			
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

