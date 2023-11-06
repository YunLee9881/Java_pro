package classPackage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.concurrent.TimeUnit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.DropMode;
import javax.swing.JSplitPane;
import javax.swing.JSpinner;
import javax.swing.JTree;
import javax.swing.JTable;
import net.miginfocom.swing.MigLayout;
import javax.swing.JDesktopPane;

public class GameMain extends JFrame {

	public JFrame frmTamagochiProject;
	public int weight = 12;
	public String playerName = "¹è°íÆÄ";
	public JTextField NAME;
	public JTextField Weight;
	public JTextField nameField;
	public JTextField weightField;
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
	private JPanel mainPanel;
	private JTextField txtVDamagochi;

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
		
		frmTamagochiProject = new JFrame();
		frmTamagochiProject.setTitle("Tamagochi Project");
		frmTamagochiProject.setBounds(100, 100, 1024, 768);
		frmTamagochiProject.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel gamePanel = new JPanel();
		frmTamagochiProject.getContentPane().add(gamePanel, BorderLayout.CENTER);
		gamePanel.setLayout(null);

		IconImage = new JLabel("");
		IconImage.setBounds(64, 24, 128, 128);
		IconImage.setHorizontalAlignment(SwingConstants.CENTER);
		IconImage.setIcon(new ImageIcon(GameMain.class.getResource("/classPackage/img/characterBabyFormIcon.png")));
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

		weightField = new JTextField();
		weightField.setBounds(318, 93, 120, 33);
		weightField.setHorizontalAlignment(SwingConstants.CENTER);
		weightField.setFont(new Font("ÇÑÄÄ ¸»¶û¸»¶û Bold", Font.BOLD, 18));
		weightField.setText(weight+"kg");
		weightField.setEditable(false);
		weightField.setColumns(10);
		gamePanel.add(weightField);

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
		CharacterImage.setIcon(new ImageIcon(GameMain.class.getResource("/classPackage/img/characterBabyForm.png")));
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
					if(HungerGuage.getValue() == 100) {
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
						new ImageIcon(GameMain.class.getResource("/classPackage/img/characterBabyFormHappy.png")));
				int n = LikeGuage.getValue();
				LikeGuage.setValue(++n);
				new SSDamButtonThread().start();
			}
		});
		SSDAMButton.setFont(new Font("HY¿±¼­M", Font.BOLD, 25));
		gamePanel.add(SSDAMButton);
		
		mainPanel = new JPanel();
		mainPanel.setBounds(0, 0, 102, 712);
		frmTamagochiProject.getContentPane().add(mainPanel, BorderLayout.SOUTH);
		mainPanel.setBackground(UIManager.getColor("Button.background"));
		mainPanel.setLayout(null);
		
		txtVDamagochi = new JTextField();
		txtVDamagochi.setFont(new Font("HYÇìµå¶óÀÎM", Font.BOLD, 52));
		txtVDamagochi.setText("V - Damagochi");
		txtVDamagochi.setHorizontalAlignment(SwingConstants.CENTER);
		txtVDamagochi.setBounds(212, 100, 600, 200);
		mainPanel.add(txtVDamagochi);
		txtVDamagochi.setColumns(10);
		
		JButton btnNewButton = new JButton("\uC2DC\uC791");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				gamePanel.Con
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

		
		st.start();
	}
}

class SystemThread extends Thread {
	// ¹Ýº¹ÇÒ ½Ã°£
	int time = 7777;

	// °ÔÀÌÁö ÇöÀç°ª º¯¼ö
	int curLike;
	int curHung;

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
	int time = 500;

	public void run() {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
		}

		GameMain.FeedButton.setEnabled(true);
	}
}

class SSDamButtonThread extends Thread {
	int time = 3000;
	
	@Override
	public void run() {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {}
		GameMain.CharacterImage.setIcon(new ImageIcon(GameMain.class.getResource("/classPackage/img/characterBabyForm.png")));
	}
}