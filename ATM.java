

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
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import java.awt.SystemColor;

public class ATM extends JFrame {

	private JPanel contentPane;
	private JTextField accountTextField;
	private JPasswordField passwordField;
	private JTextField insertAmount;
	static int STATUS_COUNTER = 0;

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
		setBounds(100, 100, 613, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel background = new JPanel();
		background.setBounds(0, 0, 597, 391);
		contentPane.add(background);
		background.setLayout(null);
		
		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon("C:\\Users\\Drew\\Desktop\\workspace\\ATM-GroupProject\\img\\bank.png"));
		logo.setBounds(0, 0, 67, 55);
		background.add(logo);
		
		JLabel BankInitials = new JLabel("G7B");
		BankInitials.setForeground(new Color(0, 74, 111));
		BankInitials.setFont(new Font("Baskerville Old Face", Font.BOLD, 30));
		BankInitials.setBounds(60, -5, 67, 49);
		background.add(BankInitials);
		
		JLabel BankName = new JLabel("Group7Bank");
		BankName.setForeground(Color.BLUE);
		BankName.setFont(new Font("Baskerville Old Face", Font.BOLD, 25));
		BankName.setBounds(59, 33, 149, 24);
		background.add(BankName);
		
		JPanel cardLayout = new JPanel();
		cardLayout.setOpaque(false);
		cardLayout.setBounds(0, 0, 597, 391);
		background.add(cardLayout);
		cardLayout.setLayout(new CardLayout(0, 0));
		
		JPanel login = new JPanel();
		login.setOpaque(false);
		cardLayout.add(login);
		login.setLayout(null);
		
		JPanel MainMenu = new JPanel();
		MainMenu.setLayout(null);
		MainMenu.setOpaque(true);
		MainMenu.setBackground(new Color(0, 0, 0, 0));
		cardLayout.add(MainMenu);
		
		JPanel Deposit = new JPanel();
		Deposit.setLayout(null);
		Deposit.setOpaque(true);
		Deposit.setBackground(new Color(0, 0, 0, 0));
		cardLayout.add(Deposit);
		
		JPanel innerDeposit = new JPanel();
		innerDeposit.setLayout(null);
		innerDeposit.setBackground(new Color(0, 99, 147));
		innerDeposit.setBounds(125, 119, 367, 191);
		Deposit.add(innerDeposit);
		
		JLabel lblDepositComplete = new JLabel("Deposit Complete.");
		lblDepositComplete.setBounds(128, 95, 110, 14);
		lblDepositComplete.setForeground(Color.WHITE);
		lblDepositComplete.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblInvalidInput = new JLabel("Invalid Input");
		lblInvalidInput.setForeground(Color.WHITE);
		lblInvalidInput.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblInvalidInput.setBounds(146, 95, 74, 14);
		
