package gui;

import javax.swing.JPanel;
import java.awt.Frame;
import javax.swing.JDialog;

import core.Medie;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;

public class MovieDetails extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private Medie medie = null;
	private ImageHandler imgHandler;
	private JLabel lblTitle = null;
	private JLabel lblDirector = null;
	private JLabel lblGenre = null;
	private JLabel lblDescription = null;
	private JLabel lblActors = null;
	private JPanel topPanel = null;
	private JPanel bottomPanel = null;
	private JButton closeButton = null;
	
	/**
	 * @param owner
	 */
	public MovieDetails(Frame owner, Medie m) {
		super(owner);
		medie = m;
		imgHandler = ImageHandler.getInstance();
		initialize();
		setWindowIcon();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(400, 350);
		this.setTitle("Detaljer: "+medie.getTitle());
		this.setContentPane(getJContentPane());
		this.setVisible(true);
		this.setLocationRelativeTo(getParent());
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			lblActors = new JLabel();
			lblActors.setText("Skuespillere");
			lblDescription = new JLabel();
			lblDescription.setText("Beskrivelse");
			lblGenre = new JLabel();
			lblGenre.setText("Genre");
			lblDirector = new JLabel();
			lblDirector.setText("Instruktør");
			lblTitle = new JLabel();
			lblTitle.setText(""+medie.getTitle());
			lblTitle.setFont(new Font("Dialog", Font.BOLD, 18));
			jContentPane = new JPanel();
			jContentPane.setLayout(new BorderLayout());
			jContentPane.add(getTopPanel(), BorderLayout.NORTH);
			jContentPane.add(getBottomPanel(), BorderLayout.SOUTH);
		}
		return jContentPane;
	}

	private void setWindowIcon(){
		if(medie.getClass().getSimpleName().equals("DVD")){
			this.setIconImage(imgHandler.getDvdImage().getImage());
		}
		else if(medie.getClass().getSimpleName().equals("VHS")){
			this.setIconImage(imgHandler.getVhsImage().getImage());
		}
		else if(medie.getClass().getSimpleName().equals("BD")){
			this.setIconImage(imgHandler.getBdImage().getImage());
		}
	}

	/**
	 * This method initializes topPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getTopPanel() {
		if (topPanel == null) {
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
			gridBagConstraints.gridheight = 1;
			gridBagConstraints.gridx = 0;
			gridBagConstraints.gridy = 0;
			gridBagConstraints.weightx = 1.0;
			gridBagConstraints.weighty = 0.0;
			gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			gridBagConstraints1.anchor = GridBagConstraints.WEST;
			gridBagConstraints1.gridx = 0;
			gridBagConstraints1.gridy = 1;
			gridBagConstraints1.weightx = 1.0;
			gridBagConstraints1.weighty = 0.0;
			gridBagConstraints1.fill = GridBagConstraints.HORIZONTAL;
			GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
			gridBagConstraints2.anchor = GridBagConstraints.WEST;
			gridBagConstraints2.gridx = 0;
			gridBagConstraints2.gridy = 3;
			gridBagConstraints2.weightx = 1.0;
			gridBagConstraints2.fill = GridBagConstraints.HORIZONTAL;
			GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
			gridBagConstraints3.anchor = GridBagConstraints.WEST;
			gridBagConstraints3.gridx = 0;
			gridBagConstraints3.gridy = 2;
			gridBagConstraints3.weightx = 1.0;
			gridBagConstraints3.fill = GridBagConstraints.HORIZONTAL;
			GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
			gridBagConstraints4.anchor = GridBagConstraints.WEST;
			gridBagConstraints4.gridx = -1;
			gridBagConstraints4.gridy = 4;
			gridBagConstraints4.weightx = 1.0;
			gridBagConstraints4.weighty = 0.0;
			gridBagConstraints4.fill = GridBagConstraints.HORIZONTAL;
			topPanel = new JPanel();
			topPanel.setLayout(new GridBagLayout());
			topPanel.add(lblActors, gridBagConstraints4);
			topPanel.add(lblDescription, gridBagConstraints3);
			topPanel.add(lblGenre, gridBagConstraints2);
			topPanel.add(lblDirector, gridBagConstraints1);
			topPanel.add(lblTitle, gridBagConstraints);
		}
		return topPanel;
	}

	/**
	 * This method initializes bottomPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getBottomPanel() {
		if (bottomPanel == null) {
			FlowLayout flowLayout = new FlowLayout();
			flowLayout.setAlignment(java.awt.FlowLayout.RIGHT);
			bottomPanel = new JPanel();
			bottomPanel.setLayout(flowLayout);
			bottomPanel.add(getCloseButton(), null);
		}
		return bottomPanel;
	}

	/**
	 * This method initializes closeButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getCloseButton() {
		if (closeButton == null) {
			closeButton = new JButton();
			closeButton.setText("Luk");
		}
		return closeButton;
	}
	
	
}  //  @jve:decl-index=0:visual-constraint="10,10"
