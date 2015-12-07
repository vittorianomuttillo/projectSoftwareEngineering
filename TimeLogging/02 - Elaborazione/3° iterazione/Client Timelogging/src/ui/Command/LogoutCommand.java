package ui.Command;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JFrame;

import ui.Home.Home;
import ui.Home.Menu;
import ui.Login.Login;

public class LogoutCommand extends AbstractAction{

	public LogoutCommand(){
		super("Logout");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Home.AggiornaGUI("");
    	Menu.getLogin().setEnabled(true);
    	Menu.getLogout().setEnabled(false);
	}

}
