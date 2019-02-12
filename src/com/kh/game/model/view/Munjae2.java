package com.kh.game.model.view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import com.kh.game.controller.DifferenceSpot;


public class Munjae2 extends JPanel{
	
	public Munjae2() {
		this.setLocation(150, 70);
		this.setSize(600, 350);
		
	}
	
	@Override
	public void paint(Graphics g) {
		 
		g.setColor(Color.RED);
		if(DifferenceSpot.spot1 == true) {
			g.drawOval(391, 82, 30, 30);
		}
		if(DifferenceSpot.spot2 == true) {
			g.drawOval(289, 146, 30, 30);
		}
		if(DifferenceSpot.spot3 == true) {
			g.drawOval(73, 234, 30, 30);
		}
		
	}

}












