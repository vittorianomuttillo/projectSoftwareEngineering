package ui.CalcolaStipendio;

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

import ui.Command.CalcolaStipendioCommand;
import Handler.CalcolaStipendioHandlerPrx;
import Handler.ProxieFactory;

public class CalcolaStipendio extends JDialog implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JFrame ff;	
	private ArrayList<String> nomi = new ArrayList<String>();
	private ArrayList<String> id = new ArrayList<String>();
	private JLabel consulenteT;
	private JComboBox consulente;
	private JButton calcola;
	private JPanel textPane;
	private CalcolaStipendioCommand command;

	public CalcolaStipendio(JFrame f) {
		// TODO Auto-generated constructor stub
		super();
    	ff = f;
    	ff.setLocationRelativeTo(null);
    	
    	consulenteT = new JLabel("Dipendente: ");    	
	    CalcolaStipendioHandlerPrx handler = (CalcolaStipendioHandlerPrx) ProxieFactory.factoryMethod("CalcolaStipendioHandler", null, null, null);
	   	    
	    String tmp = handler.getDipendenti();
	    String[] nomitmp = tmp.split(";");
	    nomi.add("Seleziona un consulente");
	    this.id.add("");
	    for (int i=0; i<nomitmp.length; i++){
	    	nomi.add(nomitmp[i].split("-")[1]);
	    	this.id.add(nomitmp[i].split("-")[0]);
	    }
	    consulente = new JComboBox(nomi.toArray());
	    
	    command = new CalcolaStipendioCommand();
 
    	calcola = new JButton(command);
    	calcola.addActionListener(this);
     	
    	textPane = new JPanel(new GridLayout(2,2, 10,10));    	
    	textPane.add(consulenteT);
    	textPane.add(consulente);
    	textPane.add(calcola);
    	
    	f.add(textPane, BorderLayout.NORTH);

	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		command.setCodF(this.id.get(this.consulente.getSelectedIndex()));
	}

}
