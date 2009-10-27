package gui;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.ComponentOrientation;
import javax.swing.JScrollPane;
import javax.swing.JList;

import code.BD;
import code.DVD;
import code.Medie;
import code.VHS;
import db.Service;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JToolBar topToolBar = null;
	private JButton newEntryBtn = null;
	private JTextField searchTxf = null;
	private JButton jButton = null;
	private JScrollPane ScrollPane = null;
	private JList movieList = null;
	private Service service = null;
	
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
		this.setPreferredSize(new Dimension(600, 500));
		this.setMinimumSize(new Dimension(600, 500));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(getJContentPane());
		this.setTitle("Film Program");
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
			topToolBar = new JToolBar();
			topToolBar.setFloatable(false);
			topToolBar.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
			topToolBar.add(getNewEntryBtn());
			topToolBar.add(getSearchTxf());
			topToolBar.add(getJButton());
		}
		return topToolBar;
	}

	/**
	 * This method initializes newEntryBtn	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getNewEntryBtn() {
		if (newEntryBtn == null) {
			newEntryBtn = new JButton();
			newEntryBtn.setText("New Entry");
		}
		return newEntryBtn;
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
		}
		return searchTxf;
	}

	/**
	 * This method initializes jButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton() {
		if (jButton == null) {
			jButton = new JButton();
			jButton.setText("asdadasd");
		}
		return jButton;
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
			movieList.setCellRenderer(new movieListRenderer());
			movieList.setListData(service.getList().toArray());
		}
		return movieList;
	}

}
