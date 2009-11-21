package gui;

import javax.swing.ImageIcon;

public class ImageHandler {

	private static ImageHandler instance;
	private ImageIcon dvd, bd, vhs;
	
	private ImageHandler(){	}
	
	public static ImageHandler getInstance(){
		if(instance == null)
			instance = new ImageHandler();
		return instance;
	}
	
	public ImageIcon getDvdImage(){
		if(bd == null)
			bd = new ImageIcon("src/dvd.png");
		return bd;
	}
	
	public ImageIcon getBdImage(){
		if(dvd == null)
			dvd = new ImageIcon("src/bd.png");
		return dvd;
	}
	
	public ImageIcon getVhsImage(){
		if(vhs == null)
			vhs = new ImageIcon("src/vhs.png");
		return vhs;
	}
	
}
