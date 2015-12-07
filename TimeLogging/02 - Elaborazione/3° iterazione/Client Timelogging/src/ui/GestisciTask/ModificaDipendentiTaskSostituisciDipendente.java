package ui.GestisciTask;

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

import ui.Command.ModificaDipendenteTask_SostituisciDipendenteSalvaCommand;
import Handler.GestisciTaskHandlerPrx;
import Handler.ProxieFactory;

public class ModificaDipendentiTaskSostituisciDipendente extends JDialog implements ActionListener {
	
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
	private ModificaDipendentiTask mdt;
	
	public String getNomeTask() {
		return nomeTask;
	}

	public void setNomeTask(String nomeTask) {
		this.nomeTask = nomeTask;
	}

	public JComboBox getConsulente() {
		return consulente;
	}

	public void setConsulente(JComboBox consulente) {
		this.consulente = consulente;
	}

	public ArrayList<Integer> getId() {
		return id;
	}

	public void setId(ArrayList<Integer> id) {
		this.id = id;
	}

	public int getOldId() {
		return oldId;
	}

	public void setOldId(int oldId) {
		this.oldId = oldId;
	}
	
	public JTextField getUnita() {
		return unita;
	}

	public void setUnita(JTextField unita) {
		this.unita = unita;
	}
    
    public JTextField getQuantita() {
		return quantita;
	}

	public void setQuantita(JTextField quantita) {
		this.quantita = quantita;
	}

	public ModificaDipendentiTaskSostituisciDipendente(JFrame f, ModificaDipendentiTask modt, String tipo, int oldId){
    	super();
    	ff = f;
    	ff.setLocationRelativeTo(null);
    	
    	this.mdt=modt;
    	this.nomeTask = mdt.getNomeTask();    	
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
	    
 
    	save = new JButton(new ModificaDipendenteTask_SostituisciDipendenteSalvaCommand(this));
    	
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
    
	public JFrame getFf() {
		return ff;
	}

	public void setFf(JFrame ff) {
		this.ff = ff;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		GestisciTaskHandlerPrx prx = (GestisciTaskHandlerPrx) ProxieFactory.factoryMethod("GestisciTaskHandler", null, null, null);
	}


}

