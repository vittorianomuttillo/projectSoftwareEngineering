package ui.Home;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;


public class Content extends JPanel implements ActionListener{


	private static final long serialVersionUID = 1L;
	private JPanel contenuto;

	public Content(String con) {
		
		super(new BorderLayout());
		if(con == "Azienda"){
			ContentFactoryAzienda a = new ContentFactoryAzienda();
			JPanel aTreePanel = a.createTreePanel();
			JPanel aPanel = a.createPanel();
			add(aTreePanel, BorderLayout.CENTER);       
	        add(aPanel, BorderLayout.SOUTH);
		}else if(con == "Manager"){
			ContentFactoryManager m = new ContentFactoryManager();
			JPanel mTreePanel = m.createTreePanel();
			JPanel mPanel = m.createPanel();
			add(mTreePanel, BorderLayout.CENTER);       
	        add(mPanel, BorderLayout.SOUTH);
		}else if(con == "Consuente"){
			// crea Content consulente
			ContentFactoryConsulente c = new ContentFactoryConsulente();
			JPanel cTreePanel = c.createTreePanel();
			JPanel cPanel = c.createPanel();
			add(cTreePanel, BorderLayout.CENTER);       
	        add(cPanel, BorderLayout.SOUTH);
		}else{
			
		}					
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
