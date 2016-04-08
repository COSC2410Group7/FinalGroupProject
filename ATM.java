import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.CardLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;

public class ATM extends JFrame {

	private JPanel contentPane;
	private JTextField accountTextField;
	private JPasswordField passwordField;
	private JTextField insertAmount;

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
		setBounds(100, 100, 2128, 1470);
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
		BankInitials.setBounds(167, 68, 256, 81);
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
		
		JPanel Deposit = new JPanel();
		Deposit.setLayout(null);
		Deposit.setOpaque(true);
		Deposit.setBackground(new Color(0, 0, 0, 0));
		panel_1.add(Deposit);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(0, 99, 147));
		panel_2.setBounds(523, 200, 988, 753);
		Deposit.add(panel_2);
		
		JButton button = new JButton("Enter");
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Arial Unicode MS", Font.BOLD, 60));
		button.setBackground(new Color(37, 192, 84));
		button.setBounds(57, 464, 420, 123);
		panel_2.add(button);
		
		JButton button_1 = new JButton("Cancel");
		button_1.setForeground(Color.WHITE);
		button_1.setFont(new Font("Arial Unicode MS", Font.BOLD, 60));
		button_1.setBackground(new Color(220, 20, 60));
		button_1.setBounds(518, 464, 408, 123);
		panel_2.add(button_1);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				insertAmount.setText("");
				panel_1.removeAll();
				panel_1.repaint();
				panel_1.revalidate();
				
				panel_1.add(MainMenu);
				panel_1.repaint();
			    panel_1.revalidate();
				
			}
		});
		
		
		insertAmount = new JTextField();
		insertAmount.setBounds(224, 229, 551, 108);
		panel_2.add(insertAmount);
		insertAmount.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("$");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial Unicode MS", Font.BOLD, 60));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(145, 229, 79, 108);
		panel_2.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Insert Amount");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Arial Unicode MS", Font.BOLD, 60));
		lblNewLabel_1.setBounds(280, 135, 433, 66);
		panel_2.add(lblNewLabel_1);
		
		JPanel withdraw = new JPanel();
		withdraw.setLayout(null);
		withdraw.setOpaque(true);
		withdraw.setBackground(new Color(0, 0, 0, 0));
		panel_1.add(withdraw);
		
		JLabel lblNewLabel_2 = new JLabel("Select an Amount");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Arial Unicode MS", Font.BOLD, 70));
		lblNewLabel_2.setBounds(723, 99, 662, 116);
		withdraw.add(lblNewLabel_2);
		
		JButton btn$20 = new JButton("$20");
		btn$20.setForeground(Color.WHITE);
		btn$20.setFont(new Font("Arial Unicode MS", Font.BOLD, 60));
		btn$20.setBackground(new Color(0, 99, 147));
		btn$20.setBounds(287, 286, 437, 161);
		withdraw.add(btn$20);
		
		JButton btn$40 = new JButton("$40");
		btn$40.setForeground(Color.WHITE);
		btn$40.setFont(new Font("Arial Unicode MS", Font.BOLD, 60));
		btn$40.setBackground(new Color(0, 99, 147));
		btn$40.setBounds(839, 286, 437, 161);
		withdraw.add(btn$40);
		
		JButton btn$60 = new JButton("$60");
		btn$60.setForeground(Color.WHITE);
		btn$60.setFont(new Font("Arial Unicode MS", Font.BOLD, 60));
		btn$60.setBackground(new Color(0, 99, 147));
		btn$60.setBounds(1381, 286, 437, 161);
		withdraw.add(btn$60);
		
		JButton btn$80 = new JButton("$80");
		btn$80.setForeground(Color.WHITE);
		btn$80.setFont(new Font("Arial Unicode MS", Font.BOLD, 60));
		btn$80.setBackground(new Color(0, 99, 147));
		btn$80.setBounds(287, 539, 437, 161);
		withdraw.add(btn$80);
		
		JButton btn$100 = new JButton("$100");
		btn$100.setForeground(Color.WHITE);
		btn$100.setFont(new Font("Arial Unicode MS", Font.BOLD, 60));
		btn$100.setBackground(new Color(0, 99, 147));
		btn$100.setBounds(839, 539, 437, 161);
		withdraw.add(btn$100);
		
		JButton other = new JButton("<html>Other<br /> Amount</html>");
		other.setForeground(Color.WHITE);
		other.setFont(new Font("Arial Unicode MS", Font.BOLD, 60));
		other.setBackground(new Color(0, 99, 147));
		other.setBounds(1381, 539, 437, 161);
		withdraw.add(other);
		
		JButton btnMainMenu = new JButton("Main Menu");
		btnMainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel_1.removeAll();
				panel_1.repaint();
				panel_1.revalidate();
						
			    panel_1.add(MainMenu);
				panel_1.repaint();
				panel_1.revalidate();
			}
		});
		btnMainMenu.setForeground(Color.WHITE);
		btnMainMenu.setFont(new Font("Arial Unicode MS", Font.BOLD, 60));
		btnMainMenu.setBackground(new Color(0, 99, 147));
		btnMainMenu.setBounds(1381, 787, 437, 166);
		withdraw.add(btnMainMenu);
		
		JPanel balance = new JPanel();
		balance.setLayout(null);
		balance.setOpaque(true);
		balance.setBackground(new Color(0, 0, 0, 0));
		panel_1.add(balance);
		
		JPanel transfer = new JPanel();
		transfer.setLayout(null);
		transfer.setOpaque(true);
		transfer.setBackground(new Color(0, 0, 0, 0));
		panel_1.add(transfer);
		
		JPanel changePassword = new JPanel();
		changePassword.setLayout(null);
		changePassword.setOpaque(true);
		changePassword.setBackground(new Color(0, 0, 0, 0));
		panel_1.add(changePassword);
		
		
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
		blue.setBounds(544, 125, 986, 755);
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
		btnBalance.setForeground(Color.WHITE);
		btnBalance.setFont(new Font("Arial Unicode MS", Font.BOLD, 60));
		btnBalance.setBackground(new Color(0, 99, 147));
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
		
		
		JButton btnWithdraw = new JButton("Withdraw");
		btnWithdraw.setBounds(1237, 329, 437, 154);
		MainMenu.add(btnWithdraw);
		btnWithdraw.setForeground(Color.WHITE);
		btnWithdraw.setFont(new Font("Arial Unicode MS", Font.BOLD, 60));
		btnWithdraw.setBackground(new Color(0, 99, 147));
		btnWithdraw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_1.removeAll();
				panel_1.repaint();
				panel_1.revalidate();
				
				panel_1.add(withdraw);
				panel_1.repaint();
			    panel_1.revalidate();
			}
		});
		
		
		
		JButton btnDeposit = new JButton("Deposit");
		btnDeposit.setBounds(627, 330, 437, 153);
		MainMenu.add(btnDeposit);
		btnDeposit.setForeground(Color.WHITE);
		btnDeposit.setFont(new Font("Arial Unicode MS", Font.BOLD, 60));
		btnDeposit.setBackground(new Color(0, 99, 147));
		btnDeposit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel_1.removeAll();
				panel_1.repaint();
				panel_1.revalidate();
				
				panel_1.add(Deposit);
				panel_1.repaint();
			    panel_1.revalidate();
					
			}
		});
		
		JButton btnTransfer = new JButton("Transfer");
		btnTransfer.setBounds(1237, 551, 437, 154);
		MainMenu.add(btnTransfer);
		btnTransfer.setForeground(Color.WHITE);
		btnTransfer.setFont(new Font("Arial Unicode MS", Font.BOLD, 60));
		btnTransfer.setBackground(new Color(0, 99, 147));
		btnTransfer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_1.removeAll();
				panel_1.repaint();
				panel_1.revalidate();
				
				panel_1.add(transfer);
				panel_1.repaint();
			    panel_1.revalidate();
			}
		});
		
		
		
		JButton btnChangePass = new JButton("<html>Change<br /> Password</html>");
		btnChangePass.setBounds(627, 789, 437, 153);
		MainMenu.add(btnChangePass);
		btnChangePass.setForeground(Color.WHITE);
		btnChangePass.setFont(new Font("Arial Unicode MS", Font.BOLD, 60));
		btnChangePass.setBackground(new Color(0, 99, 147));
		btnChangePass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_1.removeAll();
				panel_1.repaint();
				panel_1.revalidate();
				
				panel_1.add(changePassword);
				panel_1.repaint();
			    panel_1.revalidate();
			}
		});
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setBounds(1237, 788, 437, 154);
		MainMenu.add(btnLogout);
		btnLogout.setForeground(Color.WHITE);
		btnLogout.setFont(new Font("Arial Unicode MS", Font.BOLD, 60));
		btnLogout.setBackground(new Color(0, 99, 147));
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
		
		JLabel wallpaper = new JLabel("");
		wallpaper.setIcon(new ImageIcon("C:\\Users\\janiermrz\\Desktop\\COSC 1320\\workspace\\ATM-GroupProject\\img\\blue.jpg"));
		wallpaper.setBounds(0, 224, 2102, 1154);
		panel.add(wallpaper);
	}
}
