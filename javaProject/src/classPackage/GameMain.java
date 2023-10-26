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

public class GameMain extends JFrame{

	public JFrame frmTamagochiProject;
	public int weight = 13;
	public String name = "ÀÌ¼º¹Î";
	public JTextField NAME;
	public JTextField Weight;
	public JTextField nameField;
	public JTextField weightField;
	public JTextField Like;
	public JTextField Hunger;
	
	static public JProgressBar HungerGuage;
	static public JProgressBar LikeGuage;

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
		frmTamagochiProject = new JFrame();
		frmTamagochiProject.setTitle("Tamagochi Project");
		frmTamagochiProject.setBounds(100, 100, 903, 777);
		frmTamagochiProject.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frmTamagochiProject.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("15px"),
				FormSpecs.DEFAULT_COLSPEC,
				ColumnSpec.decode("54px:grow"),
				ColumnSpec.decode("10px"),
				ColumnSpec.decode("2px:grow"),
				ColumnSpec.decode("5px:grow"),
				ColumnSpec.decode("10px"),
				ColumnSpec.decode("24px"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("40px:grow"),
				ColumnSpec.decode("15px"),
				ColumnSpec.decode("54px:grow"),
				ColumnSpec.decode("10px"),
				ColumnSpec.decode("54px:grow"),
				FormSpecs.DEFAULT_COLSPEC,
				ColumnSpec.decode("15px"),},
			new RowSpec[] {
				RowSpec.decode("default:grow"),
				RowSpec.decode("4dlu:grow"),
				RowSpec.decode("23px:grow"),
				RowSpec.decode("default:grow"),
				RowSpec.decode("4dlu:grow"),
				RowSpec.decode("4dlu:grow"),
				RowSpec.decode("4dlu:grow"),
				RowSpec.decode("8dlu"),
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("192px:grow"),
				RowSpec.decode("58px:grow"),
				RowSpec.decode("4dlu:grow"),
				RowSpec.decode("default:grow"),
				RowSpec.decode("4dlu:grow"),
				RowSpec.decode("default:grow"),
				RowSpec.decode("4dlu:grow"),
				RowSpec.decode("default:grow"),
				RowSpec.decode("4dlu:grow"),
				RowSpec.decode("default:grow"),
				RowSpec.decode("4dlu:grow"),
				RowSpec.decode("default:grow"),
				RowSpec.decode("4dlu:grow"),
				RowSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				RowSpec.decode("4dlu:grow"),
				RowSpec.decode("default:grow"),
				RowSpec.decode("4dlu:grow"),
				RowSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				RowSpec.decode("4dlu:grow"),
				RowSpec.decode("default:grow"),
				RowSpec.decode("4dlu:grow"),
				RowSpec.decode("default:grow"),}));
		
		JLabel IconImage = new JLabel("");
		IconImage.setHorizontalAlignment(SwingConstants.CENTER);
		IconImage.setIcon(new ImageIcon(GameMain.class.getResource("/classPackage/img/characterBabyFormIcon.png")));
		panel.add(IconImage, "3, 3, 1, 7, center, center");
		
		NAME = new JTextField();
		NAME.setHorizontalAlignment(SwingConstants.CENTER);
		NAME.setBackground(SystemColor.desktop);
		NAME.setEditable(false);
		NAME.setFont(new Font("±¼¸²", Font.BOLD, 18));
		NAME.setText("\uC774\uB984 :");
		panel.add(NAME, "4, 5, 2, 2, fill, fill");
		NAME.setColumns(10);
		
		nameField = new JTextField();
		nameField.setEditable(false);
		panel.add(nameField, "6, 5, 2, 2, fill, fill");
		nameField.setColumns(10);
		
		Like = new JTextField();
		Like.setFont(new Font("±¼¸²", Font.BOLD, 18));
		Like.setText("\uD638\uAC10\uB3C4 : ");
		Like.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(Like, "10, 5, 1, 2, fill, default");
		Like.setColumns(10);
		
		LikeGuage = new JProgressBar();
		LikeGuage.setBackground(SystemColor.desktop);
		LikeGuage.setFont(new Font("ÈÞ¸Õ¸ðÀ½T", Font.BOLD, 18));
		LikeGuage.setForeground(Color.RED);
		LikeGuage.setStringPainted(true);
		LikeGuage.setValue(36);
		panel.add(LikeGuage, "12, 5, 3, 2");
		
		Weight = new JTextField();
		Weight.setHorizontalAlignment(SwingConstants.CENTER);
		Weight.setBackground(SystemColor.desktop);
		Weight.setEditable(false);
		Weight.setFont(new Font("±¼¸²", Font.BOLD, 18));
		Weight.setText("\uBAB8\uBB34\uAC8C :");
		panel.add(Weight, "4, 7, 2, 2, fill, fill");
		Weight.setColumns(10);
		
		weightField = new JTextField();
		weightField.setEditable(false);
		weightField.setColumns(10);
		panel.add(weightField, "6, 7, 2, 2, fill, default");
		
		Hunger = new JTextField();
		Hunger.setText("\uD3EC\uB9CC\uAC10 : ");
		Hunger.setFont(new Font("±¼¸²", Font.BOLD, 18));
		Hunger.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(Hunger, "10, 7, 1, 2, right, default");
		Hunger.setColumns(10);
		
		HungerGuage = new JProgressBar();
		HungerGuage.setFont(new Font("ÈÞ¸Õ¸ðÀ½T", Font.BOLD, 18));
		HungerGuage.setBackground(SystemColor.desktop);
		HungerGuage.setForeground(new Color(102, 51, 51));
		HungerGuage.setStringPainted(true);
		HungerGuage.setValue(40);
		panel.add(HungerGuage, "12, 7, 3, 2");
		
		JLabel CharacterImage = new JLabel("");
		CharacterImage.setLabelFor(CharacterImage);
		CharacterImage.setBackground(Color.WHITE);
		CharacterImage.setHorizontalAlignment(SwingConstants.CENTER);
		CharacterImage.setToolTipText("");
		CharacterImage.setForeground(Color.WHITE);
		CharacterImage.setIcon(new ImageIcon(GameMain.class.getResource("/classPackage/img/characterBabyForm.png")));
		panel.add(CharacterImage, "3, 11, 12, 9");
		
		JButton SleepBUtton = new JButton("\uC7AC\uC6B0\uAE30");
		SleepBUtton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int Hv = HungerGuage.getValue();
				Hv -=10;
				HungerGuage.setValue(Hv);
			}
		});
		SleepBUtton.setFont(new Font("HY¿±¼­M", Font.BOLD, 25));
		panel.add(SleepBUtton, "3, 24, 1, 11");
		
		JButton FeedButton = new JButton("\uBC25\uC8FC\uAE30");
		FeedButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int Hv = HungerGuage.getValue();
				Hv += 5;
				HungerGuage.setValue(Hv);
			}
		});
		FeedButton.setFont(new Font("HY¿±¼­M", Font.BOLD, 25));
		panel.add(FeedButton, "8, 24, 3, 11");
		
		JButton CleanButton = new JButton("\uCCAD\uC18C\uD558\uAE30");
		CleanButton.setFont(new Font("HY¿±¼­M", Font.BOLD, 25));
		panel.add(CleanButton, "12, 24, 1, 11");
		
		JButton InformButton = new JButton("\uC815\uBCF4");
		InformButton.setFont(new Font("HY¿±¼­M", Font.BOLD, 25));
		panel.add(InformButton, "14, 24, 1, 11");
		
		JButton SSDAMButton = new JButton("\uC4F0\uB2E4\uB4EC\uAE30");
		SSDAMButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CharacterImage.setIcon(new ImageIcon(GameMain.class.getResource("/classPackage/img/characterBabyFormHappy.png")));
				int n = LikeGuage.getValue();
				LikeGuage.setValue(++n);
			}
		});
		SSDAMButton.setFont(new Font("HY¿±¼­M", Font.BOLD, 25));
		panel.add(SSDAMButton, "5, 24, 2, 11");
		
		
		SystemThread st = new SystemThread();
		st.start();
	}

}


class SystemThread extends Thread {
	//¹Ýº¹ÇÒ ½Ã°£
	int time = 1000;
	
	//°ÔÀÌÁö ÇöÀç°ª º¯¼ö
	int curLike;
	int curHung;
	
	public void run() {
		
		while (true) {
			
			try {
				Thread.sleep(time);
			} catch (InterruptedException e) {}
			
			curHung = GameMain.HungerGuage.getValue();
			curHung -= 1;
			GameMain.HungerGuage.setValue(curHung);
			
		}
	}
}
