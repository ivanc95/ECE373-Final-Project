package org.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import org.classes.Player;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

public class PlayerSelect {

	private JFrame frame;
	private Player pc_1, pc_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PlayerSelect window = new PlayerSelect();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public PlayerSelect() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().setLayout(null);
		
		//Main Label
		
		JLabel lblPlayerSelection = new JLabel("Player Selection:");
		lblPlayerSelection.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblPlayerSelection.setBounds(10, 11, 223, 29);
		frame.getContentPane().add(lblPlayerSelection);
		
		//Image Icons for use by character creation and display on gamescreen
		
		Image IM1 = new ImageIcon(this.getClass().getResource("/bomb.jpg")).getImage();
		Image IM2 = new ImageIcon(this.getClass().getResource("/blast.png")).getImage();
		Image IM3 = new ImageIcon(this.getClass().getResource("/nuke.png")).getImage();
		Image IM4 = new ImageIcon(this.getClass().getResource("/soviet.png")).getImage();
		Image IM5 = new ImageIcon(this.getClass().getResource("/USA.jpeg")).getImage();
		Image IM6 = new ImageIcon(this.getClass().getResource("/David.png")).getImage();
		
		//Array of images
		
		Object[] possibilities = {new ImageIcon(IM1), new ImageIcon(IM2), new ImageIcon(IM3),new ImageIcon(IM4), new ImageIcon(IM5), new ImageIcon(IM6)};
		
		// the JLabels which the buttons when those buttons are hidden. (for player 1)
		
		JLabel piclbl1 = new JLabel("");
		piclbl1.setBounds(139,93,100,100);
		frame.getContentPane().add(piclbl1);
		JLabel nmlbl1 = new JLabel("D");
		nmlbl1.setHorizontalAlignment(SwingConstants.CENTER);
		nmlbl1.setBounds(139,156,100,100);
		frame.getContentPane().add(nmlbl1);
		piclbl1.setVisible(false);
		nmlbl1.setVisible(false);	
		
		/*
		 * 	Player 1 Load Player:
		 * 		This button randomly generates a player for the user from a
		 * 		predefined list of parameters. It then will create the new player object and
		 * 		hide the player 1 buttons. It will replace them with the
		 * 		player icon and name.
		 */
		
