package ui.Command;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

public class QuitCommand extends AbstractAction{

	private static final long serialVersionUID = 1L;

	public QuitCommand(){
		super("Quit");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		 System.out.println("Quit request");
         quit();
	}

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
        int n = JOptionPane.showOptionDialog( null, 
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

}
