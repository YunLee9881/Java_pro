package classPackage;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class StartPage extends JFrame{

	private JFrame frame;
	private JTextField txtVtamagochi;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartPage window = new StartPage();
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
	public StartPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 900, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(UIManager.getColor("Button.background"));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		txtVtamagochi = new JTextField();
		txtVtamagochi.setBackground(Color.WHITE);
		txtVtamagochi.setEditable(false);
		txtVtamagochi.setFont(new Font("HY«ÏµÂ∂Û¿ŒM", Font.BOLD, 52));
		txtVtamagochi.setHorizontalAlignment(SwingConstants.CENTER);
		txtVtamagochi.setText("V-Tamagochi!");
		txtVtamagochi.setBounds(200, 50, 500, 200);
		panel.add(txtVtamagochi);
		txtVtamagochi.setColumns(10);
		
		Dimension frameSize = getSize();
		Dimension windowSize = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((windowSize.width - frameSize.width) / 2,
		            (windowSize.height - frameSize.height) / 2); 
		
		
		JButton btnNewButton = new JButton("\uC2DC\uC791");
		btnNewButton.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new GameMain();
				System.exit(0);
			}
		});
		btnNewButton.setBounds(350, 300, 200, 50);
		panel.add(btnNewButton);
		
		JButton button = new JButton("\uBD88\uB7EC\uC624\uAE30");
		button.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 18));
		button.setBounds(350, 365, 200, 50);
		panel.add(button);
		
		JButton button_1 = new JButton("\uC885\uB8CC");
		button_1.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 18));
		button_1.setBounds(350, 430, 200, 50);
		panel.add(button_1);
	}
}
