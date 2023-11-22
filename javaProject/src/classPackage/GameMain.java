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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class GameMain extends JFrame {

	public JFrame frmTamagochiProject;

	static public double weight = 4;
	static public int level = 0;

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

	static public JLabel poopLabel;

	static public JTextField weightField;

	static JPanel inputPanel;
	static JPanel mainPanel;
	static JPanel gameOverPanel;
	static JPanel gamePanel;

	static public JButton GameExit;
	static public JLabel YouKillChar;
	static public JLabel TxTGameOver;

	static public String poopAddress = "/obejectImg/poop.png";

	static public String[][] charArray = {
			// I Index 0. baby, 1. child, 2. Fat
			// J Index 0. default, 1. sleep, 2. happy, 3. Icon
			{ "/BabyImg/characterBabyForm.png", "/BabyImg/characterBabyFormSleep.png",
					"/BabyImg/characterBabyFormHappy.png", "/BabyImg/characterBabyFormIcon.png" },
			{ "/ChildImg/characterChildForm.png", "/ChildImg/characterChildFormSleep.png",
					"/ChildImg/characterChildFormHappy.png", "/ChildImg/characterChildFormIcon.png" },
			{ "/FatImg/characterFatForm.png", "/FatImg/characterFatFormSleep.png", "/FatImg/characterFatFormHappy.png",
					"/FatImg/characterFatFormIcon.png" } };
	private JPanel loadPanel;
	private JTextField warning;
	private JLabel charImage;
	private JTextField beforeCharInputText;
	private JTextField beforeNameInput;
	private JButton beforeNameCheak;
	private JLabel label;
	
	
	//sql code
	static String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:XE";
    static String driver = "oracle.jdbc.driver.OracleDriver";
    static String user = "lsm";
    static String password = "1234";


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
		
		//sql

		 try {
	            // JDBC µå¶óÀÌ¹ö ·Îµå
	            Class.forName(driver);
	            System.out.println("Oracle µå¶óÀÌ¹ö ¼º°ø");

	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        }

		frmTamagochiProject = new JFrame();
		frmTamagochiProject.setResizable(false);
		frmTamagochiProject.setTitle("Tamagochi Project");
		frmTamagochiProject.setBounds(700, 450, 1024, 768);
		frmTamagochiProject.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		mainPanel = new JPanel();
		frmTamagochiProject.getContentPane().add(mainPanel, BorderLayout.CENTER);
		mainPanel.setBounds(0, 0, 1024, 768);
		mainPanel.setBackground(SystemColor.menu);
		mainPanel.setLayout(null);

		txtVTamagochi = new JTextField();
		txtVTamagochi.setBackground(Color.WHITE);
		txtVTamagochi.setEditable(false);
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
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainPanel.setVisible(false);
				loadPanel.setVisible(true);
			}
		});
		button.setFont(new Font("ÈÞ¸Õ¸ðÀ½T", Font.BOLD, 22));
		button.setBounds(387, 486, 250, 50);
		mainPanel.add(button);

		JButton exit = new JButton("\uC885\uB8CC");
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		exit.setFont(new Font("ÈÞ¸Õ¸ðÀ½T", Font.BOLD, 22));
		exit.setBounds(387, 572, 250, 50);
		mainPanel.add(exit);

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
		lblNewLabel.setIcon(new ImageIcon(GameMain.class.getResource(charArray[level][3])));
		lblNewLabel.setBounds(17, 209, 234, 300);
		inputPanel.add(lblNewLabel);

		textField = new JTextField();
		textField.setEditable(false);
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
		
		label = new JLabel("");
		label.setIcon(new ImageIcon(GameMain.class.getResource("/objectImg/charEvolution.png")));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(128, 500, 768, 192);
		inputPanel.add(label);

		JButton nameCheckButton = new JButton("\uD655\uC778");
		nameCheckButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				inputPanel.setVisible(false);
				playerName = nameInput.getText();
				Connection connection = null;
				try {
					connection = DriverManager.getConnection(jdbcUrl, user, password);
				} catch (SQLException e2) {
				}
				try {
					insertData(connection, playerName);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
				
				nameField.setText(playerName);
				gamePanel.setVisible(true);
				SystemThread st = new SystemThread();
			}
		});
		nameCheckButton.setFont(new Font("±¼¸²", Font.BOLD, 24));
		nameCheckButton.setBounds(778, 366, 93, 93);
		inputPanel.add(nameCheckButton);

		loadPanel = new JPanel();
		frmTamagochiProject.getContentPane().add(loadPanel, BorderLayout.CENTER);
		loadPanel.setLayout(null);
		
		warning = new JTextField();
		warning.setText("\u203B\uC815\uD655\uD558\uAC8C \uC801\uC5B4\uC8FC\uC138\uC694!");
		warning.setHorizontalAlignment(SwingConstants.CENTER);
		warning.setForeground(Color.RED);
		warning.setFont(new Font("±¼¸²", Font.BOLD, 18));
		warning.setEditable(false);
		warning.setColumns(0);
		warning.setBackground(Color.WHITE);
		warning.setBounds(268, 454, 600, 35);
		loadPanel.add(warning);
		
		charImage = new JLabel("");
		charImage.setIcon(new ImageIcon(GameMain.class.getResource("/BabyImg/characterBabyFormIcon.png")));
		charImage.setHorizontalAlignment(SwingConstants.CENTER);
		charImage.setBounds(17, 209, 234, 300);
		loadPanel.add(charImage);
		
		beforeCharInputText = new JTextField();
		beforeCharInputText.setText("\uC804\uC5D0 \uD50C\uB808\uC774\uD558\uB358 \uCE90\uB9AD\uD130\uC758 \uC774\uB984\uC744 \uC785\uB825\uD574\uC8FC\uC138\uC694!");
		beforeCharInputText.setHorizontalAlignment(SwingConstants.CENTER);
		beforeCharInputText.setFont(new Font("±¼¸²", Font.BOLD, 24));
		beforeCharInputText.setEditable(false);
		beforeCharInputText.setColumns(10);
		beforeCharInputText.setBounds(268, 271, 600, 93);
		loadPanel.add(beforeCharInputText);
		
		beforeNameInput = new JTextField();
		beforeNameInput.setHorizontalAlignment(SwingConstants.CENTER);
		beforeNameInput.setFont(new Font("±¼¸²", Font.BOLD, 32));
		beforeNameInput.setColumns(10);
		beforeNameInput.setBounds(268, 366, 512, 93);
		loadPanel.add(beforeNameInput);
		
		beforeNameCheak = new JButton("\uD655\uC778");
		beforeNameCheak.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection connection = null;
				
				
				
				loadPanel.setVisible(false);
				playerName = beforeNameInput.getText();
				
				try {
					connection = DriverManager.getConnection(jdbcUrl, user, password);
				} catch (SQLException e3) {
				}
				try {
					
					selectData(connection , beforeNameInput.getText());
				} catch (SQLException e1) {
				}
				nameField.setText(playerName);
				gamePanel.setVisible(true);
				SystemThread st = new SystemThread();
			}
		});
		beforeNameCheak.setFont(new Font("±¼¸²", Font.BOLD, 24));
		beforeNameCheak.setBounds(778, 366, 93, 93);
		loadPanel.add(beforeNameCheak);

		
		
		gamePanel = new JPanel();
		frmTamagochiProject.getContentPane().add(gamePanel, BorderLayout.CENTER);
		gamePanel.setLayout(null);

		weightField = new JTextField();
		weightField.setEditable(false);
		weightField.setFont(new Font("ÇÑÄÄ ¸»¶û¸»¶û Bold", Font.BOLD, 18));
		weightField.setColumns(10);
		weightField.setText(String.format("%.2f", GameMain.weight) + "kg");
		weightField.setHorizontalAlignment(SwingConstants.CENTER);
		weightField.setBounds(318, 93, 120, 33);
		gamePanel.add(weightField);

		IconImage = new JLabel("");
		IconImage.setIcon(new ImageIcon(GameMain.class.getResource(charArray[level][3])));
		IconImage.setBounds(64, 24, 128, 128);
		IconImage.setHorizontalAlignment(SwingConstants.CENTER);
		gamePanel.add(IconImage);

		NAME = new JTextField();
		NAME.setBounds(202, 60, 116, 33);
		NAME.setHorizontalAlignment(SwingConstants.CENTER);
		NAME.setBackground(Color.WHITE);
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
		LikeGuage.setBackground(Color.WHITE);
		LikeGuage.setFont(new Font("ÈÞ¸Õ¸ðÀ½T", Font.BOLD, 18));
		LikeGuage.setForeground(Color.RED);
		LikeGuage.setStringPainted(true);
		LikeGuage.setValue(36);
		gamePanel.add(LikeGuage);

		Weight = new JTextField();
		Weight.setBounds(202, 93, 116, 33);
		Weight.setHorizontalAlignment(SwingConstants.CENTER);
		Weight.setBackground(Color.WHITE);
		Weight.setEditable(false);
		Weight.setFont(new Font("±¼¸²", Font.BOLD, 18));
		Weight.setText("\uBAB8\uBB34\uAC8C :");
		gamePanel.add(Weight);
		Weight.setColumns(10);

		Hunger = new JTextField();
		Hunger.setBackground(Color.WHITE);
		Hunger.setBounds(472, 93, 145, 33);
		Hunger.setText("\uD3EC\uB9CC\uAC10 : ");
		Hunger.setFont(new Font("±¼¸²", Font.BOLD, 18));
		Hunger.setHorizontalAlignment(SwingConstants.CENTER);
		gamePanel.add(Hunger);
		Hunger.setColumns(10);

		HungerGuage = new JProgressBar();
		HungerGuage.setBounds(632, 93, 300, 33);
		HungerGuage.setFont(new Font("ÈÞ¸Õ¸ðÀ½T", Font.BOLD, 18));
		HungerGuage.setBackground(Color.WHITE);
		HungerGuage.setForeground(new Color(102, 51, 51));
		HungerGuage.setStringPainted(true);
		HungerGuage.setValue(40);
		gamePanel.add(HungerGuage);

		CharacterImage = new JLabel("");
		CharacterImage.setIcon(new ImageIcon(GameMain.class.getResource(charArray[level][3])));
		CharacterImage.setBounds(43, 163, 916, 350);
		CharacterImage.setLabelFor(CharacterImage);
		CharacterImage.setBackground(Color.WHITE);
		CharacterImage.setHorizontalAlignment(SwingConstants.CENTER);
		CharacterImage.setToolTipText("");
		CharacterImage.setForeground(Color.WHITE);
		gamePanel.add(CharacterImage);

		SleepBUtton = new JButton("\uC7AC\uC6B0\uAE30");
		SleepBUtton.setBounds(50, 550, 160, 130);
		SleepBUtton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new SleepThread();
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
					new FeedButtonThread();

					FeedButton.setEnabled(false);
				}
			}
		});
		FeedButton.setFont(new Font("HY¿±¼­M", Font.BOLD, 25));
		gamePanel.add(FeedButton);

		CleanButton = new JButton("\uCCAD\uC18C\uD558\uAE30");
		CleanButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (poopProduce.isPoop) {
					poopLabel.setVisible(false);
					int n = LikeGuage.getValue();
					n += 10;
					LikeGuage.setValue(n);
					poopProduce.isPoop = false;
				}
			}
		});
		CleanButton.setBounds(605, 550, 160, 130);
		CleanButton.setFont(new Font("HY¿±¼­M", Font.BOLD, 25));
		gamePanel.add(CleanButton);

		InformButton = new JButton("\uC800\uC7A5");
		InformButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection connection = null;
				try {
					connection = DriverManager.getConnection(jdbcUrl, user, password);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					updateData(connection, playerName);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		InformButton.setBounds(790, 550, 160, 130);
		InformButton.setFont(new Font("HY¿±¼­M", Font.BOLD, 25));
		gamePanel.add(InformButton);

		SSDAMButton = new JButton("\uC4F0\uB2E4\uB4EC\uAE30");
		SSDAMButton.setBounds(235, 550, 160, 130);
		SSDAMButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				new SSDamButtonThread();
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

		

		poopLabel = new JLabel("");
		poopLabel.setHorizontalAlignment(SwingConstants.CENTER);
		poopLabel.setBounds(577, 360, 64, 70);
		gamePanel.add(poopLabel);
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
		loadPanel.setVisible(false);
		gamePanel.setVisible(false);
		gameOverPanel.setVisible(false);
		
		
		mainPanel.setBounds(0, 0, 1024, 768);
		inputPanel.setBounds(0, 0, 1024, 768);
		loadPanel.setBounds(0, 0, 1024, 768);
		gamePanel.setBounds(0, 0, 1024, 768);
		gameOverPanel.setBounds(0, 0, 1024, 768);
		
		Check check = new Check();
		new levelUp();
		new poopProduce();
	}
	
	
	public static void createTable(Connection connection) throws SQLException {
        // Statement °´Ã¼ »ý¼º
        try (Statement statement = connection.createStatement()) {
            // Å×ÀÌºí Á¸Àç È®ÀÎ Äõ¸®
            ResultSet tables = connection.getMetaData().getTables(null, null, "playerData", null);
            if (!tables.next()) {
                // Å×ÀÌºí »ý¼º Äõ¸®
                String createTableSQL = "CREATE TABLE playerData (" +
                        "name VARCHAR2(50)," +
                        "love NUMBER," +
                        "weight NUMBER)";

                // Å×ÀÌºí »ý¼º
                statement.execute(createTableSQL);
                System.out.println("Table 'playerData' created successfully");
            } else {
                System.out.println("Table 'playerData' already exists. No need to create a new table.");
            }
        }
    }
    
    // µ¥ÀÌÅÍ »ðÀÔ ¸Þ¼­µå
    public static void insertData(Connection connection, String targetName) throws SQLException {
        // INSERT Äõ¸®
        String insertSQL = "INSERT INTO playerData (name, love, weight) VALUES (?, ?, ?)";

        // PreparedStatement °´Ã¼ »ý¼º
        try (PreparedStatement insertStatement = connection.prepareStatement(insertSQL)) {
            // µ¥ÀÌÅÍ »ðÀÔ
            insertStatement.setString(1, targetName);
            insertStatement.setInt(2, GameMain.LikeGuage.getValue());
            insertStatement.setDouble(3, GameMain.weight);
            insertStatement.executeUpdate();
            System.out.println("Data inserted successfully");
        }
    }
    
    // µ¥ÀÌÅÍ ¾÷µ¥ÀÌÆ® ¸Þ¼­µå
    public static void updateData(Connection connection, String targetName) throws SQLException {
        // UPDATE Äõ¸®
        String updateSQL = "UPDATE playerData SET love = ?, weight = ? WHERE name = ?";

        // PreparedStatement °´Ã¼ »ý¼º
        try (PreparedStatement updateStatement = connection.prepareStatement(updateSQL)) {
            // µ¥ÀÌÅÍ ¾÷µ¥ÀÌÆ®
            updateStatement.setInt(1, LikeGuage.getValue());
            updateStatement.setDouble(2, weight);
            updateStatement.setString(3, targetName);
            updateStatement.executeUpdate();
            System.out.println("Data updated successfully");
        }
    }
    
    // µ¥ÀÌÅÍ Á¶È¸ ¸Þ¼­µå
    public static void selectData(Connection connection, String targetName) throws SQLException {
        // µ¥ÀÌÅÍ Á¶È¸ Äõ¸®
        String selectSQL = "SELECT * FROM playerData WHERE name = ?";

        // PreparedStatement °´Ã¼ »ý¼º
        try (PreparedStatement selectStatement = connection.prepareStatement(selectSQL)) {
            // Äõ¸® ½ÇÇà
            selectStatement.setString(1, targetName);
            ResultSet rs = selectStatement.executeQuery();

            // °á°ú Ãâ·Â
            while (rs.next()) {
                String name = rs.getString("name");
                GameMain.LikeGuage.setValue( rs.getInt("love"));
                System.out.println(rs.getDouble("weight"));
                GameMain.weight = rs.getDouble("weight");
                GameMain.weightField.setText(String.format("%.1f", GameMain.weight) + "kg");
                
                new levelUp();
            }
            
        }
    }
}

