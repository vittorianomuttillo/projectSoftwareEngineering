package ui.home;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Home{
	
	//Attributi
	private static JFrame frame = new JFrame("Time Logging");
	private static Menu menu;
	private static Content content;
	private String tipo;
	
	public static Menu getMenu() {
		return menu;
	}

	public static void setMenu(Menu menu) {
		Home.menu = menu;
	}
	
	//Metodi
	
	public Home() {  // Costruttore
		javax.swing.SwingUtilities.invokeLater(new Runnable(){
			@Override
			public void run() {				
				CreateAndShowGUI();
			}
		});
	}

	protected static void CreateAndShowGUI() {	
		
		menu = new Menu();	
		content = new Content("Manager");
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		frame.getContentPane().add(menu,BorderLayout.PAGE_START); 
		frame.getContentPane().add(content); 
		frame.setPreferredSize(new Dimension(670,432));
		frame.setLocationByPlatform(true);
		//frame.setLocationRelativeTo(null);
		frame.pack();
		frame.setVisible(true);
	}
	
	public static void AggiornaGUI(boolean login, String tipo){			
		
	//	Menu updateMenu = new Menu(tipo);
		Content updateContent = new Content(tipo);

		frame.getContentPane().remove(frame.getContentPane().getComponents()[1]);
		frame.getContentPane().add(updateContent);
		frame.setVisible(true);			
		//menu.getMenuItemLogin().setEnabled(false);
		//menu.getMenuItemLogout().setEnabled(true);
		
	}
	
}
