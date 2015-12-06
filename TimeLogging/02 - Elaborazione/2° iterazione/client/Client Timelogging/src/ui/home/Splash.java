package ui.home;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Window;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JWindow;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


public class Splash extends JWindow {
	
	private static final long serialVersionUID = 1L;
	
	private static JWindow splashScreen = new JWindow();
	
	public void start() {
		
		splashScreen.addWindowListener(new WindowAdapter() {
			
			private boolean closed = false;
			
			public void windowOpened(WindowEvent e) {
				startBackgroundInitialization(e.getWindow());
			}

			public void windowClosed(WindowEvent e) {
				
				if(closed == false) {
					
					closed = true;
					showMainFrame();
				}
			}

		});
		
		ImageIcon icon = createImageIcon("../images/splash.png");
		JLabel label = new JLabel(icon);
		splashScreen.setLayout(new GridBagLayout());
		splashScreen.setBackground(Color.WHITE);
		splashScreen.add(label,new GridBagConstraints()); 
		splashScreen.setSize(670,432);
		splashScreen.setLocationByPlatform(true);
		//splashScreen.setLocationRelativeTo(null);
		splashScreen.setBackground(Color.BLACK);
		splashScreen.setVisible(true);

	}

	private static void startBackgroundInitialization(final Window splashScreen) {
		
		new Thread() {
			
			@Override public void run() {
				
				try {
					Thread.sleep(1000);//simula qualcosa da fare...
					
				} catch(InterruptedException ignore) {
					ignore.printStackTrace();
				} finally {
					disposeWindow(splashScreen);
				}
			}
		}.start();
	}

	private static void showMainFrame() {

		try {
			
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        UIManager.put("swing.boldMetal", Boolean.FALSE);
        
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @SuppressWarnings("static-access")
			public void run() {
            	
            	Home time_loggin = new Home();             
            }
        });	
		
	}

	private static void disposeWindow(final Window window) {

		EventQueue.invokeLater(new Runnable() {

			public void run() {
				window.dispose();
			}
		});
	}
	
	protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = Splash.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
	
}