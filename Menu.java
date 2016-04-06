import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;


public class Menu {

	private JFrame frame;

	public static void Transaction() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu window = new Menu();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Menu() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 128, 192));
		frame.setBounds(1000, 1000, 1910, 1244);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
				
		JLabel lblNewLabel = new JLabel("");
		Image wallpaper= new ImageIcon (this.getClass().getResource("blue.jpg")).getImage();
		
		JLabel lblMainMenu = new JLabel("Main Menu");
		lblMainMenu.setForeground(Color.WHITE);
		lblMainMenu.setFont(new Font("Arial Unicode MS", Font.PLAIN, 60));
		lblMainMenu.setBounds(26, 80, 336, 72);
		frame.getContentPane().add(lblMainMenu);
		
		JLabel lblWelcomeToGroupbank = new JLabel("Welcome to Group7Bank");
		lblWelcomeToGroupbank.setForeground(Color.WHITE);
		lblWelcomeToGroupbank.setFont(new Font("Arial Unicode MS", Font.PLAIN, 60));
		lblWelcomeToGroupbank.setBounds(495, 80, 668, 72);
		frame.getContentPane().add(lblWelcomeToGroupbank);
		
		JLabel lblSelectATransaction = new JLabel("Select a Transaction");
		lblSelectATransaction.setForeground(Color.WHITE);
		lblSelectATransaction.setFont(new Font("Arial Unicode MS", Font.BOLD, 70));
		lblSelectATransaction.setBounds(495, 170, 770, 77);
		frame.getContentPane().add(lblSelectATransaction);
		
		JButton btnTransfer = new JButton("Deposit");
		btnTransfer.setForeground(Color.WHITE);
		btnTransfer.setBackground(new Color(0,99,147));
		btnTransfer.setFont(new Font("Arial Unicode MS", Font.BOLD, 60));
		btnTransfer.setBounds(495, 603, 428, 158);
		frame.getContentPane().add(btnTransfer);
		
		JButton btnTransfer_1 = new JButton("Transfer");
		btnTransfer_1.setBackground(new Color(0,99,147));
		btnTransfer_1.setFont(new Font("Arial Unicode MS", Font.BOLD, 60));
		btnTransfer_1.setForeground(Color.WHITE);
		btnTransfer_1.setBounds(1091, 603, 421, 158);
		frame.getContentPane().add(btnTransfer_1);
		
		JButton btnBalance = new JButton("Balance");
		btnBalance.setBackground(new Color(0,99,147));
		btnBalance.setForeground(Color.WHITE);
		btnBalance.setFont(new Font("Arial Unicode MS", Font.BOLD, 60));
		btnBalance.setBounds(495, 346, 428, 158);
		frame.getContentPane().add(btnBalance);
		
		JButton btnWithdraw = new JButton("Withdraw");
		btnWithdraw.setForeground(Color.WHITE);
		btnWithdraw.setFont(new Font("Arial Unicode MS", Font.BOLD, 60));
		btnWithdraw.setBackground(new Color(0,99,147));
		btnWithdraw.setBounds(1091, 346, 421, 158);
		frame.getContentPane().add(btnWithdraw);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setBackground(new Color(220, 20, 60));
		btnLogout.setForeground(Color.WHITE);
		btnLogout.setFont(new Font("Arial Unicode MS", Font.BOLD, 60));
		btnLogout.setBounds(1398, 970, 418, 158);
		frame.getContentPane().add(btnLogout);
		
		JButton btnChangePassword = new JButton("<html>Change<br /> Password</html>");
		btnChangePassword.setBackground(new Color(226,205,16));
		btnChangePassword.setForeground(Color.WHITE);
		btnChangePassword.setFont(new Font("Arial Unicode MS", Font.BOLD, 60));
		btnChangePassword.setBounds(36, 970, 428, 158);
		frame.getContentPane().add(btnChangePassword);
		
		
		lblNewLabel.setIcon(new ImageIcon(wallpaper));
		lblNewLabel.setBounds(0, 0, 1878, 1156);
		frame.getContentPane().add(lblNewLabel);
		
		
		
		
	}
}
