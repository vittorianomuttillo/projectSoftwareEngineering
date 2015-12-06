package ui.home;

import javax.swing.JPanel;

import ui.home.Content;
import ui.home.Menu;

public interface ContentFactory {
	
	public JPanel createTreePanel();
	public JPanel createPanel();
	
}
