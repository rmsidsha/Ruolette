package nanaitabeRur;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class rouletteTest extends JFrame{
	
	public rouletteTest() {
		setSize(550, 978);
		//setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel all = new JPanel();  //전체 패널 사이즈
		all.setSize(550, 978); 		//룰렛 패널 사이즈
		all.setOpaque(true);
		all.setBackground(Color.GREEN);
		all.setLayout(new BoxLayout(all, BoxLayout.Y_AXIS));
		all.setPreferredSize(new Dimension(550, 978));
		all.setBorder(BorderFactory.createEmptyBorder(10 , 10 , 10 , 10));

		
		JPanel roul = new JPanel(); //룰렛 패널
		roul.setSize(500, 500);     //룰렛 패널 사이즈
		roul.setOpaque(true);
		roul.setBackground(Color.BLUE);
		JLabel roulR = new JLabel();
		ImageIcon iconR = new ImageIcon("C:\\Users\\Administrator\\Desktop\\배경없는 룰렛.png");
		roulR.setIcon(iconR);
		roul.setPreferredSize(new Dimension(500, 500));
		roul.add(roulR);
		all.add(roul);
		
		
		JPanel bt = new JPanel();
		bt.setSize(500, 200);
		bt.setOpaque(true);
		bt.setBackground(Color.PINK);
		bt.setPreferredSize(new Dimension(550, 400));
		JButton bt1 = new JButton("시작");
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
