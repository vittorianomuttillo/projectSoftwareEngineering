package ui.Home;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import ui.Command.LoginCommand;
import ui.Command.LogoutCommand;
import ui.Command.QuitCommand;

public class Menu extends JPanel{

	// attributi di classe
	
    protected JMenuBar menuBar;
	private JMenu menuFile;
	private JMenu menuHelp;	
	private JMenuItem quit;
	private static JMenuItem login;
	private static JMenuItem logout;
	private JMenuItem help;
	
	// metodi getter e setter
	
	public static JMenuItem getLogin() {
		return login;
	}

	public static void setLogin(JMenuItem login) {
		Menu.login = login;
	}

	public static JMenuItem getLogout() {
		return logout;
	}

	public static void setLogout(JMenuItem logout) {
		Menu.logout = logout;
	}

	public static JPanel menu = null;
    
	public static JPanel getMenu() {
		return menu;
	}

	public static void setMenu(JPanel menu_n) {
		Menu.menu = menu_n;
	}
    
	// costruttore
	
	public Menu() {
		// TODO Auto-generated method stub
		super(new BorderLayout());
    	
        //Create menubar che contiene tutti i menu
    	
        menuBar = new JMenuBar();

        //Menu FILE
        menuFile = new JMenu("File");
        menuFile.setMnemonic(KeyEvent.VK_F);
        menuFile.getAccessibleContext().setAccessibleDescription("File");
        
        menuBar.add(menuFile);     
        
       // Sottomenu LOGIN
        
        login = new JMenuItem(new LoginCommand());
        login.setAccelerator(KeyStroke.getKeyStroke(
		KeyEvent.VK_L, ActionEvent.ALT_MASK));
        login.getAccessibleContext().setAccessibleDescription("Login");
        login.setEnabled(true);
        menuFile.add(login);
        
     // Sottomenu LOGOUT
        
        logout = new JMenuItem(new LogoutCommand());
        logout.setAccelerator(KeyStroke.getKeyStroke(
		KeyEvent.VK_K, ActionEvent.ALT_MASK));
        logout.getAccessibleContext().setAccessibleDescription("Logout");
        logout.setEnabled(false);
        menuFile.add(logout);
        
        // Sottomenu QUIT
        menuFile.addSeparator();
        
        quit = new JMenuItem(new QuitCommand());
        quit.setAccelerator(KeyStroke.getKeyStroke(
		KeyEvent.VK_Q, ActionEvent.ALT_MASK));
        quit.getAccessibleContext().setAccessibleDescription("Quit");
        quit.setEnabled(true);
        menuFile.add(quit);

      //menu Help.
    
        menuHelp = new JMenu("Help");
        menuHelp.setMnemonic(KeyEvent.VK_H);
        menuHelp.getAccessibleContext().setAccessibleDescription("Help");
        menuBar.add(menuHelp);
        
        //Sottomenu Help 
        help = new JMenuItem("Help",KeyEvent.VK_T);
        help.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_4, ActionEvent.ALT_MASK));
        help.getAccessibleContext().setAccessibleDescription("Help");
        menuHelp.add(help);
        
        add(menuBar);

	}

}