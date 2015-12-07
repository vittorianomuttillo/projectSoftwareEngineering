package ui.Command;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JFrame;

import ui.GestisciTask.CreaInfoTask;

public class CreaTaskCommand extends AbstractAction{

	private static final long serialVersionUID = 1L;

	public CreaTaskCommand(){
		super("Crea Task");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
    	JFrame f = new JFrame();
		f.setLayout(new BorderLayout());
		f.setMinimumSize(new Dimension(300,350));
		f.setVisible(true);
		f.pack();
		new CreaInfoTask(f, "Salva");
	}

}
