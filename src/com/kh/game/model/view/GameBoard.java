package com.kh.game.model.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GameBoard extends JPanel {
	private JPanel GameBoard;
	JTextField[][] tf;

	public GameBoard() {
		this.GameBoard = this;
		this.setSize(400, 400);
		this.setLocation(0, 0);
		this.setLayout(new GridLayout(10, 10));



		char[][] carr = {
				{' ',' ',' ',' ',' ','n',' ',' ','p',' '},
				{'W','r','a','p','p','e','r',' ','r',' '},
				{' ','e',' ','u',' ','w',' ',' ','i','f'},
				{' ','t',' ','b',' ',' ','p',' ','v',' '},
				{'n','u','l','l',' ','b','r','e','a','k'},
				{' ','r',' ','i',' ',' ','i',' ','t',' '},
				{' ','n',' ','c',' ',' ','n',' ','e',' '},
				{' ',' ','i',' ',' ',' ','t',' ',' ',' '},
				{'l','o','n','g',' ',' ','l',' ',' ',' '},
				{' ',' ','t',' ','l','e','n','g','t','h'},
		};

		int x = 0, y = 0;

		tf = new JTextField[10][10];
		
		for(int i = 0; i < tf.length; i++) {
			x=0;
			for(int j = 0; j < tf[i].length; j++) {
				tf[i][j] = new JTextField();
				tf[i][j].setBounds(x, y, 40, 40);
				x+=40;
				this.add(tf[i][j]);     
			}
			y+=40;
		}

		for(int i = 0; i < carr.length; i++) {
			for(int j = 0; j < carr[i].length; j++) {
				if(carr[i][j] == ' ') {
					tf[i][j].setBackground(Color.BLUE);
					tf[i][j].setEditable(false);
				}else {
					tf[i][j].setDocument(new JTextFieldLimit(1));
					tf[i][j].setHorizontalAlignment(JTextField.CENTER);
					tf[i][j].setFont(new Font("Century Gothic", Font.PLAIN, 16));
					tf[i][j].setBackground(Color.WHITE);
				}
			}
		}
	}
}
