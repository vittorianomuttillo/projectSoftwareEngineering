package ui.Command;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import ui.GestisciTask.CreaInfoTask;


public class CreaTaskCommand extends AbstractAction{

	public CreaTaskCommand(){
		super("Crea Task");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//Add button clicked
    	JFrame f = new JFrame();
		f.setLayout(new BorderLayout());
		f.setMinimumSize(new Dimension(300,350));
		f.setVisible(true);
		//f.setLocationByPlatform(true);
		f.pack();
		new CreaInfoTask(f, "Salva");
	}

}
