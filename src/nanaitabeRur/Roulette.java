package nanaitabeRur;

import java.awt.*;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.border.*;

import java.awt.event.*;

class ruolette extends JPanel{
	
	public ruolette() {
		JPanel ruoletteP = new JPanel();   //Size of ruolette
		ruoletteP.setSize(500, 500);
		JLabel ruoletteLabel = new JLabel("Ruolette", JLabel.CENTER);
		/*ImageIcon ruoletteImg = new ImageIcon("path of roulettimg");  //ruolette Image
		ruoletteLabel.setIcon(ruoleteImg);*/
		ruoletteLabel.setOpaque(true);
		ruoletteLabel.setBackground(Color.BLUE);
		ruoletteP.add(ruoletteLabel);
		setVisible(true);
	}
}

public class Roulette extends JFrame{
	private static final int OVARALL_SIZE_WHITDH = 550;
	private static final int OVARALL_SIZE_HEIGTH = 978;
	
	public Roulette() {
		setSize(OVARALL_SIZE_WHITDH ,OVARALL_SIZE_HEIGTH );  //Size of screen
		JPanel viewP = new JPanel();
		viewP.setSize(OVARALL_SIZE_WHITDH, OVARALL_SIZE_HEIGTH);
		viewP.add(new ruolette(), BorderLayout.NORTH);
		add(viewP);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Roulette ruo = new Roulette();
	
	}

}
