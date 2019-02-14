package com.kh.game.controller;

import java.awt.Color;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import com.kh.game.model.view.ChangePanel;
import com.kh.game.model.view.CommonPanel;
import com.kh.game.model.view.Ending;
import com.kh.game.model.view.MainFrame;
import com.kh.game.model.view.Munjae1;
import com.kh.game.model.view.Munjae2;
import com.kh.game.model.view.Munjae3;
import com.kh.game.model.view.Player;
import com.kh.game.model.view.TimeLimiter;

public class DifferenceSpot extends CommonPanel{
	private JPanel ds = this;
	public static boolean spot1 = false;
	public static boolean spot2 = false;
	public static boolean spot3 = false;
	private JLabel munjae;
	private JLabel result;
	private JLabel life1;
	private JLabel life2;
	private JLabel life3;
	private int [] x;
	private int [] y;
	private int xRange = 40;
	private int yRange = 20;
	private int life = 3;
	private ImageIcon icon = null;
	private JPanel panel2;
	private JPanel timer;
	private JButton button;
	private JButton button2;
	private JButton npc;
	private DifferenceSpot dif = this;

	public DifferenceSpot(MainFrame mf, Player p) {
		super(mf, p);

		CustomMouseAdapter cma = new CustomMouseAdapter();
		timer = new TimeLimiter(60, this);

		//this.p.setStage(3);
		int random = (int)(Math.random()*3)+1;
		if(random == 1) {
			icon = new ImageIcon("codeImg/q1.PNG");
			x = new int [] {231, 163, 120};
			y = new int [] {166, 214, 291};
			panel2 = new Munjae1();

		}else if (random == 2) {
			icon = new ImageIcon("codeImg/q2.PNG");
			x = new int [] {402, 306, 88};
			y = new int [] {107, 160, 247};
			panel2 = new Munjae2();

		}else if (random == 3) {
			icon = new ImageIcon("codeImg/q3.PNG");
			x = new int [] {248, 98, 207};
			y = new int [] {140, 202, 292};
			panel2 = new Munjae3();
		}

		JLabel title = new JLabel("틀린 그림 찾기");
		title.setLocation(390, 10);
		title.setSize(120, 70);

		result = new JLabel("게임 진행중...");
		result.setLocation(400, 500);
		result.setSize(120, 70);

		munjae = new JLabel(icon);
		munjae.setLocation(150, 70);
		munjae.setSize(600, 350);
		munjae.addMouseListener(cma);
		
		ImageIcon life = new ImageIcon("codeImg/life.png");
		
		life1 = new JLabel(life);
		life1.setSize(20,20);
		life1.setLocation(800, 20);
		
		life2 = new JLabel(life);
		life2.setSize(20,20);
		life2.setLocation(825, 20);
		
		life3 = new JLabel(life);
		life3.setSize(20,20);
		life3.setLocation(850, 20);
		
		
		
		JTextPane text = new JTextPane();
		text.setBounds(5, 300, 130, 150);
		text.setVisible(false);
		text.setEditable(false);
		text.setBackground(new Color(100, 150, 100, 100));
		
		StyledDocument doc = text.getStyledDocument(); 
		SimpleAttributeSet center = new SimpleAttributeSet(); 
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER); 
		doc.setParagraphAttributes(0, doc.getLength(), center, false); 
		
		if(random == 1) {
			text.setText("자동완성에 너무 익숙해진거 아닌가?");
		}else if(random == 2) {
			text.setText("try문과 while문을 다시공부해봐");
		}else {
			text.setText("길이를 아는 방법은 여러가지가 있지");
		}

		npc = new JButton("NPC자리");
		npc.setSize(100, 100);
		npc.setLocation(19, 445);
		npc.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == npc) {
					text.setVisible(true);
				}

			}
		});

		button = new JButton("게임 클리어 !!! 다음으로 ");
		button.setSize(200, 40);
		button.setLocation(350, 450);
		button.setVisible(false);
		button.addActionListener(this);

		button2 = new JButton("실패했습니다... 이전으로");
		button2.setSize(200, 40);
		button2.setLocation(350, 450);
		button2.setVisible(false);
		button2.addActionListener(this);

		
		
		this.add(life1);
		this.add(life2);
		this.add(life3);
		this.add(text);
		this.add(timer);
		this.add(panel2);
		this.add(npc);
		this.setSize(900, 600);
		this.setLayout(null);
		this.setBackground(Color.gray);
		this.add(title);
		this.add(result);
		this.add(munjae);
		this.add(button);
		this.add(button2);

		mf.add(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		super.getMf().getContentPane().removeAll();
		if(e.getSource() == button) { //성공했을 때 대화화면으로 넘어가기
			/*GameSave save = new GameSave();
			save.save(dif.p, dif);*/
			ChangePanel.changePanel(super.getMf(), ds, 
					new Ending(super.getMf(), super.getP()));
		}
		if(e.getSource() == button2) { //실패했을 때 대화화면으로 넘어가기
			/*GameSave save = new GameSave();
			save.save(dif.p, dif);*/
			/*ChangePanel.changePanel(mf, ds, 
					new Talk3(mf, dif.p));*/
			new GameManager(super.getMf(), 3, false, super.getP(), this);
		}
	} //end method



	public boolean range(int index, Point p) {

		int pointX = p.x;
		int pointY = p.y;

		return (pointX >=x[index]-xRange) && (pointX <=x[index]+xRange)
				&& (pointY >=y[index]-yRange) && (pointY <=y[index]+yRange);
	}




	class CustomMouseAdapter extends MouseAdapter{

		@Override
		public void mouseClicked(MouseEvent e) {
			Point p = e.getPoint();

			if(range(0,p)) {
				DifferenceSpot.spot1 = true;
				munjae.repaint();
				result.setText("정답입니다!!");
			} else if(range(1,p)) {
				DifferenceSpot.spot2 = true;
				munjae.repaint();
				result.setText("정답입니다!!");
			}else if(range(2,p)) {
				DifferenceSpot.spot3 = true;
				munjae.repaint();
				result.setText("정답입니다!!");
			}else {
				File file = new File("C:\\Users\\user2\\git\\KH_TrainGame_0213\\직박구리\\sound_button_wrong.wav");
				try {
					AudioInputStream beep = AudioSystem.getAudioInputStream(file);
					Clip clip = AudioSystem.getClip();
					clip.open(beep);
					clip.start();
				} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
					e1.printStackTrace();
				}
				life--;
				if(life == 2) {
					life1.setVisible(false);
				}else if(life == 1) {
					life2.setVisible(false);
				}else if(life == 0) {
					life3.setVisible(false);
				}
			}

			if(spot1 == true && spot2 == true && spot3 == true) {
				button.setVisible(true);
			}
			if(life == 0) {
				button2.setVisible(true);
				munjae.setVisible(false);
			}


		}
		@Override
		public void mousePressed(MouseEvent e) {
			System.out.println("X : " + e.getX() + " Y : " + e.getY());
		}

	}

	public JButton getButton2() {
		return button2;
	}
	
	public int getLife() {
		return life;
	}
	
	public JLabel getMunjae() {
		return munjae;
	}

}
