		JButton btnNewPlayer = new JButton("New Player");
		JButton btnLoadAPlayer = new JButton("Load A Player");
		btnLoadAPlayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] Names = {"Nate", "Ivan", "David", "Krystian", "Kyle", "Jonathan", "Fonji", "Marefat"};
				Random R = new Random();
				int index = (int)R.nextInt() % 8;
				int index2 = (int)R.nextInt() % 6;
				if (index < 0) {
					index = -index;
				}
				if (index2 < 0) {
					index2 = -index2;
				}
				pc_1 = new Player(Names[index], (ImageIcon)possibilities[index2]);
				btnNewPlayer.setVisible(false);
				btnLoadAPlayer.setVisible(false);
				piclbl1.setIcon(pc_1.getPicture_path());
				nmlbl1.setText(pc_1.getName());
				piclbl1.setVisible(true);
				nmlbl1.setVisible(true);
			}
		});
		btnLoadAPlayer.setBounds(10, 93, 364, 76);
		frame.getContentPane().add(btnLoadAPlayer);
		
		/*
		 * 	Player 1 Create New Player:
		 * 		This button opens a dialog to allow the user to select his image,
		 * 		then it opens another to input his desired name. If both are
		 * 		are entered, it then will create the new player object and
		 * 		hide the player 1 buttons. It will replace them with the
		 * 		player icon and name.
		 */
		
		btnNewPlayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ImageIcon pic;
				do {
					pic = (ImageIcon)JOptionPane.showInputDialog(
				                    frame,
				                    "Choose your picture!",
				                    "New Player!", JOptionPane.PLAIN_MESSAGE,
				                    null, possibilities,
				                    "ham");
				} while (pic == null);
				JFrame frame2 = new JFrame();
				String name;
				do {
					name = (String) JOptionPane.showInputDialog(frame2, "Enter a name:");
				} while (name == "");
				pc_1 = new Player(name, pic);
				btnNewPlayer.setVisible(false);
				btnLoadAPlayer.setVisible(false);
				piclbl1.setIcon(pc_1.getPicture_path());
				nmlbl1.setText(pc_1.getName());
				piclbl1.setVisible(true);
				nmlbl1.setVisible(true);
			}
		});
		btnNewPlayer.setBounds(10, 180, 364, 76);
		frame.getContentPane().add(btnNewPlayer);
		
		// Player 1 Label:
		
		JLabel lblPlayer = new JLabel("Player 1:");
		lblPlayer.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayer.setBounds(10, 68, 364, 14);
		frame.getContentPane().add(lblPlayer);
		
		JButton button = new JButton("Load A Player");
		button.setBounds(10, 292, 364, 76);
		frame.getContentPane().add(button);
		JButton button_1 = new JButton("New Player");
		button_1.setBounds(10, 379, 364, 76);
		frame.getContentPane().add(button_1);
		
		// the JLabels which the buttons when those buttons are hidden. (for player 2)
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(139, 297, 100, 100);
		frame.getContentPane().add(lblNewLabel);
		JLabel label = new JLabel("");
		label.setBounds(109, 397, 167, 14);
		frame.getContentPane().add(label);
		
		JLabel piclbl2 = new JLabel("");
		piclbl2.setBounds(139,277,100,100);
		frame.getContentPane().add(piclbl1);
		JLabel nmlbl2 = new JLabel("D");
		nmlbl2.setHorizontalAlignment(SwingConstants.CENTER);
		nmlbl2.setBounds(139,387,100,100);
		frame.getContentPane().add(nmlbl1);
		piclbl2.setVisible(false);
		nmlbl2.setVisible(false);	
		label.setHorizontalAlignment(SwingConstants.CENTER);
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] Names = {"Nate", "Ivan", "David", "Krystian", "Kyle", "Jonathan", "Fonji", "Marefat"};
				Random R = new Random();
				int index = (int)R.nextInt() % 8;
				int index2 = (int)R.nextInt() % 6;
				if (index < 0) {
					index = -index;
				}
				if (index2 < 0) {
					index2 = -index2;
				}
				pc_2 = new Player(Names[index], (ImageIcon)possibilities[index2]);
				button_1.setVisible(false);
				button.setVisible(false);
				piclbl2.setIcon(pc_2.getPicture_path());
				nmlbl2.setText(pc_2.getName());
				lblNewLabel.setIcon(pc_2.getPicture_path());
				label.setText(pc_2.getName());
			}
		});
		
		
		
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ImageIcon pic;
				do {
					pic = (ImageIcon)JOptionPane.showInputDialog(
				                    frame,
				                    "Choose your picture!",
				                    "New Player!", JOptionPane.PLAIN_MESSAGE,
				                    null, possibilities,
				                    "ham");
				} while (pic == null);
				JFrame frame2 = new JFrame();
				String name;
				do {
					name = (String) JOptionPane.showInputDialog(frame2, "Enter a name:");
				} while (name == "");
				pc_2 = new Player(name, pic);
				button_1.setVisible(false);
				button.setVisible(false);
				lblNewLabel.setIcon(pc_2.getPicture_path());
				label.setText(pc_2.getName());
			}
		});
		
		//Player 2 Label:
		
		JLabel lblPlayer_1 = new JLabel("Player 2:");
		lblPlayer_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayer_1.setBounds(10, 267, 364, 14);
		frame.getContentPane().add(lblPlayer_1);
		
		
		/*
		 * Okay button:
		 * 	If both players have been created by either means,
		 * 	then the button will hide the playerSelect Screen and launch the 
		 * 	main game window with the created players passed as parameters.
		 */	
		
		JButton btnOk = new JButton("OK");
		btnOk.setBounds(285, 466, 89, 23);
		frame.getContentPane().add(btnOk);
			
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(pc_1 != null && pc_2 != null) {
					frame.setVisible(false);
					mainwindow a = new mainwindow(pc_1, pc_2);
					}
			}
		});
	
		frame.setBackground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 400, 535);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
