package com.kh.game.model.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ResultPanel extends JPanel{
	
	private GamePanel gp;
	private JPanel ResultPanel; 
	
	public ResultPanel(GamePanel gp) {
		this.gp = gp;
		this.ResultPanel = this;
		
		this.setSize(400, 400);
		this.setLocation(0, 0);
		this.setLayout(null);
		this.setBackground(Color.white);
		
		JLabel text = new JLabel("0°³ÀÇ ³¹¸»À» ¸ÂÃè½À´Ï´Ù.");
		text.setSize(400, 50);
		text.setFont(new Font("±¼¸²Ã¼", Font.BOLD, 22));
		text.setLocation(65, 50);
		
		Image image = new ImageIcon("images/cat.PNG").getImage().getScaledInstance(180, 180, 0);
		JLabel resultImage = new JLabel(new ImageIcon(image));
		resultImage.setSize(180, 180);
		resultImage.setLocation(110, 110);
		
		this.add(text);
		this.add(resultImage);
		
		gp.add(ResultPanel);
	}
}
