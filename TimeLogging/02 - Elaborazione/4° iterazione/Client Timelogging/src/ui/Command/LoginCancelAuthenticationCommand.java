package ui.Command;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import ui.Login.Login;

public class LoginCancelAuthenticationCommand extends AbstractAction{

	private static final long serialVersionUID = 1L;
	private Login lgn;
	
	public LoginCancelAuthenticationCommand(Login log){
		super("Cancel");
		this.lgn = log;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		lgn.getFf().dispose();
	}
	
}