class SystemThread extends Thread {
	// ¹Ýº¹ÇÒ ½Ã°£
	int time = 6666;

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
	int time = 600;

	public FeedButtonThread() {
		start();
	}

	public void run() {
		GameMain.weight = GameMain.weight + 0.2;

		GameMain.weightField.setText(String.format("%.1f", GameMain.weight) + "kg");
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
		}
		GameMain.FeedButton.setEnabled(true);

		new levelUp();
	}
}

class SSDamButtonThread extends Thread {
	int time = 600;

	public SSDamButtonThread() {
		start();
	}

	@Override
	public void run() {

		int n = GameMain.LikeGuage.getValue();
		GameMain.LikeGuage.setValue(++n);

		GameMain.CharacterImage
				.setIcon(new ImageIcon(GameMain.class.getResource(GameMain.charArray[GameMain.level][2])));
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			System.out.println("???");
		}
		GameMain.CharacterImage
				.setIcon(new ImageIcon(GameMain.class.getResource(GameMain.charArray[GameMain.level][0])));
	}
}

class Check extends Thread {
	static boolean Check = false;

	Check() {
		start();
	}

	@Override
	public void run() {
		while (true) {
			if (GameMain.HungerGuage.getValue() <= 0 || GameMain.LikeGuage.getValue() <= 0) {
				System.out.print("¾Æ´Ï");
				GameMain.YouKillChar.setText("´ç½ÅÀÌ " + GameMain.playerName + "À»(¸¦) Á×¿´¾î!!!!!!!!!");
				GameMain.gamePanel.setVisible(false);
				GameMain.gameOverPanel.setVisible(true);
			}
		}
	}

}

