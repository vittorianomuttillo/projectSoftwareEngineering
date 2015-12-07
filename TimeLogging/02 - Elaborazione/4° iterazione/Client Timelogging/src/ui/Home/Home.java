package ui.Home;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

import ui.Login.Login;

public class Home{
	
	//Attributi
	private static JFrame frame = new JFrame("Time Logging");	
	private static Menu menu;
	private static Content content;
	private static String id;
	private static String tipoC;
		
	//Metodi
	
	public static Menu getMenu() {
		return menu;
	}

	public static void setMenu(Menu menu) {
		Home.menu = menu;
	}
	
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
		content = new Content("");	
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		frame.getContentPane().add(menu,BorderLayout.PAGE_START); 
		frame.getContentPane().add(content); 
		frame.setSize(670,432);
		frame.setLocationRelativeTo(null);
		//frame.pack();
		frame.setVisible(true);
		
		JFrame f = new JFrame();
		f.setLayout(new BorderLayout());
		f.setMinimumSize(new Dimension(200,150));
		f.setLocationByPlatform(true);
		f.setVisible(true);
		Login x = new Login(f);
		
	}
	
	public static void AggiornaGUI(String tipo){			
			Content updateContent = new Content(tipo);
			frame.getContentPane().remove(frame.getContentPane().getComponents()[1]);
			frame.getContentPane().add(updateContent);
			frame.setVisible(true);	
	}

	public static String getId() {
		return id;
	}

	public static void setId(String id) {
		Home.id = id;
	}

	public static void setTipo(String string) {
		// TODO Auto-generated method stub
		tipoC = string;
	}

	public static String getTipo() {
		// TODO Auto-generated method stub
		return Home.tipoC;
	}
	
}
