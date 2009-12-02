package gui;

import javax.swing.JPanel;
import java.awt.Frame;
import javax.swing.JDialog;

import core.Medie;
import java.awt.GridBagLayout;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.Insets;

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
	private JPanel infoPanel = null;
	private JPanel bottomPanel = null;
	private JButton closeButton = null;
	private JPanel mainPanel = null;
	private JPanel topPanel = null;
	private JLabel lblDirectorText = null;
	private JLabel lblDescriptionText = null;
	private JLabel lblGenreText = null;
	private JLabel lblActorsText = null;
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
		this.setUndecorated(true);
		this.setLocationRelativeTo(getParent());
		this.setVisible(true);
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
			jContentPane.add(getMainPanel(), BorderLayout.CENTER);
			jContentPane.add(getTopPanel(), BorderLayout.NORTH);
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
	 * This method initializes infoPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getInfoPanel() {
		if (infoPanel == null) {
			GridBagConstraints gridBagConstraints31 = new GridBagConstraints();
			gridBagConstraints31.gridx = 9;
			gridBagConstraints31.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints31.insets = new Insets(0, 0, 0, 0);
			gridBagConstraints31.gridy = 4;
			lblActorsText = new JLabel();
			lblActorsText.setText(":  Actors here");
			GridBagConstraints gridBagConstraints21 = new GridBagConstraints();
			gridBagConstraints21.gridx = 9;
			gridBagConstraints21.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints21.insets = new Insets(0, 0, 0, 0);
			gridBagConstraints21.gridy = 3;
			lblGenreText = new JLabel();
			lblGenreText.setText(":  Genre here");
			GridBagConstraints gridBagConstraints11 = new GridBagConstraints();
			gridBagConstraints11.gridx = 9;
			gridBagConstraints11.weightx = 1.0;
			gridBagConstraints11.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints11.insets = new Insets(0, 0, 0, 0);
			gridBagConstraints11.gridy = 2;
			lblDescriptionText = new JLabel();
			lblDescriptionText.setText(":  Description here.");
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.gridx = 9;
			gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints.insets = new Insets(0, 0, 0, 0);
			gridBagConstraints.gridy = 1;
			lblDirectorText = new JLabel();
			lblDirectorText.setText(":  Director here");
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			gridBagConstraints1.anchor = GridBagConstraints.WEST;
			gridBagConstraints1.gridx = 0;
			gridBagConstraints1.gridy = 1;
			gridBagConstraints1.weightx = 0.0;
			gridBagConstraints1.weighty = 0.0;
			gridBagConstraints1.insets = new Insets(0, 3, 0, 0);
			gridBagConstraints1.fill = GridBagConstraints.NONE;
			GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
			gridBagConstraints2.anchor = GridBagConstraints.WEST;
			gridBagConstraints2.gridx = 0;
			gridBagConstraints2.gridy = 3;
			gridBagConstraints2.weightx = 0.0;
			gridBagConstraints2.insets = new Insets(0, 3, 0, 0);
			gridBagConstraints2.fill = GridBagConstraints.NONE;
			GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
			gridBagConstraints3.anchor = GridBagConstraints.WEST;
			gridBagConstraints3.gridx = 0;
			gridBagConstraints3.gridy = 2;
			gridBagConstraints3.weightx = 0.0;
			gridBagConstraints3.insets = new Insets(0, 3, 0, 0);
			gridBagConstraints3.fill = GridBagConstraints.NONE;
			GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
			gridBagConstraints4.anchor = GridBagConstraints.WEST;
			gridBagConstraints4.gridx = -1;
			gridBagConstraints4.gridy = 4;
			gridBagConstraints4.weightx = 0.0;
			gridBagConstraints4.weighty = 0.0;
			gridBagConstraints4.insets = new Insets(0, 3, 0, 0);
			gridBagConstraints4.fill = GridBagConstraints.NONE;
			infoPanel = new JPanel();
			infoPanel.setLayout(new GridBagLayout());
			infoPanel.add(lblActors, gridBagConstraints4);
			infoPanel.add(lblDescription, gridBagConstraints3);
			infoPanel.add(lblGenre, gridBagConstraints2);
			infoPanel.add(lblDirector, gridBagConstraints1);
			infoPanel.add(lblDirectorText, gridBagConstraints);
			infoPanel.add(lblDescriptionText, gridBagConstraints11);
			infoPanel.add(lblGenreText, gridBagConstraints21);
			infoPanel.add(lblActorsText, gridBagConstraints31);
		}
		return infoPanel;
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
			bottomPanel.setBackground(Color.gray);
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
			closeButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					MovieDetails.this.dispose();
				}
			});
		}
		return closeButton;
	}

	/**
	 * This method initializes mainPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getMainPanel() {
		if (mainPanel == null) {
			mainPanel = new JPanel();
			mainPanel.setLayout(new BorderLayout());
			mainPanel.add(getInfoPanel(), BorderLayout.NORTH);
			mainPanel.add(getBottomPanel(), BorderLayout.SOUTH);
		}
		return mainPanel;
	}

	/**
	 * This method initializes topPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getTopPanel() {
		if (topPanel == null) {
			topPanel = new JPanel();
			topPanel.setLayout(new FlowLayout());
			topPanel.setBackground(Color.GRAY);
			topPanel.add(lblTitle, null);
			
		}
		return topPanel;
	}
	
	
}  //  @jve:decl-index=0:visual-constraint="10,10"