		JButton btnEnter_1 = new JButton("Deposit");
		btnEnter_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					innerDeposit.remove(lblDepositComplete);
					innerDeposit.remove(lblInvalidInput);
					String toDeposit = insertAmount.getText();
					try {
						int toAdd = Integer.parseInt(toDeposit);
						userDeposit(toAdd);
						insertAmount.setText("");
						innerDeposit.add(lblDepositComplete);
						innerDeposit.validate();
						innerDeposit.repaint();
					}
					catch(NumberFormatException n)
					{
						innerDeposit.add(lblInvalidInput);
						insertAmount.setText("");
						innerDeposit.validate();
						innerDeposit.repaint();
					}
				
			}
		});
		
		btnEnter_1.setForeground(Color.WHITE);
		btnEnter_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnEnter_1.setBackground(new Color(37, 192, 84));
		btnEnter_1.setBounds(138, 115, 89, 31);
		innerDeposit.add(btnEnter_1);
		
		JButton btnReturn = new JButton("Cancel");
		btnReturn.setForeground(Color.WHITE);
		btnReturn.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnReturn.setBackground(new Color(220, 20, 60));
		btnReturn.setBounds(138, 149, 89, 31);
		innerDeposit.add(btnReturn);
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				insertAmount.setText("");
				cardLayout.removeAll();
				cardLayout.repaint();
				cardLayout.revalidate();
				
				cardLayout.add(MainMenu);
				cardLayout.repaint();
			    cardLayout.revalidate();
				
			}
		});
		
		
		insertAmount = new JTextField();
		insertAmount.setBounds(92, 53, 182, 31);
		innerDeposit.add(insertAmount);
		insertAmount.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("$");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(65, 53, 29, 31);
		innerDeposit.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Insert Amount");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(92, 11, 182, 31);
		innerDeposit.add(lblNewLabel_1);
		
		
		JPanel withdraw = new JPanel();
		withdraw.setLayout(null);
		withdraw.setOpaque(true);
		withdraw.setBackground(new Color(0, 0, 0, 0));
		cardLayout.add(withdraw);
		
		JLabel lblNewLabel_2 = new JLabel("Select an Amount");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_2.setBounds(158, 60, 281, 31);
		withdraw.add(lblNewLabel_2);
		
		JLabel lblWithdrawalComplete = new JLabel("Withdrawal Complete.");
		lblWithdrawalComplete.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblWithdrawalComplete.setForeground(Color.WHITE);
		lblWithdrawalComplete.setBounds(227, 100, 143, 14);
		
		JButton btn$20 = new JButton("$20");
		btn$20.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//withdraw.remove(lblWithdrawalComplete);
				userWithdraw(20);
				withdraw.add(lblWithdrawalComplete);
				withdraw.validate();
				withdraw.repaint();
			
			}
		});
		btn$20.setForeground(Color.WHITE);
		btn$20.setFont(new Font("Tahoma", Font.BOLD, 14));
		btn$20.setBackground(new Color(0, 99, 147));
		btn$20.setBounds(184, 125, 89, 50);
		withdraw.add(btn$20);
		
		JButton btn$40 = new JButton("$40");
		btn$40.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				withdraw.remove(lblWithdrawalComplete);
				userWithdraw(40);
				withdraw.add(lblWithdrawalComplete);
				withdraw.validate();
				withdraw.repaint();
			}
		});
		btn$40.setForeground(Color.WHITE);
		btn$40.setFont(new Font("Tahoma", Font.BOLD, 14));
		btn$40.setBackground(new Color(0, 99, 147));
		btn$40.setBounds(313, 125, 89, 50);
		withdraw.add(btn$40);
		
		JButton btn$60 = new JButton("$60");
		btn$60.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				withdraw.remove(lblWithdrawalComplete);
				userWithdraw(60);
				withdraw.add(lblWithdrawalComplete);
				withdraw.validate();
				withdraw.repaint();
			}
		});
		btn$60.setForeground(Color.WHITE);
		btn$60.setFont(new Font("Tahoma", Font.BOLD, 14));
		btn$60.setBackground(new Color(0, 99, 147));
		btn$60.setBounds(184, 201, 89, 47);
		withdraw.add(btn$60);
		
		JButton btn$80 = new JButton("$80");
		btn$80.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				withdraw.remove(lblWithdrawalComplete);
				userWithdraw(80);
				withdraw.add(lblWithdrawalComplete);
				withdraw.validate();
				withdraw.repaint();
			}
		});
		btn$80.setForeground(Color.WHITE);
		btn$80.setFont(new Font("Tahoma", Font.BOLD, 14));
		btn$80.setBackground(new Color(0, 99, 147));
		btn$80.setBounds(313, 201, 89, 47);
		withdraw.add(btn$80);
		
		JButton btn$100 = new JButton("$100");
		btn$100.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				withdraw.remove(lblWithdrawalComplete);
				userWithdraw(100);
				withdraw.add(lblWithdrawalComplete);
				withdraw.validate();
				withdraw.repaint();
			}
		});
		btn$100.setForeground(Color.WHITE);
		btn$100.setFont(new Font("Tahoma", Font.BOLD, 14));
		btn$100.setBackground(new Color(0, 99, 147));
		btn$100.setBounds(184, 274, 89, 47);
		withdraw.add(btn$100);
		
		JButton other = new JButton("<html>Other<br /> Amount</html>");
		other.setForeground(Color.WHITE);
		other.setFont(new Font("Tahoma", Font.BOLD, 14));
		other.setBackground(new Color(0, 99, 147));
		other.setBounds(313, 274, 89, 47);
		withdraw.add(other);
		
		JButton btnMainMenu = new JButton("Main Menu");
		btnMainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cardLayout.removeAll();
				cardLayout.repaint();
				cardLayout.revalidate();
						
			    cardLayout.add(MainMenu);
				cardLayout.repaint();
				cardLayout.revalidate();
			}
		});
		btnMainMenu.setForeground(Color.WHITE);
		btnMainMenu.setFont(new Font("Tahoma", Font.BOLD, 60));
		btnMainMenu.setBackground(new Color(0, 99, 147));
		btnMainMenu.setBounds(1381, 787, 437, 166);
		withdraw.add(btnMainMenu);
		
		JPanel balance = new JPanel();
		balance.setLayout(null);
		balance.setOpaque(true);
		balance.setBackground(new Color(0, 0, 0, 0));
		cardLayout.add(balance);
		
		JPanel transfer = new JPanel();
		transfer.setLayout(null);
		transfer.setOpaque(true);
		transfer.setBackground(new Color(0, 0, 0, 0));
		cardLayout.add(transfer);
		
		JPanel changePassword = new JPanel();
		changePassword.setLayout(null);
		changePassword.setOpaque(true);
		changePassword.setBackground(new Color(0, 0, 0, 0));
		cardLayout.add(changePassword);
		
		JPanel blue = new JPanel();
		blue.setBackground(new Color(0, 99, 147));
		blue.setBounds(146, 104, 310, 224);
		login.add(blue);
		blue.setLayout(null);
		
		JLabel lblIncorrectpassword = new JLabel("Incorrect username or password!");
		lblIncorrectpassword.setForeground(SystemColor.text);
		lblIncorrectpassword.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblIncorrectpassword.setBounds(60, 134, 189, 14);
		
		
		JButton btnEnter = new JButton("Enter");
		btnEnter.setBounds(64, 159, 89, 41);
		blue.add(btnEnter);
		btnEnter.setForeground(Color.WHITE);
		btnEnter.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnEnter.setBackground(new Color(37,192,84));
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				blue.remove(lblIncorrectpassword);
				if (checkLogin() == 1)
				{
					System.out.println("test");
					cardLayout.removeAll();
					cardLayout.repaint();
					cardLayout.revalidate();
					
					cardLayout.add(MainMenu);
					cardLayout.repaint();
				    cardLayout.revalidate();
				}
				else	{
					blue.add(lblIncorrectpassword);
					cardLayout.validate();
					cardLayout.repaint();
				}
			}});
		
		
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(157, 159, 89, 41);
		blue.add(btnCancel);
		btnCancel.setBackground(new Color(220, 20, 60));
		btnCancel.setForeground(Color.WHITE);
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("SansSerif", Font.PLAIN, 14));
		passwordField.setBounds(64, 98, 182, 25);
		blue.add(passwordField);
		
		accountTextField = new JTextField();
		accountTextField.setBounds(64, 44, 182, 25);
		blue.add(accountTextField);
		accountTextField.setFont(new Font("SansSerif", Font.PLAIN, 14));
		accountTextField.setColumns(10);
		
		
		JLabel lblAccount = new JLabel("Account Number");
		lblAccount.setBounds(92, 11, 126, 31);
		blue.add(lblAccount);
		lblAccount.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAccount.setForeground(Color.WHITE);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(117, 69, 75, 31);
		blue.add(lblPassword);
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				accountTextField.setText("");
		    	passwordField.setText("");
			}
		});
							
		JLabel menuLabel = new JLabel("Main Menu");
		menuLabel.setForeground(Color.WHITE);
		menuLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		menuLabel.setBounds(10, 0, 89, 49);
		MainMenu.add(menuLabel);
		
		JLabel welcomeLabel = new JLabel("Welcome to Group7Bank");
		welcomeLabel.setForeground(Color.WHITE);
		welcomeLabel.setFont(new Font("Tahoma", Font.PLAIN, 23));
		welcomeLabel.setBounds(166, 0, 265, 31);
		MainMenu.add(welcomeLabel);
		
		JLabel selectionLabel = new JLabel("Select a Transaction.");
		selectionLabel.setForeground(Color.WHITE);
		selectionLabel.setFont(new Font("Tahoma", Font.BOLD, 38));
		selectionLabel.setBounds(99, 64, 399, 31);
		MainMenu.add(selectionLabel);
		
		JButton btnBalance = new JButton("Balance");
		btnBalance.setBounds(96, 106, 187, 84);
		MainMenu.add(btnBalance);
		btnBalance.setForeground(Color.WHITE);
		btnBalance.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnBalance.setBackground(new Color(0, 99, 147));
		btnBalance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.removeAll();
				cardLayout.repaint();
				cardLayout.revalidate();
				
				cardLayout.add(balance);
				cardLayout.repaint();
			    cardLayout.revalidate();
			}
		});	
		
		
		JButton btnWithdraw = new JButton("Withdraw");
		btnWithdraw.setBounds(293, 106, 187, 84);
		MainMenu.add(btnWithdraw);
		btnWithdraw.setForeground(Color.WHITE);
		btnWithdraw.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnWithdraw.setBackground(new Color(0, 99, 147));
		btnWithdraw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.removeAll();
				cardLayout.repaint();
				cardLayout.revalidate();
				
				cardLayout.add(withdraw);
				cardLayout.repaint();
			    cardLayout.revalidate();
			}
		});
		
		
		
		JButton btnDeposit = new JButton("Deposit");
		btnDeposit.setBounds(295, 201, 187, 84);
		MainMenu.add(btnDeposit);
		btnDeposit.setForeground(Color.WHITE);
		btnDeposit.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnDeposit.setBackground(new Color(0, 99, 147));
		btnDeposit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cardLayout.removeAll();
				cardLayout.repaint();
				cardLayout.revalidate();
				
				cardLayout.add(Deposit);
				cardLayout.repaint();
			    cardLayout.revalidate();
					
			}
		});
		
		JButton btnTransfer = new JButton("Transfer");
		btnTransfer.setBounds(96, 201, 187, 84);
		MainMenu.add(btnTransfer);
		btnTransfer.setForeground(Color.WHITE);
		btnTransfer.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnTransfer.setBackground(new Color(0, 99, 147));
		btnTransfer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.removeAll();
				cardLayout.repaint();
				cardLayout.revalidate();
				
				cardLayout.add(transfer);
				cardLayout.repaint();
			    cardLayout.revalidate();
			}
		});
		
		
		
		JButton btnChangePass = new JButton("<html>Change<br /> Password</html>");
		btnChangePass.setBounds(96, 296, 187, 84);
		MainMenu.add(btnChangePass);
		btnChangePass.setForeground(Color.WHITE);
		btnChangePass.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnChangePass.setBackground(Color.YELLOW);
		btnChangePass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.removeAll();
				cardLayout.repaint();
				cardLayout.revalidate();
				
				cardLayout.add(changePassword);
				cardLayout.repaint();
			    cardLayout.revalidate();
			}
		});
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setBounds(295, 296, 187, 84);
		MainMenu.add(btnLogout);
		btnLogout.setForeground(Color.WHITE);
		btnLogout.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnLogout.setBackground(Color.RED);
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.removeAll();
				cardLayout.repaint();
				cardLayout.revalidate();
				
				cardLayout.add(login);
				cardLayout.repaint();
			    cardLayout.revalidate();
			}
		});
		
		JLabel wallpaper = new JLabel("");
		wallpaper.setIcon(new ImageIcon("C:\\Users\\Drew\\Desktop\\workspace\\ATM-GroupProject\\img\\blue.jpg"));
		wallpaper.setBounds(0, 55, 597, 336);
		background.add(wallpaper);
	}
	void userDeposit(int toAdd)		//NOT ALL CODE BELONGS IN THIS SECTION
	{								//after 3 login attempts, status is changed to inactive
		try {						//and user cannot access account
			Scanner input = null;
			input = new Scanner(new FileInputStream("txt/AccountInformation.txt"));
			String[] accountInfo = new String[5];
			for(int i = 0; i < 5; i++)	//fill string array
			{
				accountInfo[i] = input.nextLine();
			}
			input.close();
			int accountNumber = (int)Integer.parseInt(accountInfo[0]);
			String lastName = accountInfo[1];
			String firstName = accountInfo[2];
			int balance = (int)Integer.parseInt(accountInfo[3]);
			//Begin deposit
			balance +=toAdd;
			PrintWriter output = null;
			output = new PrintWriter(new FileOutputStream("txt/AccountInformation.txt"));
			output.println(accountNumber);
			output.println(lastName);
			output.println(firstName);
			output.println(balance);
			output.println("Active");
			output.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("file not found.");
		}
		
	}
	void userWithdraw(int amount)		//NOT ALL CODE BELONGS IN THIS SECTION
	{								//after 3 login attempts, status is changed to inactive
		try {						//and user cannot access account
			Scanner input = null;
			input = new Scanner(new FileInputStream("txt/AccountInformation.txt"));
			String[] accountInfo = new String[5];
			for(int i = 0; i < 5; i++)	//fill string array
			{
				accountInfo[i] = input.nextLine();
			}
			input.close();
			int accountNumber = (int)Integer.parseInt(accountInfo[0]);
			String lastName = accountInfo[1];
			String firstName = accountInfo[2];
			int balance = (int)Integer.parseInt(accountInfo[3]);
			//Begin withdrawal
			if(amount == 20)
				balance -=20;
			else if(amount == 40)
				balance -=40;
			else if(amount == 60)
				balance -=60;
			else if(amount == 80)
				balance -=80;
			else if(amount == 100)
				balance -=100;
			else
			{
				//not complete yet
			}
			PrintWriter output = null;
			output = new PrintWriter(new FileOutputStream("txt/AccountInformation.txt"));
			output.println(accountNumber);
			output.println(lastName);
			output.println(firstName);
			output.println(balance);
			output.println("Active");
			output.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("file not found.");
		}
		
	}
	int checkLogin() {
		String userAccountInfo = accountTextField.getText();
		String userPassword = new String(passwordField.getPassword());
		try {			
			Scanner input = null;
			input = new Scanner(new FileInputStream("txt/AccountInformation.txt"));
			String[] accountInfo = new String[5];
			for(int i = 0; i < 5; i++)	//fill string array
				accountInfo[i] = input.nextLine();
			input.close();
			boolean status;
			if(accountInfo[4] == "Active")
				status = true;
			else
				status = false;
			if(/*status == true &&*/ STATUS_COUNTER != 3)
			{
					input = new Scanner(new FileInputStream("txt/Password.txt"));
					String accountInfo2 = input.nextLine();
					input.close();
					String[] splitLine = accountInfo2.split(" ");
					String accountNumber = splitLine[0];
					String password = splitLine[1];
					if((accountNumber.equals(userAccountInfo)) && (userPassword.equals(password)))
					{
						return 1;
					}
					else
					{
						//print "incorrect password, user has 3-statusCounter attempts remaining" with a Jlabel
						STATUS_COUNTER++;
						return 0;
					}
			
			}
			else
			{
				status = false;
				return 0;
				//lock user out, print that their login will no longer be accessible with JLabel
			}
		} catch (FileNotFoundException e) {
			System.out.println("file not found.");
		}
		return 0;
	}
	void clearText()
	{
		accountTextField.setText("");
    	passwordField.setText("");
	}
}
