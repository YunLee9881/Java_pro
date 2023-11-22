
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class test extends JFrame implements ActionListener {
	public test() {
	}

	ImageIcon wrongImage = new ImageIcon(Main.class.getResource("../images/G0LzpZno.gif"));
	ImageIcon correctImage = new ImageIcon(Main.class.getResource("../images/oKDZ47SC.gif"));
	ImageIcon testImage = new ImageIcon(Main.class.getResource("../images/shrekMain.jpg"));
	ImageIcon emptyImage = new ImageIcon(Main.class.getResource("../images/empty.png"));
	private Image background = new ImageIcon(Main.class.getResource("../images/003.png")).getImage();

	String name;
	private String bogi[][];
	private String moonge[];
	private JButton bu1, bu2, bu3, bu4;
	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	JPanel panel3 = new JPanel();
	JPanel panel = new JPanel();
	JPanel user = new JPanel();
	JPanel panellow;
	JLabel label1;
	JLabel label2;
	JLabel label3;
	JLabel label4;
	JLabel label0;

	private JLabel label = new JLabel(emptyImage);
	int status[] = {0, 0, 0, 0};
	int g;
	boolean flag;

	public test(int genre) {
		try {
			this.bogi = database.get_Database(genre);
			this.moonge = database.get_moonje_Database(genre);
		} catch (Exception e) {
			e.printStackTrace();
		}
		g = genre;

		resetText(status[genre]);

		Font font = new Font("휴먼엑스포", Font.BOLD, 60);

		String btext[] = new String[5];
		String moonjetext[] = new String[1];
		moonjetext[0] = moonge[status[genre]];
		for (int i = 0; i < bogi[0].length; i++) {
			btext[i] = bogi[status[2]][i];
		}

		bu1 = new JButton(btext[0]);
		bu2 = new JButton(btext[1]);
		bu3 = new JButton(btext[2]);
		bu4 = new JButton(btext[3]);
		bu1.addActionListener(this);
		bu2.addActionListener(this);
		bu3.addActionListener(this);
		bu4.addActionListener(this);

		panel.add(new JLabel(testImage));
		panel.setLayout(new BorderLayout());

		panel2.add(bu1);
		panel2.add(bu2);
		panel2.add(bu3);
		panel2.add(bu4);
		panel3.add(label);
		panel3.removeAll();

		panellow = new JPanel();
		label0 = new JLabel(moonjetext[0]);

		label0.setText(moonjetext[0]);
		Font labelFont = label0.getFont();
		label0.setFont(new Font(labelFont.getName(), Font.PLAIN, 60));
		label1 = new JLabel("현재 퀴즈 번호 : " + Integer.toString(Main.Now_QuizNum) + "번");
		label2 = new JLabel("현재 점수 : " + Integer.toString(Main.Game_Score) + "점");
		label3 = new JLabel("남은 퀴즈 : " + Integer.toString(Main.Remain_Question) + "개");
		label4 = new JLabel("남은 기회 : " + Integer.toString(Main.Life_Remain) + "개");
		panellow.setLayout(new GridLayout(0, 1));
		panellow.add(label0);
		panellow.add(label2);
		panellow.add(label1);
		panellow.add(label3);
		panellow.add(label4);
		panel.add(panel2, BorderLayout.CENTER);
		panel.add(panel3, BorderLayout.SOUTH);
		panel.add(panellow, BorderLayout.NORTH);

		setContentPane(new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
			}
		});

		getContentPane().add(panel);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Quiz Game: Page 4- Quiz Challenge");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		JButton d = (JButton) e.getSource();

		int su = Integer.parseInt("" + d.getText().charAt(0));
		int ans = Integer.parseInt(bogi[status[g]][4]);

		if (su == ans) {
			status[g]++;
			Main.Remain_Question--;
			Main.Now_QuizNum = status[g] + 1;

			correctAnswer();

			try {
				Thread.sleep(300);
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}

			if (status[g] > 9) {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
				dispose();
				getContentPane().add(new gameEnding(1));
			}

			resetText(status[g]);
		} else if (su != ans) {
			wrongAnswer();
			if (Main.Life_Remain <= 0) {
				end_Game(0);
			}
		}

		label1.setText("현재 퀴즈 번호 : " + Integer.toString(Main.Now_QuizNum) + "번");
		label2.setText("현재 점수 : " + Integer.toString(Main.Game_Score) + "점");
		label3.setText("남은 퀴즈 : " + Integer.toString(Main.Remain_Question) + "개");
		label4.setText("남은 기회 : " + Integer.toString(Main.Life_Remain) + "개");
	}

	void wrongAnswer() {
		Main.Life_Remain--;
		Main.Game_Score -= 2;
		panel3.removeAll();
		label = new JLabel(wrongImage);
		panel3.add(label);
		setVisible(true);
	}

	void correctAnswer() {
		Main.Game_Score += 10;
		panel3.removeAll();
		label = new JLabel(correctImage);
		panel3.add(label);
		setVisible(true);
	}

	void end_Game(int x) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		dispose();
		getContentPane().add(new gameEnding(x));
	}

	public void screenDraw(Graphics g) {
		super.paint(g);
		g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
	}

	void resetText(int n) {
		try {
			String btext[] = new String[5];
			String moonjetext[] = new String[1];
			moonjetext[0] = moonge[status[g]];

			for (int i = 0; i < bogi[0].length; i++) {
				btext[i] = bogi[status[g]][i];
			}

			bu1.setText(btext[0]);
			bu2.setText(btext[1]);
			bu3.setText(btext[2]);
			bu4.setText(btext[3]);

			label0.setText(moonjetext[0]);
			Font labelFont = label0.getFont();
			label0.setFont(new Font(labelFont.getName(), Font.PLAIN, 60));

			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}