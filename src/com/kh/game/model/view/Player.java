package com.kh.game.model.view;

import java.awt.Image;
import java.io.Serializable;

import javax.swing.ImageIcon;

public class Player implements Serializable{
	private int life;
	private String name;
	private int level = 0;
	
	public Player() {} 
	
	public Player(String name) {
		life = 3;
		this.name = name;
	}
	
	public int getLife() {
		return life;
	}
	
	public void setLife(int life) {
		this.life = life;
	}

	public String getName() {
		return name;
	}

	

	public void setName(String name) {
		this.name = name;
	}


	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}


	
	
	
	
}


















