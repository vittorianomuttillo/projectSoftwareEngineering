package ui.Login;

import ui.Command.LoginAuthenticationCommand;
import ui.Command.LoginCancelAuthenticationCommand;

import javax.swing.*;
import java.awt.*;

public class Login extends JDialog {
	
	private static final long serialVersionUID = 1L;
	private static String OK = "ok";
    private static String HELP = "help";
    private static boolean Login = false;
    private JFrame ff;
   	private JFrame controllingFrame; //needed for dialogs
    private JPasswordField passwordField;
	private JTextField username;
	
    public Login(JFrame f) {
    	
    	super();

    	this.ff = f;
    	username = new JTextField(10);
        passwordField = new JPasswordField(10);
        passwordField.setActionCommand(OK);
        
        JLabel user = new JLabel("Username: ");
        JLabel password = new JLabel("Password: ");
        password.setLabelFor(passwordField);
       
        JComponent buttonPane = createButtonPanel();

        //Lay out everything.
        JPanel textPane = new JPanel(new GridLayout(2,2, 10,10));
        textPane.add(user);
        textPane.add(username);
        textPane.add(password);
        textPane.add(passwordField);

       //f.setLocationByPlatform(true);
        ff.add(textPane, BorderLayout.NORTH);
        ff.add(buttonPane, BorderLayout.CENTER);
    	ff.setLocationRelativeTo(null);  // Posizionamento al centro della finestra
    }


	protected JComponent createButtonPanel() {
    	
        JPanel p = new JPanel(new FlowLayout());
        JButton okButton = new JButton(new LoginAuthenticationCommand(this));
        okButton.setMaximumSize(new Dimension(10,10));
        JButton helpButton = new JButton(new LoginCancelAuthenticationCommand(this));
        helpButton.setMaximumSize(new Dimension(10,10));

        okButton.setActionCommand(OK);
        helpButton.setActionCommand(HELP);

        p.add(okButton);
        p.add(helpButton);

        return p;
    }

    

	public static boolean isLogin() {
		return Login;
	}

	public static void setLogin(boolean login) {
		Login = login;
	}
	
	 public JFrame getFf() {
			return ff;
		}

		public void setFf(JFrame ff) {
			this.ff = ff;
		}
		
		 public JTextField getUsername() {
				return username;
			}

			public void setUsername(JTextField username) {
				this.username = username;
			}
			
			public JPasswordField getPasswordField() {
				return passwordField;
			}


			public void setPasswordField(JPasswordField passwordField) {
				this.passwordField = passwordField;
			}
			public JFrame getControllingFrame() {
				return controllingFrame;
			}


			public void setControllingFrame(JFrame controllingFrame) {
				this.controllingFrame = controllingFrame;
			}
}
