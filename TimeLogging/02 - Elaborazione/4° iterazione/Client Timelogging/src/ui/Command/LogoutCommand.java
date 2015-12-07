package ui.Command;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import ui.Home.Home;
import ui.Home.Menu;

public class LogoutCommand extends AbstractAction{

	private static final long serialVersionUID = 1L;

	public LogoutCommand(){
		super("Logout");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Home.setId(null);
		Home.AggiornaGUI("");
    	Menu.getLogin().setEnabled(true);
    	Menu.getLogout().setEnabled(false);
	}

}
