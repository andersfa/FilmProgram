package gui;

import java.awt.Color;
import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import code.BD;
import code.DVD;
import code.Medie;
import code.VHS;

public class movieListRenderer extends JLabel implements ListCellRenderer{
	   
		public movieListRenderer() {
	         setOpaque(true);
	    }

		public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
	        
			
			try{
				if(value.getClass().getSimpleName().equals("DVD")){
					Medie m = (DVD) value;
					ImageIcon img = new ImageIcon("src/dvd.png");
					setIcon(img);
					setText("<html> Titel: " + m.getTitel() +
							"<br>" + 
							"Type: Digital Video Disc"
							+ "</html>");
				}
				else if (value.getClass().getSimpleName().equals("BD")){
					Medie m = (BD) value;
					ImageIcon img = new ImageIcon("src/bd.png");
					int width = list.getWidth() - 30;
					setIcon(img);
					setText("<html> <table width=\"" + width + "\"><tr><td>Titel: " + m.getTitel() +
							"<br>" + 
							"Type: Blue Ray Disc" +
							"</td><td align=\"right\">Test</td></tr></table>"
							+ "</html>");
				}
				else if (value.getClass().getSimpleName().equals("VHS")){
					Medie m = (VHS) value;
					ImageIcon img = new ImageIcon("src/vhs.png");
					setIcon(img);
					setText("<html> Titel: " + m.getTitel() +
							"<br>" + 
							"Type: VHS"
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
	             background = Color.BLUE;
	             foreground = Color.WHITE;

	         // unselected, and not the DnD drop location
	         } else {
	             background = Color.WHITE;
	             foreground = Color.BLACK;
	         };

	         setBackground(background);
	         setForeground(foreground);
		}
		
}
