package gui;

import java.awt.Color;
import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import core.BD;
import core.DVD;
import core.Medie;
import core.VHS;


public class movieListRenderer extends JLabel implements ListCellRenderer{

	private static final long serialVersionUID = 1L;
	private ImageHandler imgHandler;

	public movieListRenderer(ImageHandler imgHandler) {
		setOpaque(true);
		this.imgHandler = imgHandler;
	}

	public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {


		try{
			if(value.getClass().getSimpleName().equals("DVD")){
				Medie m = (DVD) value;
				ImageIcon img = imgHandler.getDvdImage();
				setIcon(img);
				setText("<html> <table width=\"525\"><tr><td>Titel: " + m.getTitle() +
						"<br>" + 
						"Type: Digital Video Disc" +
						"</td>" +
						"<td align=\"right\">" + m.getPlayTimeToString() + ":Spilletid" +
						"<br>" +
						":Kategori" +
						"</td></tr></table>"
						+ "</html>");
			}
			else if (value.getClass().getSimpleName().equals("BD")){
				Medie m = (BD) value;
				ImageIcon img = imgHandler.getBdImage();
				setIcon(img);
				setText("<html> <table width=\"525\"><tr><td>Titel: " + m.getTitle() +
						"<br>" + 
						"Type: Blue Ray Disc" +
						"</td>" +
						"<td align=\"right\">" + m.getPlayTimeToString() + ":Spilletid" +
						"<br>" +
						":Kategori" +
						"</td></tr></table>"
						+ "</html>");
			}
			else if (value.getClass().getSimpleName().equals("VHS")){
				VHS m = (VHS) value;
				ImageIcon img = imgHandler.getVhsImage();
				setIcon(img);
				setText("<html> <table width=\"525\"><tr><td>Titel: " + m.getTitle() +
						"<br>" + 
						"Type: VHS" +
						"</td>" +
						"<td align=\"right\">" + m.getPlayTimeToString() + ":Spilletid" +
						"<br>" +
						":Kategori" +
						"</td></tr></table>"
						+ "</html>");
			}






			indstil(list, index, isSelected, cellHasFocus);
			return this;
		}catch (Exception e) {
			indstil(list, index, isSelected, cellHasFocus);
			setText(value.toString());
			return this;
		}







	}

	private void indstil(JList list, int index, boolean isSelected, boolean cellHasFocus){
		Color background;
		Color foreground;

		// check if this cell represents the current DnD drop location
		JList.DropLocation dropLocation = list.getDropLocation();
		if (dropLocation != null
				&& !dropLocation.isInsert()
				&& dropLocation.getIndex() == index) {
			
			background = Color.BLUE;
			foreground = Color.WHITE;

			// check if this cell is selected
		} else if (isSelected) {
			background = new Color(100,100,100);
			foreground = Color.WHITE;

			// unselected, and not the DnD drop location
		} else {
			if(index%2 == 0){
				background = Color.WHITE;
				foreground = Color.BLACK;
			}
			else{
				background = new Color(240,240,240);
				foreground = Color.BLACK;
			}
		};

		setBackground(background);
		setForeground(foreground);
		this.setSize(list.getWidth(), 32);
	}

}
