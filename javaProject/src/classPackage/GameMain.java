package classPackage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JPopupMenu;
import java.awt.Component;
import javax.swing.JList;
import java.awt.Choice;

public class GameMain extends JFrame {
	public JFrame frmTamagochiProject;

	static public double weight = 4;
	static public String playerName = "¹è°íÆÄ";
	public JTextField NAME;
	public JTextField Weight;
	public JTextField nameField;
	public JTextField Like;
	public JTextField Hunger;

	static public JLabel CharacterImage;
	static public JLabel IconImage;

	static public JButton SleepBUtton;
	static public JButton FeedButton;
	static public JButton CleanButton;
	static public JButton InformButton;
	static public JButton SSDAMButton;

	static public JProgressBar HungerGuage;
	static public JProgressBar LikeGuage;

	private JTextField txtVTamagochi;
	private JTextField textField;
	private JTextField nameInput;
	private JTextField textField_1;

	static public JTextField weightField;

	static JPanel inputPanel;
	static JPanel mainPanel;
	static JPanel gameOverPanel;
	static JPanel gamePanel;
	
	static public JButton GameExit;
	static public JLabel YouKillChar;
	static public JLabel TxTGameOver;
	
	static public String[][] charArray = {
			{"/BabyImg/characterBabyForm.png", "/BabyImg/characterBabyFormSleep.png", "/BabyImg/characterBabyFormHappy.png", "/BabyImg/characterBabyFormIcon.png"},
			{"/ChildImg/characterChildForm.png", "/ChildImg/characterChildFormSleep.png", "/ChildImg/characterChildFormHappy.png", "/ChildImg/characterChildFormIcon.png"},
			{},
			
			
	};
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameMain window = new GameMain();
					window.frmTamagochiProject.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GameMain() {

		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		SystemThread st = new SystemThread();
		FeedButtonThread fbt = new FeedButtonThread();
		Cheak cheak = new Cheak();

		frmTamagochiProject = new JFrame();
		frmTamagochiProject.setResizable(false);
		frmTamagochiProject.setTitle("Tamagochi Project");
		frmTamagochiProject.setBounds(700, 450, 1024, 768);
		frmTamagochiProject.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		mainPanel = new JPanel();
		frmTamagochiProject.getContentPane().add(mainPanel, BorderLayout.CENTER);
		mainPanel.setBounds(0, 0, 1024, 768);
		mainPanel.setBackground(UIManager.getColor("Button.background"));
		mainPanel.setLayout(null);

		txtVTamagochi = new JTextField();
		txtVTamagochi.setFont(new Font("HYÇìµå¶óÀÎM", Font.BOLD, 52));
		txtVTamagochi.setText("V - Tamagochi");
		txtVTamagochi.setHorizontalAlignment(SwingConstants.CENTER);
		txtVTamagochi.setBounds(212, 100, 600, 200);
		mainPanel.add(txtVTamagochi);
		txtVTamagochi.setColumns(10);

		JButton btnNewButton = new JButton("\uC2DC\uC791");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainPanel.setVisible(false);
				inputPanel.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("ÈÞ¸Õ¸ðÀ½T", Font.BOLD, 22));
		btnNewButton.setBounds(387, 400, 250, 50);
		mainPanel.add(btnNewButton);

		JButton button = new JButton("\uBD88\uB7EC\uC624\uAE30");
		button.setFont(new Font("ÈÞ¸Õ¸ðÀ½T", Font.BOLD, 22));
		button.setBounds(387, 486, 250, 50);
		mainPanel.add(button);

		JButton button_1 = new JButton("\uC885\uB8CC");
		button_1.setFont(new Font("ÈÞ¸Õ¸ðÀ½T", Font.BOLD, 22));
		button_1.setBounds(387, 572, 250, 50);
		mainPanel.add(button_1);

		inputPanel = new JPanel();
		frmTamagochiProject.getContentPane().add(inputPanel, BorderLayout.CENTER);
		inputPanel.setLayout(null);

