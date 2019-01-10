package nanaitabeRur;

import java.awt.*;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.border.*;

import java.awt.event.*;

class RouletteP extends JPanel{
	
	public RouletteP() {
		JPanel rouletteP = new JPanel();   //Size of roulette
		rouletteP.setSize(500, 500);
		JLabel rouletteLabel = new JLabel("Roulette", JLabel.CENTER);
		/*ImageIcon ruoletteImg = new ImageIcon("path of roulettimg");  //ruolette Image
		rouletteLabel.setIcon(ruoleteImg);*/
		rouletteLabel.setOpaque(true);
		rouletteLabel.setForeground(Color.BLUE);
		rouletteLabel.setBackground(Color.BLUE);
		rouletteP.add(rouletteLabel);
		add(rouletteP);
		setVisible(true);
	}
}

class ButtonP extends JPanel{
	public ButtonP() {
	JPanel buttonP = new JPanel();
	buttonP.setSize(500, 478);
	
	JButton startB = new JButton("·ê·¿ START");
	startB.setSize(200, 200);
	startB.setForeground(Color.GREEN);
	buttonP.add(startB);
	add(buttonP);
	setVisible(true);
	}
}
public class Roulette extends JFrame{
	private static final int OVARALL_SIZE_WHITDH = 550;
	private static final int OVARALL_SIZE_HEIGTH = 978;
	
	public Roulette() {
		RouletteP rp = new RouletteP();
		ButtonP bp = new ButtonP();
		setSize(OVARALL_SIZE_WHITDH ,OVARALL_SIZE_HEIGTH );  //Size of screen
		JPanel viewP = new JPanel();
		viewP.setLayout(new BorderLayout());
		viewP.setSize(OVARALL_SIZE_WHITDH, OVARALL_SIZE_HEIGTH);
		viewP.add(rp, BorderLayout.NORTH);
		viewP.add(bp, BorderLayout.SOUTH);
		add(viewP);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Roulette rou = new Roulette();
	
	}

}
