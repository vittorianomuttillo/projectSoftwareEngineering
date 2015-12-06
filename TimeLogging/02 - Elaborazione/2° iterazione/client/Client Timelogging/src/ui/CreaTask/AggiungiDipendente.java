package ui.CreaTask;

import Handler.GestisciTaskHandlerPrx;
import Handler.ProxieFactory;

import java.awt.BorderLayout;
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
import javax.swing.JTextField;

import ui.home.Home;

public class AggiungiDipendente extends JDialog implements ActionListener {
	
	private static final long serialVersionUID = 1L;

	private static final String SALVA = "Salva";
	private String nomeTask;
	private List<String[]> l = new ArrayList<String[]>();
	
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

	private int oldId;
    
    public AggiungiDipendente(JFrame f, String nome, String tipo, int oldId){
    	super();
    	ff = f;
    	
    	this.nomeTask = nome;
    	
    	this.oldId = oldId;
    	this.tipo = tipo;
    
    	tariffa = new JLabel("Tariffa: ");
    	quantita = new JTextField(10);
    	unita = new JTextField(10);
    	consulenteT = new JLabel("Dipendente: ");
    	
	    GestisciTaskHandlerPrx handler = (GestisciTaskHandlerPrx) ProxieFactory.factoryMethod("GestisciTaskHandler", null, null, null);
	    String tmp = handler.getDipendenti();
	    String[] nomitmp = tmp.split(";");
	    nomi.add("Seleziona un consulente");
	    this.id.add(0);
	    for (int i=0; i<nomitmp.length; i++){
	    	nomi.add(nomitmp[i].split("-")[1]);
	    	this.id.add(Integer.parseInt(nomitmp[i].split("-")[0]));
	    }
	    consulente = new JComboBox(nomi.toArray());
	    consulente.setSelectedIndex(0);
	    
	    if (tipo.equals("aggiungi")){
	    	
	    }else{
	    	
	    }
 
    	save = new JButton("Salva");
    	save.addActionListener(this);
 
    	
    	textPane = new JPanel(new GridLayout(8,2, 10,10));
    	
    	textPane.add(tariffa);
    	textPane.add(quantita);
    	textPane.add(new JLabel(""));
    	textPane.add(unita);
    	textPane.add(consulenteT);
    	textPane.add(consulente);
    	textPane.add(save);

    	
    	f.add(textPane, BorderLayout.NORTH);

    }
    
	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		GestisciTaskHandlerPrx prx = (GestisciTaskHandlerPrx) ProxieFactory.factoryMethod("GestisciTaskHandler", null, null, null);
		
		if (SALVA.equals(cmd)) {
			if (this.tipo.equals("aggiungi")){
				
				prx.aggiungiDipendente(CreaTask.getProgetto(), CreaTask.getSottoprogetto(), this.nomeTask, this.id.get(consulente.getSelectedIndex()));
				GestisciDipendenti.consulente.addItem(this.nomi.get(consulente.getSelectedIndex()));
				GestisciDipendenti.id.add(this.id.get(consulente.getSelectedIndex()));
				
			} else {
				
				prx.sostituisciDipendente(CreaTask.getProgetto(), CreaTask.getSottoprogetto(), this.nomeTask, this.id.get(consulente.getSelectedIndex()), this.oldId);

				
			}
			
			ff.dispose();
		}
	
	}


}

