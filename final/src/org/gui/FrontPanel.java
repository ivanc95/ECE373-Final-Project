package org.gui;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

import org.gui.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Label;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import java.awt.Font;

public class FrontPanel extends JPanel implements ActionListener {

	private JFrame frame;
	Timer tm = new Timer(5, this);
	int x = 0, velX = 2;
	
	/**
	 * Launch the application.
	 */
	
	private static final String VOICENAME_kevin = "kevin";
	
	
	public void speak(String text) {
		  Voice voice;
		  VoiceManager voiceManager = VoiceManager.getInstance();
		  voice = voiceManager.getVoice(VOICENAME_kevin);
		  voice.allocate();
		  voice.speak(text);
		 }
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrontPanel window = new FrontPanel();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the application.
	 */
	public FrontPanel() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Image boom = new ImageIcon(this.getClass().getResource("/boomla.png")).getImage();
		Image boom2 = boom.getScaledInstance(100, 100, Image.SCALE_DEFAULT);
		JLabel panel = new JLabel(new ImageIcon(boom2));
		panel.setBounds(0, 180, 206, 196);
		frame.getContentPane().add(panel);	
		 int delay = 100; //milliseconds
		  ActionListener taskPerformer = new ActionListener() {
		      
		      public void actionPerformed(ActionEvent evt) {
		    	  	
		                 //((Timer)evt.getSource()).stop();
		            if((panel.getLocation().x<0) || (panel.getLocation().x>1000)){
		            	panel.setLocation((panel.getLocation().x), panel.getLocation().y+10);
		            }
		            else
		            	panel.setLocation((panel.getLocation().x)+10, panel.getLocation().y);
		      }
		  };
		  new Timer(delay, taskPerformer).start();
		
		
		JButton btnPlay = new JButton("Play");
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PlayerSelect A = new PlayerSelect();
				frame.setVisible(false);
				speak("Shall, we, play, a, game?");
			}
		});
		btnPlay.setBounds(627, 149, 107, 47);
		frame.getContentPane().add(btnPlay);
		
		JButton btnHighScore = new JButton("High Score");
		btnHighScore.setBounds(627, 345, 107, 47);
		frame.getContentPane().add(btnHighScore);
		
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(627, 541, 107, 50);
		frame.getContentPane().add(btnExit);
		
		Image img = new ImageIcon(this.getClass().getResource("/world_factions.jpg")).getImage();
		Image img2 = img.getScaledInstance(2880, 1800, Image.SCALE_DEFAULT);
		JLabel background = new JLabel(new ImageIcon(img2));
		//background.setForeground(new Color(220, 20, 60));
		background.setBounds(0, 0, 1920, 1080);
		frame.getContentPane().add(background);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
