package com.kh.game.model.view;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.kh.game.controller.GameManager;


public class CrossPanel extends CommonPanel{
	
	private JButton btnNext = new JButton();
	private JPanel SubPanel;
	private CrossPanel cp = this;

	public CrossPanel(MainFrame mf, Player p) {
		super(mf, p);
		this.SubPanel = this;
		
		//this.p.setStage(2);

		this.setSize(900, 600);
		this.setLocation(0, 0);
		this.setBackground(Color.gray);
		this.setLayout(null);

		Image title = new ImageIcon("images/cat.PNG")
				.getImage().getScaledInstance(500, 40, 0);

		JLabel crossword = new JLabel(new ImageIcon(title));
		crossword.setSize(500, 40);
		crossword.setLocation(200, 30);


		this.add(crossword);
		mf.add(this);
		new GamePanel(this, new GameBoard());
	}

	public void setBtnNext(JButton btnNext) { 
		this.btnNext = btnNext;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		/*GameSave save = new GameSave();
		save.save(cp.p, cp);*/
		new GameManager(super.getMf(), 2, true, super.getP(), this);
	} //end method
	
} //end class

