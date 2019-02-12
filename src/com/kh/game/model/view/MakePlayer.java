package com.kh.game.model.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class MakePlayer extends CommonPanel {
	
	private JPanel makePlayer;
	private String charactName;
	private JButton btnStart;

	public MakePlayer(MainFrame mf, Player p) {

		super(mf, p);
		this.makePlayer = this;

		//패널 설정
		this.setLayout(null);
		this.setBounds(0, 0, 900, 600);

		//배경이미지설정
		JLabel backImg = new JLabel(new ImageIcon
				(new ImageIcon("images/MakePlayer.png")
				.getImage()
				.getScaledInstance(900, 600, 0)));
		backImg.setBounds(0, 0, 900, 600);

		//캐릭터선택
		JLabel characImg = new JLabel
				(new ImageIcon(new ImageIcon("images/남궁소희.jpg")
				.getImage()
				.getScaledInstance(179, 273, 0)));
		characImg.setBounds(150, 150, 179, 273);

		//콤보박스설정
		String[] items = {"남궁소희", "메이슨지현", "앤드류도연",
				"요나세령", "커티스정언", "타냐선아"};
		JComboBox characCB = new JComboBox(items);
		characCB.setBounds(150, 430, 179, 30);


		characCB.addActionListener(new ActionListener() {
			//콤보박스 눌렀을 때

			@Override
			public void actionPerformed(ActionEvent e) {
				JComboBox cb = (JComboBox) e.getSource();

				charactName = (String) cb.getSelectedItem();

				Image img = new ImageIcon("images/" + charactName + ".jpg")
						.getImage()
						.getScaledInstance(179, 273, 0);

				characImg.setIcon(new ImageIcon(img));
			} //end method

		}); //end listener

		//이름입력
		JLabel nameLabel = new JLabel("이름을 입력해 주세요!");
		nameLabel.setFont(new Font("Courier", Font.BOLD, 22));
		nameLabel.setForeground(Color.WHITE); //�۾� ����
		nameLabel.setBounds(400, 100, 300, 200);
		JTextField nameTf = new JTextField(20);
		nameTf.setFont(new Font("Courier", Font.BOLD, 20));
		nameTf.setText("Player1");
		nameTf.selectAll();
		nameTf.setBounds(400, 220, 400, 50);
		//파일 입출력(수정)
		//super.setName(nameTf.getText());

		//버튼 추가
		btnStart = new JButton(" Next > ");
		btnStart.setBounds(650, 280, 150, 50);
		btnStart.addActionListener(this);
		btnStart.setForeground(Color.WHITE);
		btnStart.setFont(new Font("굴림체",Font.BOLD,15));
		btnStart.setContentAreaFilled(false);


		//패널에 추가
		this.add(characImg); 
		this.add(characCB); 
		this.add(nameLabel);
		this.add(nameTf);
		this.add(btnStart);
		this.add(backImg);
		
		//프레임에 추가
		mf.add(this);
	} //end constr
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnStart) {
			//Player��ü ����
			//���� ����� ����!
			/*try(ObjectOutputStream save = new ObjectOutputStream(new FileOutputStream("player.dat"));) {

				save.writeObject(mp.p);
				save.flush();

			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}*/
			ChangePanel.changePanel(super.getMf(), makePlayer, 
					new Prolog(super.getMf(), super.getP()));
		}
	} //end method

} //end class
