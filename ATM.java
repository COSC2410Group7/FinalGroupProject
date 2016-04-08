import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.CardLayout;
import java.awt.SystemColor;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.GridLayout;

public class ATM extends JFrame {

	private JPanel contentPane;
	private JTextField accountTextField;
	private JPasswordField passwordField;
	private JTextField textField;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ATM frame = new ATM();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ATM() {
		setTitle("ATM");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 2134, 1466);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 2102, 1378);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon("C:\\Users\\janiermrz\\Desktop\\COSC 1320\\workspace\\ATM-GroupProject\\img\\bank.png"));
		logo.setBounds(26, 72, 144, 148);
		panel.add(logo);
		
		JLabel BankInitials = new JLabel("G7B");
		BankInitials.setForeground(new Color(0, 74, 111));
		BankInitials.setFont(new Font("Baskerville Old Face", Font.BOLD, 90));
		BankInitials.setBounds(167, 68, 244, 77);
		panel.add(BankInitials);
		
		JLabel BankName = new JLabel("Group7Bank");
		BankName.setForeground(Color.BLUE);
		BankName.setFont(new Font("Baskerville Old Face", Font.BOLD, 70));
		BankName.setBounds(167, 149, 447, 71);
		panel.add(BankName);
		
		JPanel panel_1 = new JPanel();
		panel_1.setOpaque(false);
		panel_1.setBounds(0, 224, 2102, 1154);
		panel.add(panel_1);
		panel_1.setLayout(new CardLayout(0, 0));
		
		JPanel login = new JPanel();
		login.setOpaque(false);
		panel_1.add(login);
		login.setLayout(null);
		
		JPanel MainMenu = new JPanel();
		MainMenu.setLayout(null);
		MainMenu.setOpaque(true);
		MainMenu.setBackground(new Color(0, 0, 0, 0));
		panel_1.add(MainMenu);
		
		JPanel balance = new JPanel();
		balance.setLayout(null);
		balance.setOpaque(true);
		balance.setBackground(new Color(0, 0, 0, 0));
		panel_1.add(balance);
		
		textField = new JTextField();
		textField.setFont(new Font("SansSerif", Font.PLAIN, 50));
		textField.setColumns(10);
		textField.setBounds(457, 329, 551, 108);
		balance.add(textField);
		
		JLabel lblAccount = new JLabel("Account Number");
		lblAccount.setFont(new Font("Arial Unicode MS", Font.BOLD, 60));
		lblAccount.setForeground(Color.WHITE);
		lblAccount.setBounds(783, 153, 535, 82);
		login.add(lblAccount);
		
		accountTextField = new JTextField();
		accountTextField.setFont(new Font("SansSerif", Font.PLAIN, 50));
		accountTextField.setBounds(742, 249, 551, 108);
		login.add(accountTextField);
		accountTextField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Arial Unicode MS", Font.BOLD, 60));
		lblPassword.setBounds(865, 422, 311, 82);
		login.add(lblPassword);
		
		JPanel blue = new JPanel();
		blue.setBackground(new Color(0, 99, 147));
		blue.setBounds(544, 125, 988, 753);
		login.add(blue);
		blue.setLayout(null);
		
		
		JButton btnEnter = new JButton("Enter");
		btnEnter.setBounds(55, 549, 420, 123);
		blue.add(btnEnter);
		btnEnter.setForeground(Color.WHITE);
		btnEnter.setFont(new Font("Arial Unicode MS", Font.BOLD, 60));
		btnEnter.setBackground(new Color(37,192,84));
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_1.removeAll();
				panel_1.repaint();
				panel_1.revalidate();
				
				panel_1.add(MainMenu);
				panel_1.repaint();
			    panel_1.revalidate();
			}
		});
		
		
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(518, 549, 408, 123);
		blue.add(btnCancel);
		btnCancel.setBackground(new Color(220, 20, 60));
		btnCancel.setForeground(Color.WHITE);
		btnCancel.setFont(new Font("Arial Unicode MS", Font.BOLD, 60));
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("SansSerif", Font.PLAIN, 50));
		passwordField.setBounds(199, 380, 551, 108);
		blue.add(passwordField);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				accountTextField.setText("");
		    	passwordField.setText("");
			}
		});
							
		JLabel menuLabel = new JLabel("Main Menu");
		menuLabel.setForeground(Color.WHITE);
		menuLabel.setFont(new Font("Arial Unicode MS", Font.PLAIN, 60));
		menuLabel.setBounds(26, 77, 336, 72);
		MainMenu.add(menuLabel);
		
		JLabel welcomeLabel = new JLabel("Welcome to Group7Bank");
		welcomeLabel.setForeground(Color.WHITE);
		welcomeLabel.setFont(new Font("Arial Unicode MS", Font.PLAIN, 60));
		welcomeLabel.setBounds(627, 82, 668, 72);
		MainMenu.add(welcomeLabel);
		
		JLabel selectionLabel = new JLabel("Select a Transaction");
		selectionLabel.setForeground(Color.WHITE);
		selectionLabel.setFont(new Font("Arial Unicode MS", Font.BOLD, 70));
		selectionLabel.setBounds(627, 196, 770, 77);
		MainMenu.add(selectionLabel);
		
		JButton btnBalance = new JButton("Balance");
		btnBalance.setBounds(627, 551, 437, 154);
		MainMenu.add(btnBalance);
		btnBalance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_1.removeAll();
				panel_1.repaint();
				panel_1.revalidate();
				
				panel_1.add(balance);
				panel_1.repaint();
			    panel_1.revalidate();
			}
		});
		btnBalance.setForeground(Color.WHITE);
		btnBalance.setFont(new Font("Arial Unicode MS", Font.BOLD, 60));
		btnBalance.setBackground(new Color(0, 99, 147));
		
		JButton btnWithdraw = new JButton("Withdraw");
		btnWithdraw.setBounds(1237, 329, 437, 154);
		MainMenu.add(btnWithdraw);
		btnWithdraw.setForeground(Color.WHITE);
		btnWithdraw.setFont(new Font("Arial Unicode MS", Font.BOLD, 60));
		btnWithdraw.setBackground(new Color(0, 99, 147));
		
		JButton btnDeposit = new JButton("Deposit");
		btnDeposit.setBounds(627, 330, 437, 153);
		MainMenu.add(btnDeposit);
		btnDeposit.setForeground(Color.WHITE);
		btnDeposit.setFont(new Font("Arial Unicode MS", Font.BOLD, 60));
		btnDeposit.setBackground(new Color(0, 99, 147));
		
		JButton btnTransfer = new JButton("Transfer");
		btnTransfer.setBounds(1237, 551, 437, 154);
		MainMenu.add(btnTransfer);
		btnTransfer.setForeground(Color.WHITE);
		btnTransfer.setFont(new Font("Arial Unicode MS", Font.BOLD, 60));
		btnTransfer.setBackground(new Color(0, 99, 147));
		
		JButton btnChangePass = new JButton("<html>Change<br /> Password</html>");
		btnChangePass.setBounds(627, 789, 437, 153);
		MainMenu.add(btnChangePass);
		btnChangePass.setForeground(Color.WHITE);
		btnChangePass.setFont(new Font("Arial Unicode MS", Font.BOLD, 60));
		btnChangePass.setBackground(new Color(0, 99, 147));
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setBounds(1237, 788, 437, 154);
		MainMenu.add(btnLogout);
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_1.removeAll();
				panel_1.repaint();
				panel_1.revalidate();
				
				panel_1.add(login);
				panel_1.repaint();
			    panel_1.revalidate();
			}
		});
		btnLogout.setForeground(Color.WHITE);
		btnLogout.setFont(new Font("Arial Unicode MS", Font.BOLD, 60));
		btnLogout.setBackground(new Color(0, 99, 147));
		
		JLabel wallpaper = new JLabel("");
		wallpaper.setIcon(new ImageIcon("C:\\Users\\janiermrz\\Desktop\\COSC 1320\\workspace\\ATM-GroupProject\\img\\blue.jpg"));
		wallpaper.setBounds(0, 224, 2102, 1154);
		panel.add(wallpaper);
	}
}
