package gui;

import java.awt.BorderLayout;
import java.awt.Point;

import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Dimension;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JToolBar;
import javax.swing.JTextField;
import java.awt.ComponentOrientation;
import java.awt.event.MouseEvent;

import javax.swing.JScrollPane;
import javax.swing.JList;

import db.Service;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.FlowLayout;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JToolBar topToolBar = null;
	private JTextField searchTxf = null;
	private JScrollPane ScrollPane = null;
	private JList movieList = null;
	private Service service = null;
	private ImageHandler imageHandler = null;
	private JLabel searchLabel = null;
	private JMenuBar jJMenuBar = null;
	private JMenu fileMenu = null;
	private JMenu editMenu = null;
	private JMenu helpMenu = null;
	private JMenuItem newEntry = null;
	private JMenuItem editEntry = null;
	private JMenuItem about = null;
	private JMenuItem close = null;
	private JMenuItem help = null;
	private JPopupMenu popUpMenu = null;
	private JMenuItem detailsEntry = null;
	private JMenuItem showDetails = null;
	private JPanel bottomPanel = null;
	private JLabel lblNrMovies = null;
	
	/**
	 * This is the default constructor
	 */
	public MainFrame() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.service = Service.getInstance();
		this.imageHandler = ImageHandler.getInstance();
		this.setPreferredSize(new Dimension(600, 500));
		this.setJMenuBar(getJJMenuBar());
		this.setMinimumSize(new Dimension(600, 500));
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(getJContentPane());
		this.setTitle("Film Program");
		this.setIconImage(imageHandler.getDvdImage().getImage());
		this.setLocationRelativeTo(null);
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			BorderLayout borderLayout = new BorderLayout();
			borderLayout.setHgap(2);
			borderLayout.setVgap(2);
			jContentPane = new JPanel();
			jContentPane.setLayout(borderLayout);
			jContentPane.add(getTopToolBar(), BorderLayout.NORTH);
			jContentPane.add(getScrollPane(), BorderLayout.CENTER);
			jContentPane.add(getBottomPanel(), BorderLayout.SOUTH);
		}
		return jContentPane;
	}

	/**
	 * This method initializes topToolBar	
	 * 	
	 * @return javax.swing.JToolBar	
	 */
	private JToolBar getTopToolBar() {
		if (topToolBar == null) {
			searchLabel = new JLabel();
			searchLabel.setText("Søg");
			topToolBar = new JToolBar();
			topToolBar.setFloatable(false);
			topToolBar.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
			topToolBar.add(searchLabel);
			topToolBar.add(getSearchTxf());
		}
		return topToolBar;
	}

	/**
	 * This method initializes searchTxf	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getSearchTxf() {
		if (searchTxf == null) {
			searchTxf = new JTextField();
			searchTxf.setSize(new Dimension(150, 20));
			searchTxf.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent e) {
					movieList.setListData(service.searchMovies(searchTxf.getText()).toArray());
				}
			});
		}
		return searchTxf;
	}

	/**
	 * This method initializes ScrollPane	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getScrollPane() {
		if (ScrollPane == null) {
			ScrollPane = new JScrollPane();
			ScrollPane.setViewportView(getMovieList());
		}
		return ScrollPane;
	}

	/**
	 * This method initializes movieList	
	 * 	
	 * @return javax.swing.JList	
	 */
	private JList getMovieList() {
		if (movieList == null) {
			movieList = new JList();
			movieList.setCellRenderer(new movieListRenderer(imageHandler));
			movieList.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					if(e.getButton() == MouseEvent.BUTTON3){
						movieList.setSelectedIndex(movieList.locationToIndex(e.getPoint()));
						getPopupMenu().show(movieList, e.getX(), e.getY());
					}
					else{
						if(e.getClickCount() == 2){
							new MovieDetails(MainFrame.this, service.getList().get(getMovieList().getSelectedIndex()));
						}
					}
				}
			});
			movieList.setListData(service.getList().toArray());
		}
		return movieList;
	}

	/**
	 * This method initializes jJMenuBar	
	 * 	
	 * @return javax.swing.JMenuBar	
	 */
	private JMenuBar getJJMenuBar() {
		if (jJMenuBar == null) {
			jJMenuBar = new JMenuBar();
			jJMenuBar.add(getFileMenu());
			jJMenuBar.add(getEditMenu());
			jJMenuBar.add(getHelpMenu());
		}
		return jJMenuBar;
	}

	/**
	 * This method initializes fileMenu	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getFileMenu() {
		if (fileMenu == null) {
			fileMenu = new JMenu();
			fileMenu.setText("Filer");
			fileMenu.addSeparator();
			fileMenu.add(getClose());
		}
		return fileMenu;
	}

	/**
	 * This method initializes editMenu	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getEditMenu() {
		if (editMenu == null) {
			editMenu = new JMenu();
			editMenu.setText("Rediger");
			editMenu.add(getNewEntry());
			editMenu.add(getEditEntry());
			editMenu.add(getDetailsEntry());
		}
		return editMenu;
	}

	/**
	 * This method initializes helpMenu	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getHelpMenu() {
		if (helpMenu == null) {
			helpMenu = new JMenu();
			helpMenu.setText("Hjælp");
			helpMenu.add(getHelp());
			helpMenu.add(getAbout());
		}
		return helpMenu;
	}

	/**
	 * This method initializes newEntry	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getNewEntry() {
		if (newEntry == null) {
			newEntry = new JMenuItem();
			newEntry.setText("Ny indtastning");
		}
		return newEntry;
	}

	/**
	 * This method initializes editEntry	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getEditEntry() {
		if (editEntry == null) {
			editEntry = new JMenuItem();
			editEntry.setText("Rediger ting");
		}
		return editEntry;
	}

	/**
	 * This method initializes about	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getAbout() {
		if (about == null) {
			about = new JMenuItem();
			about.setText("About");
		}
		return about;
	}

	/**
	 * This method initializes close	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getClose() {
		if (close == null) {
			close = new JMenuItem();
			close.setText("Luk");
		}
		return close;
	}

	/**
	 * This method initializes help	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getHelp() {
		if (help == null) {
			help = new JMenuItem();
			help.setText("Hjælp");
		}
		return help;
	}
	
	private JPopupMenu getPopupMenu(){
		if(popUpMenu == null){
			popUpMenu = new JPopupMenu();
			popUpMenu.add(getShowDetails());
		}
		return popUpMenu;
	}

	/**
	 * This method initializes detailsEntry	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getDetailsEntry() {
		if (detailsEntry == null) {
			detailsEntry = new JMenuItem();
			detailsEntry.setText("Vis Detaljer");
		}
		return detailsEntry;
	}

	/**
	 * This method initializes showDetails	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getShowDetails() {
		if (showDetails == null) {
			showDetails = new JMenuItem();
			showDetails.setText("Vis Detaljer");
			showDetails.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					new MovieDetails(MainFrame.this, service.getList().get(getMovieList().getSelectedIndex()));
				}
			});
		}
		return showDetails;
	}

	/**
	 * This method initializes bottomPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getBottomPanel() {
		if (bottomPanel == null) {
			lblNrMovies = new JLabel();
			lblNrMovies.setText("Antal: " + service.getList().size());
			bottomPanel = new JPanel();
			bottomPanel.setLayout(new FlowLayout());
			bottomPanel.add(lblNrMovies, null);
		}
		return bottomPanel;
	}

}
