package nanaitabeRur;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class rouletteTest extends JFrame{
	
	public rouletteTest() {
		setSize(550, 978);
		//setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel all = new JPanel();  //¿¸√º ∆–≥Œ ªÁ¿Ã¡Ó
		all.setSize(550, 978); 		//∑Í∑ø ∆–≥Œ ªÁ¿Ã¡Ó
		all.setLayout(new BoxLayout(all, BoxLayout.Y_AXIS));
		all.setPreferredSize(new Dimension(550, 978));
		
		JPanel roul = new JPanel(); //∑Í∑ø ∆–≥Œ
		roul.setSize(500, 500);     //∑Í∑ø ∆–≥Œ ªÁ¿Ã¡Ó
		roul.setOpaque(true);
		//roul.setBackground(Color.BLUE);
		all.add(roul);
		
		
		JPanel bt = new JPanel();
		bt.setSize(500, 400);
		bt.setOpaque(true);
		//bt.setBackground(Color.PINK);
		JButton bt1 = new JButton("Ω√¿€");
		bt.add(bt1);
		all.add(bt);
		
		add(all);
		pack();
		setVisible(true);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		rouletteTest rt = new rouletteTest();
	}

}
