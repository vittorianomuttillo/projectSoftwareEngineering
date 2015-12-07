/*
 * Copyright (c) 1995, 2008, Oracle and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Oracle or the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */ 
package ui.Login;

import ui.Home.*;
import ui.Home.Menu;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;

/* PasswordDemo.java requires no other files. */

public class Login extends JDialog implements ActionListener {
	
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
        //Create everything.
    	username = new JTextField(10);
        passwordField = new JPasswordField(10);
        passwordField.setActionCommand(OK);
        passwordField.addActionListener(this);

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
        JButton okButton = new JButton("OK");
        okButton.setMaximumSize(new Dimension(10,10));
        JButton helpButton = new JButton("Cancel");
        helpButton.setMaximumSize(new Dimension(10,10));

        okButton.setActionCommand(OK);
        helpButton.setActionCommand(HELP);
        okButton.addActionListener(this);
        helpButton.addActionListener(this);

        p.add(okButton);
        p.add(helpButton);

        return p;
    }

    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        if (OK.equals(cmd)) { //Process the password.
        	String userIn = username.getText();
        	// vedere sul db se presente userIn
            char[] passIn = passwordField.getPassword();
            if (isManager(passIn)) {
                //JOptionPane.showMessageDialog(controllingFrame,"Success! You typed the right password.");
                this.setLogin(true);
                ff.dispose();
                Menu.getLogin().setEnabled(false);
                Menu.getLogout().setEnabled(true);
                Home.AggiornaGUI("Manager");
                
            } else if (isAzienda(passIn)) {
                   //JOptionPane.showMessageDialog(controllingFrame,"Success! You typed the right password.");
                    this.setLogin(true);
                    ff.dispose();
                    Menu.getLogin().setEnabled(false);
                    Menu.getLogout().setEnabled(true);
                    Home.AggiornaGUI("Azienda");
                    
            } else if (isConsulente(passIn)) {
                   // JOptionPane.showMessageDialog(controllingFrame,"Success! You typed the right password.");
                    this.setLogin(true);
                    ff.dispose();
                    Menu.getLogin().setEnabled(false);
                    Menu.getLogout().setEnabled(true);
                    Home.AggiornaGUI("Consulente");
                    
            }else{
                JOptionPane.showMessageDialog(controllingFrame,
                    "Invalid password. Try again.",
                    "Error Message",
                    JOptionPane.ERROR_MESSAGE);
            }

            //Zero out the possible password, for security.
            Arrays.fill(passIn, '0');

            passwordField.selectAll();
            resetFocus();
        } else { 
            ff.dispose();
        }
    }

    /**
     * Checks the passed-in array against the correct password.
     * After this method returns, you should invoke eraseArray
     * on the passed-in array.
     */
    private static boolean isPasswordCorrect(char[] input) {
        boolean isCorrect = true;
        char[] correctPassword = {  };

        if (input.length != correctPassword.length) {
            isCorrect = false;
        } else {
            isCorrect = Arrays.equals (input, correctPassword);
        }

        //Zero out the password.
        Arrays.fill(correctPassword,'0');

        return isCorrect;
    }
    
    private static boolean isManager(char[] input) {
        boolean isCorrect = true;
        char[] correctPassword = { 'm', 'a', 'r', 'i', 'o' };

        if (input.length != correctPassword.length) {
            isCorrect = false;
        } else {
            isCorrect = Arrays.equals (input, correctPassword);
        }

        //Zero out the password.
        Arrays.fill(correctPassword,'0');

        return isCorrect;
    }    
    
    private static boolean isConsulente(char[] input) {
        boolean isCorrect = true;
        char[] correctPassword = { 'a', 'r', 'c', 'o' };

        if (input.length != correctPassword.length) {
            isCorrect = false;
        } else {
            isCorrect = Arrays.equals (input, correctPassword);
        }

        //Zero out the password.
        Arrays.fill(correctPassword,'0');

        return isCorrect;
    }  
    
    private static boolean isAzienda(char[] input) {
        boolean isCorrect = true;
        char[] correctPassword = { 'n', 'a', 'n', 'o' };

        if (input.length != correctPassword.length) {
            isCorrect = false;
        } else {
            isCorrect = Arrays.equals (input, correctPassword);
        }

        //Zero out the password.
        Arrays.fill(correctPassword,'0');

        return isCorrect;
    }  

    //Must be called from the event dispatch thread.
    protected void resetFocus() {
        passwordField.requestFocusInWindow();
    }

	public static boolean isLogin() {
		return Login;
	}

	public static void setLogin(boolean login) {
		Login = login;
	}

}
