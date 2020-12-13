package it.solvingteam.olimpiadi;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Util {

	public static void stampa(String args) {
		JFrame f=new JFrame();
		f.setAlwaysOnTop(true);
		JOptionPane.showMessageDialog(f,args);

	}

}