class levelUp extends Thread {

	levelUp() {
		start();
	}

	@Override
	public void run() {
		if (((int) GameMain.weight >= 4 && (int) GameMain.weight < 8))
			GameMain.level = 0;
		else if (((int) GameMain.weight >= 8 && (int) GameMain.weight < 15))
			GameMain.level = 1;
		else if ((int) GameMain.weight >= 15)
			GameMain.level = 2;

		if (GameMain.CharacterImage != null)
			GameMain.CharacterImage
					.setIcon(new ImageIcon(GameMain.class.getResource(GameMain.charArray[GameMain.level][0])));

		GameMain.IconImage.setIcon(new ImageIcon(GameMain.class.getResource(GameMain.charArray[GameMain.level][3])));

	}
}

class poopProduce extends Thread {
	int coolTime;// poop coolTime
	static boolean isPoop;

	poopProduce() {
		start();
	}

	@Override
	public void run() {
		GameMain.poopLabel.setIcon(new ImageIcon(GameMain.class.getResource("/objectImg/poop.png")));
		GameMain.poopLabel.setVisible(false);
		while (true) {
			coolTime = (int) (Math.random() * 15000) + 15000;
			System.out.println("??");
			try {
				Thread.sleep(coolTime);
			} catch (InterruptedException e) {
			}
			if (!isPoop) {
				GameMain.poopLabel.setVisible(true);
				isPoop = true;
			}
		}
	}
}

