package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.invoke.SwitchPoint;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Roulette extends JPanel {
   // 5개 짜리 룰렛 경로
   private final static String ROULETTE_FIVE = "D:\\img\\5th.png";
   // 6개짜리 룰렛 경로
   private final static String ROULETTE_SIX = "D:\\img\\6th.png";
   // 8개 짜리 룰렛 경로
   private final static String ROULETTE_EIGHTH = "D:\\img\\8th.png";
   // 룰렛화면, 기본은 5개 짜리
   String showRoulette = ROULETTE_FIVE;

   static int settingNumber;
   static int actionCnt = 0;
   int time;
   File f;
   BufferedImage bi1, bi2;
   JTextArea tArea;
   JTextField tField;

   public Roulette() {
      setLayout(null);

      // 전체 패널
      JPanel pMain = new JPanel(); // 메인 패널 변수
      pMain.setSize(550, 978);
      pMain.setPreferredSize(new Dimension(550, 978));
      pMain.setLayout(new BoxLayout(pMain, BoxLayout.Y_AXIS));

      // 룰렛 패널
      JPanel pRoul = new JPanel(); // 룰렛 패널 변수
      pRoul.setSize(500, 400);
      pRoul.setPreferredSize(new Dimension(550, 400));

      JLabel lRoul = new JLabel(); // 룰렛(이미지)을(를) 붙일 변수
      File imageRoulette = new File(ROULETTE_FIVE);

      try { // 처음 시작 메인 화면
         bi1 = ImageIO.read(imageRoulette);
         lRoul.setIcon(new ImageIcon(bi1));
         pRoul.setPreferredSize(new Dimension(500, 400));
      } catch (IOException e) {
         e.printStackTrace();
      }

      JPanel pArrow = new JPanel(); // 룰렛 화살표 패널 변수
      pArrow.setSize(10, 400);
      pArrow.setPreferredSize(new Dimension(10, 400));
      settingNumber = 5; // 초기화로 5

      JLabel lArrow = new JLabel(); // 화살표를 붙일 변수
      File imageArrow = new File("D://img//arrow.png");
      
      try {
         bi2 = ImageIO.read(imageArrow);
         lArrow.setIcon(new ImageIcon(bi2));
         pArrow.setPreferredSize(new Dimension(10, 400));
      } catch (IOException e) {
         e.printStackTrace();
      }

      pRoul.add(lArrow, BorderLayout.NORTH);
      pRoul.add(lRoul, BorderLayout.CENTER);
      pMain.add(pRoul);

      // 룰렛 레이어
      JPanel pBtn = new JPanel(); // 버튼 패널
      pBtn.setLayout(new BoxLayout(pBtn, BoxLayout.Y_AXIS));
      pBtn.setPreferredSize(new Dimension(550, 100));

      // 룰렛 버튼
      JPanel pbtn1 = new JPanel(); // 메인 버튼, 누르면 회전
      JButton sBtn = new JButton("회전");
      sBtn.setPreferredSize(new Dimension(150, 60));

      // 룰렛 돌리 때 이용 할 쓰레드
      class myThread extends Thread {
         public void run() {
            Random r = new Random();
            time = Math.abs(r.nextInt()) % 1000;

            JPanel panel = new JPanel();
            JLabel label = new JLabel();
            int rotation = time % 360;

            for (int i = 0; i <= time; i += 5) { // i는 돌아가는 속도
               try {
                  BufferedImage oldImage = ImageIO.read(new FileInputStream(showRoulette));
                  BufferedImage newImage = new BufferedImage(oldImage.getHeight(), oldImage.getWidth(),
                        oldImage.getType());
                  Graphics2D graphics = (Graphics2D) newImage.getGraphics();
                  graphics.rotate(Math.toRadians(i), newImage.getWidth() / 2, newImage.getHeight() / 2);
                  graphics.translate((newImage.getWidth() - oldImage.getWidth()) / 2,
                        (newImage.getHeight() - oldImage.getHeight()) / 2);
                  graphics.drawImage(oldImage, 0, 0, oldImage.getWidth(), oldImage.getHeight(), null);
                  ImageIcon icon = new ImageIcon(newImage);
                  lRoul.setIcon(icon);
               } catch (Exception e) {
                  // TODO: handle exception
                  e.printStackTrace();
               }
            }
            // 회전판 5
            int number = 0;
            switch (settingNumber) {
            case 5:
               if (rotation >= 0 && rotation <= 72) { // 1번의 경우
                  number = 1;
               } else if (rotation >= 73 && rotation <= 144) { // 5번의 경우
                  number = 5;
               } else if (rotation >= 145 && rotation <= 216) { // 4번의 경우
                  number = 4;
               } else if (rotation >= 217 && rotation <= 288) { // 3번의 경우
                  number = 3;
               } else if (rotation >= 289 && rotation <= 360) { // 2번의 경우
                  number = 2;
               }
               break;

            // 회전판 6
            case 6:
               if (rotation >= 0 && rotation <= 60) // 1번의 경우
               {
                  number = 1;
               } else if (rotation >= 61 && rotation <= 120) { // 6번의 경우
                  number = 6;
               } else if (rotation >= 121 && rotation <= 180) { // 5번의 경우
                  number = 5;
               } else if (rotation >= 181 && rotation <= 240) { // 4번의 경우
                  number = 4;
               } else if (rotation >= 241 && rotation <= 300) { // 3번의 경우
                  number = 3;
               } else if (rotation >= 301 && rotation <= 360) { // 2번의 경우
                  number = 2;
               }
               break;

            // 회전판 8
            case 8:
               if (rotation >= 0 && rotation <= 45) { // 1번의 경우
                  number = 1;
               } else if (rotation >= 46 && rotation <= 90) { // 8번의 경우
                  number = 8;
               } else if (rotation >= 91 && rotation <= 135) { // 7번의 경우
                  number = 7;
               } else if (rotation >= 136 && rotation <= 180) { // 6번의 경우
                  number = 6;
               } else if (rotation >= 181 && rotation <= 225) { // 5번의 경우
                  number = 5;
               } else if (rotation >= 226 && rotation <= 270) { // 4번의 경우
                  number = 4;
               } else if (rotation >= 271 && rotation <= 315) { // 3번의 경우
                  number = 3;
               } else if (rotation >= 316 && rotation <= 360) { // 2번의 경우
                  number = 2;
               }
               break;
            }
            tArea.append(number + "번이 당첨되었습니다!\n");
               tArea.setCaretPosition(tArea.getDocument().getLength());
         }
      }

      // 회전 버튼 이벤트 처리
      class ActionRotate implements ActionListener {
         @Override
         public void actionPerformed(ActionEvent arg0) {
            if (arg0.getSource() == sBtn) {
               if (actionCnt >= settingNumber) {
                  Thread t = new myThread();
                  t.start();
               } else if (actionCnt < settingNumber) {
                  tField.setText("메뉴 수가 충족되지 않습니다");
               }
            }
         }
      }

      sBtn.addActionListener(new ActionRotate());

      pbtn1.add(sBtn);
      pBtn.add(pbtn1);

      // 버튼 패널
      JPanel otherP = new JPanel();

      // 버튼(개수 버튼 1)
      JButton btn1 = new JButton("5개"); // 5분할 된 룰렛
      btn1.setPreferredSize(new Dimension(100, 60));
      otherP.add(btn1);

      // 버튼(개수 버튼 2)
      JButton btn2 = new JButton("6개"); // 6분할 된 룰렛
      btn2.setPreferredSize(new Dimension(100, 60));
      otherP.add(btn2);

      // 버튼(개수 버튼 3)
      JButton btn3 = new JButton("8개"); // 8분할 된 룰렛
      btn3.setPreferredSize(new Dimension(100, 60));
      otherP.add(btn3);
      pBtn.add(otherP);

      // 개수 버튼에 따른 이벤트 처리
      class Action1 implements ActionListener {
         @Override
         public void actionPerformed(ActionEvent arg0) {
            actionCnt = 0;
            tArea.setText("");
            tField.setText("");
            if (arg0.getSource() == btn1) { // 5 룰렛
               showRoulette = ROULETTE_FIVE;
               settingNumber = 5;
               try {
                  f = new File(ROULETTE_FIVE);
                  bi1 = ImageIO.read(f);
                  lRoul.setIcon(new ImageIcon(bi1));
                  pRoul.setPreferredSize(new Dimension(500, 400));
               } catch (IOException e) {
                  e.printStackTrace();
               }
            } else if (arg0.getSource() == btn2) { // 6 룰렛
               showRoulette = ROULETTE_SIX;
               settingNumber = 6;
               try {
                  f = new File(ROULETTE_SIX);
                  bi1 = ImageIO.read(f);
                  lRoul.setIcon(new ImageIcon(bi1));
                  pRoul.setPreferredSize(new Dimension(500, 400));
               } catch (IOException e) {
                  e.printStackTrace();
               }
            } else if (arg0.getSource() == btn3) { // 8 룰렛
               showRoulette = ROULETTE_EIGHTH;
               settingNumber = 8;
               try {
                  f = new File(ROULETTE_EIGHTH);
                  bi1 = ImageIO.read(f);
                  lRoul.setIcon(new ImageIcon(bi1));
                  pRoul.setPreferredSize(new Dimension(500, 400));
               } catch (IOException e) {
                  e.printStackTrace();
               }
            }
         }
      }

      btn1.addActionListener(new Action1());
      btn2.addActionListener(new Action1());
      btn3.addActionListener(new Action1());

      pMain.add(pBtn);

      // 텍스트 패널
      JPanel pText = new JPanel(); // 텍스트 패널
      pText.setSize(500, 250);
      pText.setPreferredSize(new Dimension(550, 250));

      tField = new JTextField(35); // 텍스트 필드. 입력 부분
      JButton tBtn1 = new JButton("입력"); // 입력 후 버튼 누를시 에리어에 추가
      JButton tBtn2 = new JButton("초기화"); // 입력 후 버튼 누를시 에리어에 추가
      tArea = new JTextArea(11, 48); // 내용을 출력 받을 부분
      JScrollPane sPane = new JScrollPane(tArea); // 스크롤을 추가

      // 글 입력에 따른 이벤트 처리
      class Action2 implements ActionListener {
         @Override
         public void actionPerformed(ActionEvent e) {
            if (e.getSource() == tBtn1) {
               if (actionCnt < settingNumber) {
                  String name = tField.getText();
                  actionCnt++;
                  tArea.append(actionCnt + "번째 메뉴 : " + name + "\n");
                  tArea.setCaretPosition(tArea.getDocument().getLength());
                  tField.setText("");
               } else {
                  String name = tField.getText();
                  tField.setText("메뉴를 추가할 수 없습니다.");
               }
            }
            if (e.getSource() == tBtn2) {
               actionCnt =0;
               tArea.setText("");
               tField.setText("");
            }
         }
      }

      tBtn1.addActionListener(new Action2()); // 버튼 누를시 이벤트 처리
      tBtn2.addActionListener(new Action2()); // 버튼 누를시 이벤트 처리

      pText.add(tField);
      pText.add(tBtn1);
      pText.add(tBtn2);
      pText.add(sPane);
      pMain.add(pText);

      add(pMain);
      setVisible(true);

   }
}
