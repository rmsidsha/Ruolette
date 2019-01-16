package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
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
   private final static String ROULETTE_FIVE = "D:\\룰렛 사진\\5번.png";
// 6개짜리 룰렛 경로
   private final static String ROULETTE_SIX = "D:\\룰렛 사진\\6번 룰렛.png";
// 8개 짜리 룰렛 경로
   private final static String ROULETTE_EIGHTH = "D:\\룰렛 사진\\8번 룰렛.png";

   String showRoulette = ROULETTE_FIVE;   // 룰렛화면, 기본은 5개 짜리
// 초기 설정
   public int settingNumber = 5;

   File f;
   BufferedImage bi;
   public boolean rouletteStop = true;   //룰렛판 변경 시 룰렛을 멈춤

   public Roulette() {
      setLayout(null);

      // 전체 패널
      JPanel pMain = new JPanel();   // 메인 패널 변수
      pMain.setSize(550, 978);
      pMain.setPreferredSize(new Dimension(550, 978));
      pMain.setLayout(new BoxLayout(pMain, BoxLayout.Y_AXIS));

      // 룰렛 패널
      JPanel pRoul = new JPanel();   // 룰렛 패널 변수
      pRoul.setSize(500, 400);
      pRoul.setPreferredSize(new Dimension(550, 400));

      JLabel lRoul = new JLabel();   // 룰렛(이미지)을(를) 붙일 변수
      File imageRoulette = new File(ROULETTE_FIVE);
      // 텍스트 패널
      JPanel pText = new JPanel();   // 텍스트 패널
      pText.setSize(500, 250);
      pText.setPreferredSize(new Dimension(550, 250));

      JTextField tField = new JTextField(40);      // 텍스트 필드. 입력 부분
      JButton tBtn = new JButton("입력");         // 입력 후 버튼 누를시 에리어에 추가
      JTextArea tArea = new JTextArea(11, 48);   // 내용을 출력 받을 부분
      JScrollPane sPane = new JScrollPane(tArea); // 스크롤을 추가


      try {   // 처음 시작 메인 화면
         bi = ImageIO.read(imageRoulette);
         lRoul.setIcon(new ImageIcon(bi));
         pRoul.setPreferredSize(new Dimension(500, 400));
      } catch (IOException e) {
         e.printStackTrace();
      }

      pRoul.add(lRoul);
      pMain.add(pRoul);

      pRoul.setBorder(BorderFactory.createTitledBorder("Roulette"));

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
            int time = Math.abs(r.nextInt()) % 10000;
            int count =0;
            JPanel panel = new JPanel();
            JLabel label = new JLabel();
            int rotation = time%360;
            tArea.append(time+" "+rotation+"\n");
            
            
            
               for (int i = 0; i <= time; i+=10) { // i는 돌아가는 속도
              
            	 //while(rouletteStop==true ) {
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
                  sleep(50);

                  } catch (Exception e) {
                     // TODO: handle exception
                     e.printStackTrace();
                  }
                  //System.gc();
               }
               
        // }
               //회전판 5
               if(rotation>=0 && rotation <= 72){  // 1번의 경우
            	   tArea.append("1번이 당첨되었습니다!\n");
            	   tArea.setCaretPosition(tArea.getDocument().getLength());

               }
               else if(rotation>=73 && rotation<=144) { //5번의 경우
            	   tArea.append("5번이 당첨되었습니다!\n");
            	   tArea.setCaretPosition(tArea.getDocument().getLength());
               }
               else if(rotation>=145 && rotation<=216) {  //4번의 경우
            	   tArea.append("4번이 당첨되었습니다!\n");
            	   tArea.setCaretPosition(tArea.getDocument().getLength());;
               }
               else if(rotation>=217 && rotation<=288) {  //4번의 경우
            	   tArea.append("3번이 당첨되었습니다!\n");
            	   tArea.setCaretPosition(tArea.getDocument().getLength());
               }
               else if(rotation>=289 && rotation <=360) {  //5번의 경우
            	   tArea.append("2번이 당첨되었습니다!\n");
            	   tArea.setCaretPosition(tArea.getDocument().getLength());
               }
               
               //회전판 6
               if(rotation>=0 && rotation <= 60)  // 1번의 경우
               {
            	   tArea.append("1번이 당첨되었습니다!\n");
            	   tArea.setCaretPosition(tArea.getDocument().getLength());
               }
               else if(rotation>=61 && rotation<=120) { //6번의 경우
            	   tArea.append("6번이 당첨되었습니다!\n");
            	   tArea.setCaretPosition(tArea.getDocument().getLength());
               }
               else if(rotation>=121 && rotation<=180) {  //5번의 경우
            	   tArea.append("5번이 당첨되었습니다!\n");
            	   tArea.setCaretPosition(tArea.getDocument().getLength());;
               }
               else if(rotation>=181 && rotation<=240) {  //4번의 경우
            	   tArea.append("4번이 당첨되었습니다!\n");
            	   tArea.setCaretPosition(tArea.getDocument().getLength());;
               }
               else if(rotation>=241 && rotation <=300) {  //3번의 경우
            	   tArea.append("3번이 당첨되었습니다!\n");
            	   tArea.setCaretPosition(tArea.getDocument().getLength());;
               }
               else if(rotation>=301 && rotation<=360) {  //2번의 경우
            	   tArea.append("2번이 당첨되었습니다!\n");
            	   tArea.setCaretPosition(tArea.getDocument().getLength());;
               }
               
               //회전판 8
               if(rotation>=0 && rotation <= 45)  // 1번의 경우
               { tArea.append("1번이 당첨되었습니다!\n");
        	   tArea.setCaretPosition(tArea.getDocument().getLength());}
               else if(rotation>=46 && rotation<=90) { //8번의 경우
            	   tArea.append("8번이 당첨되었습니다!\n");
            	   tArea.setCaretPosition(tArea.getDocument().getLength());
               }
               else if(rotation>=91 && rotation<=135) {  //7번의 경우
            	   tArea.append("7번이 당첨되었습니다!\n");
            	   tArea.setCaretPosition(tArea.getDocument().getLength());;
               }
               else if(rotation>=136 && rotation<=180) {  //6번의 경우
            	   tArea.append("6번이 당첨되었습니다!\n");
            	   tArea.setCaretPosition(tArea.getDocument().getLength());;
               }
               else if(rotation>=181 && rotation <=225) {  //5번의 경우
            	   
               }
               else if(rotation>=226 && rotation<=270) {  //4번의 경우
            	   
               }
               else if(rotation>=271 && rotation<=315) {  //3번의 경우
            	   
               }
               else if(rotation>=316 && rotation<=360) {  //2번의 경우
            	   
               }
              /* int radi = 360/settingNumber;
               for(int i = 0 ; i < settingNumber ; i++) {
                  if((rotation >= radi * i) && (rotation < (i + 1))) {
                     tArea.append(i + "번이 당첨되었습니다!\n");
                     tArea.setCaretPosition(tArea.getDocument().getLength());
                  }
               }*/
         }
      }
      
     
      // 회전 버튼 이벤트 처리
      class ActionRotate implements ActionListener {

         @Override
         public void actionPerformed(ActionEvent arg0) {
            if (arg0.getSource() == sBtn) {
               // 사진이 회전하게 만들어 주세요..
               Thread t = new myThread();
               t.start();
               setRouletteStop();
               
            }

         }
      }
      
      sBtn.addActionListener(new ActionRotate());

      pbtn1.add(sBtn);
      pBtn.add(pbtn1);

      // 버튼 패널
      JPanel otherP = new JPanel();

      // 버튼(개수 버튼 1)
      JButton btn1 = new JButton("5개");   // 5분할 된 룰렛
      btn1.setPreferredSize(new Dimension(100, 60));
      otherP.add(btn1);

      // 버튼(개수 버튼 2)
      JButton btn2 = new JButton("6개");   // 6분할 된 룰렛
      btn2.setPreferredSize(new Dimension(100, 60));
      otherP.add(btn2);

      // 버튼(개수 버튼 3)
      JButton btn3 = new JButton("8개");   // 8분할 된 룰렛
      btn3.setPreferredSize(new Dimension(100, 60));
      otherP.add(btn3);
      pBtn.add(otherP);

      pBtn.setBorder(BorderFactory.createTitledBorder("메뉴"));

      // 개수 버튼에 따른 이벤트 처리
      class Action1 implements ActionListener {

         @Override
         public void actionPerformed(ActionEvent arg0) {

            if (arg0.getSource() == btn1) {      // 5 룰렛
               showRoulette = ROULETTE_FIVE;
               settingNumber = 5;
               setRouletteStop();
               
               try {
                  f = new File(ROULETTE_FIVE);
                  bi = ImageIO.read(f);
                  lRoul.setIcon(new ImageIcon(bi));
                  pRoul.setPreferredSize(new Dimension(500, 400));
               } catch (IOException e) {
                  e.printStackTrace();
               }
            } else if (arg0.getSource() == btn2) {   // 6 룰렛
               showRoulette = ROULETTE_SIX;
               settingNumber = 6;
               setRouletteStop();
               try {

                  f = new File(ROULETTE_SIX);
                  bi = ImageIO.read(f);
                  lRoul.setIcon(new ImageIcon(bi));
                  pRoul.setPreferredSize(new Dimension(500, 400));
               } catch (IOException e) {
                  e.printStackTrace();
               }
            } else if (arg0.getSource() == btn3) {   // 8 룰렛
               showRoulette = ROULETTE_EIGHTH;
               settingNumber = 8;
               setRouletteStop();
               try {
                  f = new File(ROULETTE_EIGHTH);
                  bi = ImageIO.read(f);
                  lRoul.setIcon(new ImageIcon(bi));
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

     /* // 텍스트 패널
      JPanel pText = new JPanel();   // 텍스트 패널
      pText.setSize(500, 250);
      pText.setPreferredSize(new Dimension(550, 250));

      JTextField tField = new JTextField(40);      // 텍스트 필드. 입력 부분
      JButton tBtn = new JButton("입력");         // 입력 후 버튼 누를시 에리어에 추가
      JTextArea tArea = new JTextArea(11, 48);   // 내용을 출력 받을 부분
      JScrollPane sPane = new JScrollPane(tArea); // 스크롤을 추가
*/
      // 글 입력에 따른 이벤트 처리
      class Action2 implements ActionListener {
         int actionCnt = 0;

         @Override

         public void actionPerformed(ActionEvent e) {
            if (e.getSource() == tBtn || e.getSource() == tField) {
               String name = tField.getText();
               actionCnt++;
               tArea.append(actionCnt + "번째 메뉴 : " + name + "\n");
               tArea.setCaretPosition(tArea.getDocument().getLength());
               tField.setText("");
            }
         }
      }

      tBtn.addActionListener(new Action2());      // 버튼 누를시 이벤트 처리
     // tField.addActionListener(new Action2());   // 텍스트 바에서 엔터 누를 시 이벤트 처리

      pText.setBorder(BorderFactory.createTitledBorder("메뉴"));

      pText.add(tField);
      pText.add(tBtn);
      pText.add(sPane);
      pMain.add(pText);

      add(pMain);
      setVisible(true);

   }
   public boolean setRouletteStop() {
 	  return !rouletteStop;
   }
}
