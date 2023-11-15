import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class ClickGameYeah {

	int num;
	
	
	private JFrame frame;
	private JTextField textField;
	
	private static int clicksPerSecond = 0;
    private static Timer timer;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClickGameYeah window = new ClickGameYeah();
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
	public ClickGameYeah() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 900, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setFont(new Font("굴림", Font.BOLD, 54));
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBounds(308, 15, 250, 58);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Click me!");
		btnNewButton.setFont(new Font("굴림", Font.BOLD, 64));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				num++;
				textField.setText(num+"");
			}
		});
		
		timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clicksPerSecond = num;
                System.out.println("Clicks per second: " + clicksPerSecond);
                num = 0; // 초당 클릭 수를 다시 0으로 초기화
            }
        });
        timer.start();
        
		btnNewButton.setBounds(273, 180, 349, 180);
		frame.getContentPane().add(btnNewButton);
	}
}