class SleepThread extends Thread{
	int time = 1000;
	
	SleepThread(){
		start();
	}
	
	public void run() {
		GameMain.SleepBUtton.setEnabled(false);
		GameMain.FeedButton.setEnabled(false);
		GameMain.SSDAMButton.setEnabled(false);
		GameMain.CharacterImage
		.setIcon(new ImageIcon(GameMain.class.getResource(GameMain.charArray[GameMain.level][1])));
		for (int i = 0; i < 5; i++) {
			try {
				Thread.sleep(time);
				int Hv = GameMain.HungerGuage.getValue();
				Hv -= 3;
				GameMain.HungerGuage.setValue(Hv);
				int Lv = GameMain.LikeGuage.getValue();
				Lv += 2;
				GameMain.LikeGuage.setValue(Lv);
			} catch (InterruptedException e) {
			}
			
		}
		
		GameMain.SleepBUtton.setEnabled(true);
		GameMain.FeedButton.setEnabled(true);
		GameMain.SSDAMButton.setEnabled(true);
		GameMain.CharacterImage
		.setIcon(new ImageIcon(GameMain.class.getResource(GameMain.charArray[GameMain.level][0])));
	}
}

class poopCheak extends Thread {
	int time = 5000;

	@Override
	public void run() {
		while(true) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
		}
		if (poopProduce.isPoop == true) {
			int n = GameMain.LikeGuage.getValue();
			n -= 10;
			GameMain.LikeGuage.setValue(n);
		}
		}
	}

}

