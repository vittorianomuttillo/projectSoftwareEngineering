package ui.home;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import ui.CreaTask.ContentFactoryManager;

public class Content extends JPanel implements ActionListener{


	private JPanel contenuto;

	public Content(String con) {
		
		super(new BorderLayout());
		if(con == "Azienda"){
			// crea content azienda
		}else if(con == "Manager"){
			ContentFactoryManager m = new ContentFactoryManager();
			JPanel mTreePanel = m.createTreePanel();
			JPanel mPanel = m.createPanel();
			add(mTreePanel, BorderLayout.CENTER);       
	        add(mPanel, BorderLayout.SOUTH);
		}else if(con == "Consuente"){
			// crea Content consulente
			//ContentFactoryConsulente c = new ContentFactoryConsulente();
			//JPanel cTreePanel = c.createTreePanel();
			//JPanel cPanel = c.createPanel();
			//add(cTreePanel, BorderLayout.CENTER);       
	        //add(cPanel, BorderLayout.SOUTH);
		}else{
			
		}
		
			
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