		textField_1 = new JTextField();
		textField_1.setFont(new Font("±¼¸²", Font.BOLD, 18));
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setForeground(Color.RED);
		textField_1.setBackground(Color.WHITE);
		textField_1.setColumns(0);
		textField_1.setEditable(false);
		textField_1.setText("\u203B\uB108\uBB34 \uAE38\uAC8C \uC4F0\uC9C0 \uB9D0\uC544\uC8FC\uC138\uC694");
		textField_1.setBounds(268, 454, 600, 35);
		inputPanel.add(textField_1);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(GameMain.class.getResource("/BabyImg/characterBabyForm.png")));
		lblNewLabel.setBounds(17, 209, 234, 300);
		inputPanel.add(lblNewLabel);

		textField = new JTextField();
		textField.setFont(new Font("±¼¸²", Font.BOLD, 32));
		textField.setText("\uCE90\uB9AD\uD130\uC758 \uC774\uB984\uC744 \uC785\uB825\uD574\uC8FC\uC138\uC694!");
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBounds(268, 271, 600, 93);
		inputPanel.add(textField);
		textField.setColumns(10);

		nameInput = new JTextField();
		nameInput.setFont(new Font("±¼¸²", Font.BOLD, 32));
		nameInput.setHorizontalAlignment(SwingConstants.CENTER);
		nameInput.setBounds(268, 366, 512, 93);
		inputPanel.add(nameInput);
		nameInput.setColumns(10);

		JButton nameCheakButton = new JButton("\uD655\uC778");
		nameCheakButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				inputPanel.setVisible(false);
				playerName = nameInput.getText();
				nameField.setText(playerName);
				gamePanel.setVisible(true);
				SystemThread st = new SystemThread();
			}
		});
		nameCheakButton.setFont(new Font("±¼¸²", Font.BOLD, 24));
		nameCheakButton.setBounds(778, 366, 93, 93);
		inputPanel.add(nameCheakButton);

		gamePanel = new JPanel();
		frmTamagochiProject.getContentPane().add(gamePanel, BorderLayout.CENTER);
		gamePanel.setLayout(null);
		
		weightField = new JTextField();
		weightField.setEditable(false);
		weightField.setFont(new Font("ÇÑÄÄ ¸»¶û¸»¶û Bold", Font.BOLD, 18));
		weightField.setColumns(10);
		weightField.setText(String.format("%.2f", GameMain.weight)+"kg");
		weightField.setHorizontalAlignment(SwingConstants.CENTER);
		weightField.setBounds(318, 93, 120, 33);
		gamePanel.add(weightField);

		IconImage = new JLabel("");
		IconImage.setIcon(new ImageIcon(GameMain.class.getResource("/BabyImg/characterBabyFormIcon.png")));
		IconImage.setBounds(64, 24, 128, 128);
		IconImage.setHorizontalAlignment(SwingConstants.CENTER);
		gamePanel.add(IconImage);

		NAME = new JTextField();
		NAME.setBounds(202, 60, 116, 33);
		NAME.setHorizontalAlignment(SwingConstants.CENTER);
		NAME.setBackground(SystemColor.desktop);
		NAME.setEditable(false);
		NAME.setFont(new Font("±¼¸²", Font.BOLD, 18));
		NAME.setText("\uC774\uB984 :");
		gamePanel.add(NAME);
		NAME.setColumns(10);

		nameField = new JTextField();
		nameField.setBounds(318, 60, 120, 33);
		nameField.setHorizontalAlignment(SwingConstants.CENTER);
		nameField.setFont(new Font("ÇÑÄÄ ¸»¶û¸»¶û Bold", Font.BOLD, 18));
		nameField.setText(playerName);
		nameField.setEditable(false);
		gamePanel.add(nameField);
		nameField.setColumns(10);

		Like = new JTextField();
		Like.setBounds(472, 60, 145, 33);
		Like.setFont(new Font("±¼¸²", Font.BOLD, 18));
		Like.setText("\uD638\uAC10\uB3C4 : ");
		Like.setHorizontalAlignment(SwingConstants.CENTER);
		gamePanel.add(Like);
		Like.setColumns(10);

		LikeGuage = new JProgressBar();
		LikeGuage.setBounds(632, 60, 300, 33);
		LikeGuage.setBackground(SystemColor.desktop);
		LikeGuage.setFont(new Font("ÈÞ¸Õ¸ðÀ½T", Font.BOLD, 18));
		LikeGuage.setForeground(Color.RED);
		LikeGuage.setStringPainted(true);
		LikeGuage.setValue(36);
		gamePanel.add(LikeGuage);

		Weight = new JTextField();
		Weight.setBounds(202, 93, 116, 33);
		Weight.setHorizontalAlignment(SwingConstants.CENTER);
		Weight.setBackground(SystemColor.desktop);
		Weight.setEditable(false);
		Weight.setFont(new Font("±¼¸²", Font.BOLD, 18));
		Weight.setText("\uBAB8\uBB34\uAC8C :");
		gamePanel.add(Weight);
		Weight.setColumns(10);

		Hunger = new JTextField();
		Hunger.setBounds(472, 93, 145, 33);
		Hunger.setText("\uD3EC\uB9CC\uAC10 : ");
		Hunger.setFont(new Font("±¼¸²", Font.BOLD, 18));
		Hunger.setHorizontalAlignment(SwingConstants.CENTER);
		gamePanel.add(Hunger);
		Hunger.setColumns(10);

		HungerGuage = new JProgressBar();
		HungerGuage.setBounds(632, 93, 300, 33);
		HungerGuage.setFont(new Font("ÈÞ¸Õ¸ðÀ½T", Font.BOLD, 18));
		HungerGuage.setBackground(SystemColor.desktop);
		HungerGuage.setForeground(new Color(102, 51, 51));
		HungerGuage.setStringPainted(true);
		HungerGuage.setValue(40);
		gamePanel.add(HungerGuage);

		CharacterImage = new JLabel("");
		CharacterImage.setBounds(43, 163, 916, 350);
		CharacterImage.setLabelFor(CharacterImage);
		CharacterImage.setBackground(Color.WHITE);
		CharacterImage.setHorizontalAlignment(SwingConstants.CENTER);
		CharacterImage.setToolTipText("");
		CharacterImage.setForeground(Color.WHITE);
		CharacterImage.setIcon(new ImageIcon(GameMain.class.getResource("/BabyImg/characterBabyForm.png")));
		gamePanel.add(CharacterImage);

		SleepBUtton = new JButton("\uC7AC\uC6B0\uAE30");
		SleepBUtton.setBounds(50, 550, 160, 130);
		SleepBUtton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int Hv = HungerGuage.getValue();
				Hv -= 10;
				HungerGuage.setValue(Hv);
			}
		});
		SleepBUtton.setFont(new Font("HY¿±¼­M", Font.BOLD, 25));
		gamePanel.add(SleepBUtton);

		FeedButton = new JButton("\uBC25\uC8FC\uAE30");
		FeedButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		FeedButton.setBounds(420, 550, 160, 130);
		FeedButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (FeedButton.isEnabled()) {
					int Hv = HungerGuage.getValue();
					Hv += 5;
					HungerGuage.setValue(Hv);
					if (HungerGuage.getValue() == 100) {
						int lv = LikeGuage.getValue();
						lv -= 8;
						LikeGuage.setValue(lv);
					}
					new FeedButtonThread().start();

					FeedButton.setEnabled(false);
				}
			}
		});
		FeedButton.setFont(new Font("HY¿±¼­M", Font.BOLD, 25));
		gamePanel.add(FeedButton);

		CleanButton = new JButton("\uCCAD\uC18C\uD558\uAE30");
		CleanButton.setBounds(605, 550, 160, 130);
		CleanButton.setFont(new Font("HY¿±¼­M", Font.BOLD, 25));
		gamePanel.add(CleanButton);

		InformButton = new JButton("\uC124\uC815");
		InformButton.setBounds(790, 550, 160, 130);
		InformButton.setFont(new Font("HY¿±¼­M", Font.BOLD, 25));
		gamePanel.add(InformButton);

		SSDAMButton = new JButton("\uC4F0\uB2E4\uB4EC\uAE30");
		SSDAMButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		SSDAMButton.setBounds(235, 550, 160, 130);
		SSDAMButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CharacterImage.setIcon(
						new ImageIcon(GameMain.class.getResource("/BabyImg/characterBabyFormHappy.png")));
				int n = LikeGuage.getValue();
				LikeGuage.setValue(++n);
				new SSDamButtonThread().start();
			}
		});
		SSDAMButton.setFont(new Font("HY¿±¼­M", Font.BOLD, 25));
		gamePanel.add(SSDAMButton);

		gameOverPanel = new JPanel();
		frmTamagochiProject.getContentPane().add(gameOverPanel, BorderLayout.CENTER);
		gameOverPanel.setLayout(null);

		GameExit = new JButton("\uAC8C\uC784\uC885\uB8CC");
		GameExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});

		GameExit.setBackground(Color.LIGHT_GRAY);
		GameExit.setFont(new Font("±¼¸²", Font.BOLD, 32));
		GameExit.setBounds(362, 435, 300, 150);
		gameOverPanel.add(GameExit);

		mainPanel.setBounds(0, 0, 1024, 768);
		inputPanel.setBounds(0, 0, 1024, 768);
		gamePanel.setBounds(0, 0, 1024, 768);
		gameOverPanel.setBounds(0, 0, 1024, 768);
		
		TxTGameOver = new JLabel("GameOver");
		TxTGameOver.setForeground(Color.RED);
		TxTGameOver.setFont(new Font("Segoe Print", Font.BOLD, 98));
		TxTGameOver.setHorizontalAlignment(SwingConstants.CENTER);
		TxTGameOver.setBounds(17, 132, 982, 209);
		gameOverPanel.add(TxTGameOver);
		
		YouKillChar = new JLabel();
		YouKillChar.setHorizontalAlignment(SwingConstants.CENTER);
		YouKillChar.setForeground(Color.RED);
		YouKillChar.setFont(new Font("±¼¸²", Font.PLAIN, 32));
		YouKillChar.setBounds(205, 342, 582, 95);
		gameOverPanel.add(YouKillChar);

		mainPanel.setVisible(true);
		inputPanel.setVisible(false);
		gamePanel.setVisible(false);
		gameOverPanel.setVisible(false);

		new Cheak();
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}

