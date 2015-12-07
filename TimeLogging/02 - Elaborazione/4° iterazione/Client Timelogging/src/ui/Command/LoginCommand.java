package ui.Command;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JFrame;

import ui.Login.Login;

public class LoginCommand extends AbstractAction{

	private static final long serialVersionUID = 1L;

	public LoginCommand(){
		super("Login");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JFrame f = new JFrame();
		f.setLayout(new BorderLayout());
		f.setMinimumSize(new Dimension(200,150));
		f.setLocationByPlatform(true);
		f.setVisible(true);
		new Login(f);
	}

}
