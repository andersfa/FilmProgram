package gui;

import javax.swing.UIManager;

public class Run {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			System.err.println("Error setting look and feel: " + e.getMessage());
		}
		new MainFrame().setVisible(true);
	}
}