class SystemThread extends Thread {
	// ¹Ýº¹ÇÒ ½Ã°£
	int time = 333;

	// °ÔÀÌÁö ÇöÀç°ª º¯¼ö
	int curLike;
	int curHung;

	public SystemThread() {
		start();
	}

	public void run() {
		while (true) {

			try {
				Thread.sleep(time);
			} catch (InterruptedException e) {
			}
			curHung = GameMain.HungerGuage.getValue();
			curHung -= 3;
			GameMain.HungerGuage.setValue(curHung);

		}
	}
}

class FeedButtonThread extends Thread {
	int time = 1600;
	public void run() {
		GameMain.weight = GameMain.weight +  0.2;
		
		GameMain.weightField.setText(String.format("%.1f", GameMain.weight)+"kg");
		System.out.println(GameMain.weight);
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
		}
		GameMain.FeedButton.setEnabled(true);
	}
}

class SSDamButtonThread extends Thread {
	int time = 600;

	@Override
	public void run() {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
		}
		GameMain.CharacterImage
				.setIcon(new ImageIcon(GameMain.class.getResource("/BabyImg/characterBabyForm.png")));
	}
}

class Cheak extends Thread {
	static boolean cheak = false;

	Cheak() {
		start();
	}

	@Override
	public void run() {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
		}
		while (true) {
			cheak = true;
			if (GameMain.HungerGuage.getValue() <= 0) {
				GameMain.YouKillChar.setText("´ç½ÅÀÌ " + GameMain.playerName + "À»(¸¦) Á×¿´¾î!!!!!!!!!");
				GameMain.gamePanel.setVisible(false);

				GameMain.gameOverPanel.setVisible(true);
				try {
					SystemThread.sleep(9999999);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
			System.out.println(GameMain.HungerGuage.getValue());
		}

	}

}