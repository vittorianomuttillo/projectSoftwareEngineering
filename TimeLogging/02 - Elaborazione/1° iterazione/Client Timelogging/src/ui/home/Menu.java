package ui.home;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;

import ui.CreaTask.GestisciTask;

public class Menu extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	private JTextArea output;
    private JScrollPane scrollPane;
    private String newline = "\n";
    public final static int ONE_SECOND = 1000;

    protected JMenuBar menuBar;

	private JMenuItem quit;
	private JMenu menuFile;
	private JMenuItem menuItemLogin;
	private JMenuItem menuItemLogout;
	private JMenu menuEdit;
	private JMenu menuHelp;
	private JMenuItem help;
	private static JMenuItem creaTask;
	
	public static JMenuItem getCreaTask() {
		return creaTask;
	}

	public static void setCreaTask(JMenuItem creaTask) {
		Menu.creaTask = creaTask;
	}

	public static JPanel menu = null;
    
	public static JPanel getMenu() {
		return menu;
	}

	public static void setMenu(JPanel menu_n) {
		Menu.menu = menu_n;
	}
	
	public JMenu getMenuEdit() {
		return menuEdit;
	}

	public void setMenuEdit(JMenu menuEdit) {
		this.menuEdit = menuEdit;
	}
	
	public JMenuItem getMenuItemLogin() {
		return menuItemLogin;
	}

	public void setMenuItemLogin(JMenuItem menuItemLogin) {
		this.menuItemLogin = menuItemLogin;
	}
	
	public JMenuItem getMenuItemLogout() {
		return menuItemLogout;
	}

	public void setMenuItemLogout(JMenuItem menuItemLogout) {
		this.menuItemLogout = menuItemLogout;
	}

	public void actionPerformed(ActionEvent e) {
        
    }

    public void itemStateChanged(ItemEvent e) {
        
    }
    
    //This method must be evoked from the event-dispatching thread.
    public void quit() {
        if (quitConfirmed()) {
            System.out.println("Quitting.");
            System.exit(0);
        }
        System.out.println("Quit operation not confirmed; staying alive.");
    }

    private boolean quitConfirmed() {
        String s1 = "Quit";
        String s2 = "Cancel";
        Object[] options = {s1, s2};
        int n = JOptionPane.showOptionDialog(this,
                "Windows are still open.\nDo you really want to quit?",
                "Quit Confirmation",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                s1);
        if (n == JOptionPane.YES_OPTION) {
            return true;
        } else {
            return false;
        }
    }

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
        
        // Sottomenu QUIT
        menuFile.addSeparator();
        
        quit = new JMenuItem("Quit",KeyEvent.VK_T);
        quit.setAccelerator(KeyStroke.getKeyStroke(
		KeyEvent.VK_Q, ActionEvent.ALT_MASK));
        quit.getAccessibleContext().setAccessibleDescription("Quit");
        quit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Quit request");
                quit();
            }
        });
        quit.setEnabled(true);
        menuFile.add(quit);

      //menu EDIT.
        menuEdit = new JMenu("Edit");
        menuEdit.setMnemonic(KeyEvent.VK_E);
        menuEdit.getAccessibleContext().setAccessibleDescription("");
        menuEdit.setEnabled(true);

        menuBar.add(menuEdit);
        
       //JMenuItems CREATASK
    creaTask = new JMenuItem("Crea Task",
                             KeyEvent.VK_T);
    creaTask.setAccelerator(KeyStroke.getKeyStroke(
            KeyEvent.VK_3, ActionEvent.ALT_MASK));
    creaTask.getAccessibleContext().setAccessibleDescription(
            "");
    creaTask.setEnabled(false);
    creaTask.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			JFrame f = new JFrame();
			f.setLayout(new BorderLayout());
			f.setMinimumSize(new Dimension(300,300));
			f.setVisible(true);
			GestisciTask x = new GestisciTask(f, "Salva");
		}
	});
    
    menuEdit.add(creaTask);
        //Menu HELP.
        menuHelp = new JMenu("Help");
        menuHelp.setMnemonic(KeyEvent.VK_H);
        menuHelp.getAccessibleContext().setAccessibleDescription(
                "Help");
        menuBar.add(menuHelp);
        
        //JMenuItems HELP 
        help = new JMenuItem("Help",
                                 KeyEvent.VK_T);
        help.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_4, ActionEvent.ALT_MASK));
        help.getAccessibleContext().setAccessibleDescription(
                "Help");
        help.addActionListener(this);
        menuHelp.add(help);
        
        add(menuBar);

	}

	public JTextArea getOutput() {
		return output;
	}

	public void setOutput(JTextArea output) {
		this.output = output;
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}

	public String getNewline() {
		return newline;
	}

	public void setNewline(String newline) {
		this.newline = newline;
	}

    
}