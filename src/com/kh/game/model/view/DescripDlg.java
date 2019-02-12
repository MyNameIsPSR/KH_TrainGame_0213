package com.kh.game.model.view;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class DescripDlg {
	private Dialog dlg;
	private MainFrame mf; 
	private String title;
	private String description;
	
	public DescripDlg(MainFrame mf, String title, String description) { 
		
		this.mf = mf;
		this.title = title;
		this.description = description;
		
		dlg = new Dialog(mf, title);
		dlg.setBounds(250, 100, 800, 500);
		dlg.setLayout(null);
		
		Image backImg = new ImageIcon("images/DescripDlg.png")
				.getImage()
				.getScaledInstance(800, 500, 0);
		JLabel backLabel = new JLabel(new ImageIcon(backImg));
		backLabel.setBounds(0, 0, 800, 500);
		
		JTextArea descrip = new JTextArea(20, 50);
		JScrollPane scroll = new JScrollPane(descrip,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		descrip.setFont(new Font("Courier", Font.BOLD, 18));
		descrip.append(description); 
		descrip.setEditable(false); 
		descrip.setCaretPosition(descrip.getDocument().getLength());
		scroll.setLocation(100, 120);
		scroll.setSize(600, 300);


		JButton btnDlgClose = new JButton("닫기");
		btnDlgClose.setContentAreaFilled(false);
		btnDlgClose.setForeground(Color.white);
		btnDlgClose.setBounds(630, 430, 70, 30);
		
		btnDlgClose.addActionListener(new ActionListener() { 

			@Override
			public void actionPerformed(ActionEvent e) {
				dlg.dispose(); 
			} //end method
			
		}); //end listener
		
		dlg.add(scroll); 
		dlg.add(btnDlgClose); 
		dlg.add(backLabel);
		
		
		dlg.setVisible(true);
	} //end constr

} //end class
