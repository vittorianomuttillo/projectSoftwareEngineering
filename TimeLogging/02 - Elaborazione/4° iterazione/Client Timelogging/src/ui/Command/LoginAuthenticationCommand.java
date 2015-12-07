package ui.Command;

import java.awt.event.ActionEvent;
import java.util.Arrays;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

import ui.Home.Home;
import ui.Home.Menu;
import ui.Login.Login;
import Handler.LoginHandlerPrx;
import Handler.ProxieFactory;

public class LoginAuthenticationCommand extends AbstractAction{

	private static final long serialVersionUID = 1L;
	private Login lgn;
	
	public LoginAuthenticationCommand(Login log){
		super("Ok");
		this.lgn = log;
	}
	
	protected void resetFocus() {
        lgn.getPasswordField().requestFocusInWindow();
    }
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		 LoginHandlerPrx prx = (LoginHandlerPrx) ProxieFactory.factoryMethod("LoginHandler", null, null, null);
	     
	     	 String userIn = lgn.getUsername().getText();
	       	
	         char[] passIn = lgn.getPasswordField().getPassword();
	         String pass = new String(passIn);
	         
	         String auth = prx.authenticate(userIn, pass);
	         
	         System.out.println("User box: "+userIn);
	         System.out.println("Password box: "+pass);
	         
	         if (auth.equals("EManager")) {
	             
	        	 Login.setLogin(true);
	        	 lgn.getFf().dispose();
	             Menu.getLogin().setEnabled(false);
	             Menu.getLogout().setEnabled(true);
	             Home.AggiornaGUI("Manager");
	             
	         } else if (auth.equals("Azienda")) {
	                
	        	 	 Login.setLogin(true);
	        	 	 lgn.getFf().dispose();
	                 Menu.getLogin().setEnabled(false);
	                 Menu.getLogout().setEnabled(true);
	                 Home.AggiornaGUI("Azienda");
	                 
	         } else if (auth.equals("EConsulente")) {
	                
	        	 	 Login.setLogin(true);
	                 lgn.getFf().dispose();
	                 Menu.getLogin().setEnabled(false);
	                 Menu.getLogout().setEnabled(true);
	                 Home.setId(userIn);
	                 Home.setTipo("Consulente");
	                 Home.AggiornaGUI("Consulente");
	                 
	         }else{
	             JOptionPane.showMessageDialog(lgn.getControllingFrame(), "Nome utente o password non validi!", "Error Message",JOptionPane.ERROR_MESSAGE);
	         }

	         Arrays.fill(passIn, '0');
	
	         lgn.getPasswordField().selectAll();
	         resetFocus();
	     } 
	}

