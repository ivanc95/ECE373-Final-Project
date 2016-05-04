package org.gui;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.image.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PrintStream;
import java.text.SimpleDateFormat;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SpinnerModel;

import java.awt.FlowLayout;
import java.awt.Graphics2D;

import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;
import javax.swing.JTextArea;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JToggleButton;
import javax.swing.JSpinner;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import org.classes.Player;
import org.project.gamescreen.City;
import org.project.gamescreen.Country;
import org.project.gamescreen.Game;

import javax.swing.JRadioButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SpinnerNumberModel;

public class mainwindow implements ActionListener {

	private JFrame frame;
	private JTextArea textArea;
	private JLabel lblNewLabel;
	private int cnt = 0;
	private int count = 0;
	private JMenuItem mntmExit;
	private JMenuItem mntmExport;
	private Game g;
	private Country turn;
	private JLabel lblNewLabel_1;
	private JSpinner spinner;
	private JRadioButton rdbtnPopulation, rdbtnResources;
	private JComboBox comboBox_1;
	private JButton btnNewButton;
	private City tba;
	
	private JLabel lM, lN;
	Timer tm = new Timer(5, this);
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainwindow window = new mainwindow();
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
	public mainwindow() {
		initialize();
		
	}

	public mainwindow(Player A, Player B) {
		initialize();
		g = new Game();
		
		City NY = new City(g.c1);
		NY.setName("New York");
		
		City MOS = new City(g.c2);
		MOS.setName("Moscow");
		
		g.assignPlayerUSA(A);
		g.assignPlayerUSSR(B);
		
		turn = g.c1;
		lblNewLabel.setIcon(g.c1.getPlayer().getPicture_path());
		lblNewLabel_1.setText(g.c1.getPlayer().getName());
		comboBox_1.removeAllItems();
		Object[] cs1 = {"Moscow", "Leningrad", "St. Petersburg", "Murmansk", "Vladimir"};
		comboBox_1.setModel(new DefaultComboBoxModel( cs1));
		tba = g.c2.getCityList().get(0);
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		String icon;
		
		frame = new JFrame("Global Thermonuclear War");
		frame.setBounds(100, 100, 1000, 677);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 786, 497);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		
		Image i = new ImageIcon(this.getClass().getResource("/boomla.png")).getImage();
		
		lN = new JLabel("");
		lN.setHorizontalAlignment(SwingConstants.CENTER);
		lN.setBounds(146, 58, 80, 100);
		lN.setIcon(new ImageIcon(i.getScaledInstance(80, 100, Image.SCALE_DEFAULT)));
		panel.add(lN);
		lN.setVisible(false);
		
		lM = new JLabel("");
		lM.setBounds(436, 51, 298, 180);
		lM.setIcon(new ImageIcon(i.getScaledInstance(80, 100, Image.SCALE_DEFAULT)));
		panel.add(lM);
		lM.setVisible(false);
		
		JLabel lblNewLabel_2 = new JLabel("img");
		lblNewLabel_2.setBounds(0, 0, 786, 497);
		Image img = new ImageIcon(this.getClass().getResource("/world_factions.jpg")).getImage();
		lblNewLabel_2.setIcon(new ImageIcon(img));
		panel.add(lblNewLabel_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(806, 11, 168, 313);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(10, 0, 148, 148);
		icon = "blast.png";
		lblNewLabel.setIcon(new ImageIcon("img/"+icon));
		panel_1.add(lblNewLabel);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(10, 159, 46, 14);
		panel_1.add(lblName);
		
		lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(20, 184, 125, 14);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblHighScore = new JLabel("High Score:");
		lblHighScore.setBounds(10, 209, 118, 14);
		panel_1.add(lblHighScore);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(806, 335, 168, 271);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		btnNewButton = new JButton("Launch a Nuke!");
		btnNewButton.addActionListener(new buttonPress());
		btnNewButton.setBounds(10, 248, 148, 23);
		panel_2.add(btnNewButton);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setBounds(10, 67, 148, 20);
		panel_2.add(comboBox_1);
		
		JLabel lblAttacks = new JLabel("You attack");
		lblAttacks.setHorizontalAlignment(SwingConstants.CENTER);
		lblAttacks.setBounds(10, 42, 148, 14);
		panel_2.add(lblAttacks);
		
		spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(0, 0, 0, 1));
		spinner.setBounds(10, 123, 148, 20);
		panel_2.add(spinner);
		
		JLabel lblUsing = new JLabel("using");
		lblUsing.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsing.setBounds(10, 98, 148, 14);
		panel_2.add(lblUsing);
		
		JLabel lblNukesTargeting = new JLabel("nukes. Targeting their");
		lblNukesTargeting.setHorizontalAlignment(SwingConstants.CENTER);
		lblNukesTargeting.setBounds(10, 154, 148, 14);
		panel_2.add(lblNukesTargeting);
		
