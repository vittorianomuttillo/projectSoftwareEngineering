package ui.GestisciTask;

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

import ui.Home.Home;

public class CreaTaskAggiungiDipendenti extends JDialog implements ActionListener {
	
	private static final long serialVersionUID = 1L;

	private static final String SALVA = "Salva";
	private static String AGGIUNGI = "Aggiungi";
	private String nomeTask;
	private String descTask;	
	private List<String[]> l = new ArrayList<String[]>();	
    private JFrame ff;
	private JPanel textPane;
	private JLabel tariffa;
	private JTextField quantita;
	private JTextField unita;
	private JButton save;
	private JButton aggiungi;
	private JLabel consulenteT;
	private JComboBox consulente;
	private ArrayList<String> nomi = new ArrayList<String>();
	private ArrayList<Integer> id = new ArrayList<Integer>();
    
    public CreaTaskAggiungiDipendenti(JFrame f, String nome, String desc){
    	super();
    	ff = f;
    	ff.setLocationRelativeTo(null);
    	
    	this.nomeTask = nome;
    	this.descTask = desc;
    
    	tariffa = new JLabel("Tariffa: ");
    	JLabel quantitaLabel = new JLabel("Quantità: ");
    	JLabel unitaLabel = new JLabel("Tariffa: ");
    	quantita = new JTextField(10);
    	unita = new JTextField(10);
    	consulenteT = new JLabel("Dipendente: ");
    	
	    GestisciTaskHandlerPrx handler = (GestisciTaskHandlerPrx) ProxieFactory.factoryMethod("GestisciTaskHandler", null, null, null);
	    String tmp = handler.getDipendenti();
	    String[] nomitmp = tmp.split(";");
	    nomi.add("Seleziona un Dipendente");
	    id.add(0);
	    for (int i=0; i<nomitmp.length; i++){
	    	nomi.add(nomitmp[i].split("-")[1]);
	    	id.add(Integer.parseInt(nomitmp[i].split("-")[0]));
	    }
	    consulente = new JComboBox(nomi.toArray());
	    consulente.setSelectedIndex(0);
 
    	save = new JButton("Salva");
    	save.setEnabled(false);   	
    	save.addActionListener(this);
    	
    	aggiungi = new JButton("Aggiungi");
    	aggiungi.addActionListener(this);
    	
    	textPane = new JPanel(new GridLayout(10,2));
    	
    	textPane.add(tariffa);
    	textPane.add(quantitaLabel);
    	textPane.add(quantita);
    	textPane.add(unitaLabel);
    	textPane.add(unita);
    	textPane.add(consulenteT);
    	textPane.add(consulente);
    	textPane.add(save);

    	textPane.add(aggiungi);
    	
    	f.add(textPane, BorderLayout.NORTH);

    }
    
	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		GestisciTaskHandlerPrx prx = (GestisciTaskHandlerPrx) ProxieFactory.factoryMethod("GestisciTaskHandler", null, null, null);
		
		if (SALVA.equals(cmd)) {
			
			prx.creaTask(CreaInfoTask.getProgetto(), CreaInfoTask.getSottoprogetto(), this.descTask, 
					 	this.l,  this.nomeTask);
			ff.dispose();
			Home.AggiornaGUI("Manager");
			
		} else if (AGGIUNGI.equals(cmd)){
			
			save.setEnabled(true);
			
			int id = this.id.get(consulente.getSelectedIndex());
			String unita = this.unita.getText();
			Double quantita = Double.valueOf(this.quantita.getText());
			
			System.out.println(id+"-"+unita+"-"+quantita);
			
			l = prx.aggiornaElencoDipendenti(l, id, unita, quantita);
			
			this.unita.setText(null);
			this.quantita.setText(null);
			this.consulente.removeItemAt(consulente.getSelectedIndex());
			this.id.remove(consulente.getSelectedIndex());
			//this.consulente.remove(this.consulente.getSelectedIndex());
			this.consulente.setSelectedIndex(0);
			
		}
	
	}


}

