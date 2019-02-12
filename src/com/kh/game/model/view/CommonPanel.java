package com.kh.game.model.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

//공통적으로 생성하는 부분
public class CommonPanel extends JPanel implements ActionListener{
	
	private MainFrame mf;
	private Player p;
	
	public CommonPanel(MainFrame mf, Player p) {
		this.mf = mf;
		this.p = p;
	} //end constr

	public MainFrame getMf() {
		return mf;
	}

	public void setMf(MainFrame mf) {
		this.mf = mf;
	}

	public Player getP() {
		return p;
	}

	public void setP(Player p) {
		this.p = p;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

} //end class