		rdbtnPopulation = new JRadioButton("Population");
		rdbtnPopulation.setBounds(10, 177, 109, 23);
		panel_2.add(rdbtnPopulation);
		
		rdbtnResources = new JRadioButton("Resources");
		rdbtnResources.setBounds(10, 203, 109, 23);
		panel_2.add(rdbtnResources);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 519, 786, 87);
		frame.getContentPane().add(panel_3);
		
		textArea = new JTextArea();
		
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.TRAILING)
				.addComponent(textArea, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 964, Short.MAX_VALUE)
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addComponent(textArea, GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
		);
		panel_3.setLayout(gl_panel_3);

		panel_3.add(new JScrollPane(textArea));
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmNewGame = new JMenuItem("New Game");
		mnFile.add(mntmNewGame);
		mntmNewGame.addActionListener(new MenuListener());
		
		mntmExport = new JMenuItem("Export");
		mnFile.add(mntmExport);
		mntmExport.addActionListener(new MenuListener());
		
		mntmExit = new JMenuItem("Exit");
		mnFile.add(mntmExit);
		mntmExit.addActionListener(new MenuListener());
		
		JMenu mnPlayer = new JMenu("Player");
		menuBar.add(mnPlayer);
		
		JMenu mnOther = new JMenu("Other");
		menuBar.add(mnOther);
		
		frame.setVisible(true);
	}
	
	private class MenuListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JMenuItem src = (JMenuItem)(e.getSource());
			if(src == mntmExit) {
				if(0 == JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Exit",JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE)) {
					System.exit(0);
				}
				else if(src == mntmExport) {
					String output = textArea.getText();
					textArea.setText("WOW!");
					BufferedWriter writer = null;
			        try {
			            //create a temporary file
			            File logFile = new File("ThermonuclearWarExported");

			            // This will output the full path where the file will be written to...
			            textArea.setText("The file will be exported here:\n\t" + logFile.getCanonicalPath() + "\n"+ output);

			            writer = new BufferedWriter(new FileWriter(logFile));
			            writer.write("Hello world!");
			        } catch (Exception e1) {
			            e1.printStackTrace();
			        } finally {
			            try {
			                // Close the writer regardless of what happens...
			                writer.close();
			            } catch (Exception e1) {
			            }
			        }
				}
			}
		}
	}
	
	private class buttonPress implements ActionListener{
		@SuppressWarnings("deprecation")
		public void actionPerformed(ActionEvent e) {
			int atk;
			
			if(rdbtnPopulation.isSelected() == true && rdbtnResources.isSelected() == false ) {
				atk = 2;
			} else if(rdbtnResources.isSelected() == true  && rdbtnPopulation.isSelected() == false) {
				atk = 1;
			} else {
				atk = 3;
			}
			String output = textArea.getText();
			if(turn.playerTurn(atk, (int)spinner.getValue(), tba)) {
				output = turn.getName() + " is Victorious!\n" + output;
				btnNewButton.setEnabled(false);
			}
			String icon;
			cnt++;
			output = "<Turn #" + Integer.toString(cnt) + " ended> " + turn.getName() +  " ("+ turn.getPlayer().getName() +") has nuked "  + tba.getName() + " using " + (int)spinner.getValue() + " nukes! They have " + turn.getMissiles() + " remaining! : " + tba.getPopulation() + "\n"  + output;
			textArea.setText(output);
			if (cnt % 2 == 0) {
				lblNewLabel.setIcon(g.c1.getPlayer().getPicture_path());
				turn = g.c1;
				tba = g.c2.getCityList().get(0);
				lblNewLabel_1.setText(g.c1.getPlayer().getName());
				comboBox_1.removeAllItems();
				Object[] cs1 = {"Moscow", "Leningrad", "St. Petersburg", "Murmansk", "Vladimir"};
				comboBox_1.setModel(new DefaultComboBoxModel( cs1));
				spinner.setModel(new SpinnerNumberModel(0,0,g.c1.getMissiles(),1));
				lN.setVisible(true);
				lM.setVisible(false);
			}
			else {
				lM.setVisible(false);
				lblNewLabel.setIcon(g.c2.getPlayer().getPicture_path());
				turn = g.c2;
				lblNewLabel_1.setText(g.c2.getPlayer().getName());
				tba = g.c1.getCityList().get(0);
				comboBox_1.removeAllItems();
				Object[] cs2 = {"New York", "Washington DC", "Los Angeles", "Boston", "Phoenix"};
				comboBox_1.setModel(new DefaultComboBoxModel( cs2));
				spinner.setModel(new SpinnerNumberModel(0,0,g.c2.getMissiles(),1));
				g.roundOver();
				lN.setVisible(false);
				lM.setVisible(true);
			}
			
		}
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
