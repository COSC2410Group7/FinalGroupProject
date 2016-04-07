

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class Withdraw extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void newWithdraw() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Withdraw frame = new Withdraw();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Withdraw() {
		setBackground(UIManager.getColor("scrollbar"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 613, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(240,240,240));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 99, 147));
		panel.setBounds(125, 119, 367, 191);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblInsertAmount = new JLabel("Insert Amount");
		lblInsertAmount.setBounds(104, 20, 158, 31);
		lblInsertAmount.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblInsertAmount.setForeground(Color.WHITE);
		panel.add(lblInsertAmount);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textField.setBounds(93, 62, 182, 31);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblWithdrawComplete = new JLabel("Withdrawal complete.");
		lblWithdrawComplete.setForeground(Color.WHITE);
		lblWithdrawComplete.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblWithdrawComplete.setBounds(136, 89, 158, 31);
		
		JLabel lblBadInput = new JLabel("Invalid input.");
		lblBadInput.setForeground(Color.WHITE);
		lblBadInput.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblBadInput.setBounds(136, 89, 158, 31);
		
		JButton btnWithdraw = new JButton("Withdraw");
		btnWithdraw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*Timer timer = new Timer(50, this);
				timer.setInitialDelay(1000);
				timer.setRepeats(false);*/
				String toWithdraw = textField.getText();
				//timer.start();
				try	{
					int toSubtract = Integer.parseInt(toWithdraw);
					userWithdraw(toSubtract);
					textField.setText("");
					panel.add(lblWithdrawComplete);
					panel.validate();
					panel.repaint();
					/*timer.start();
					panel.remove(lblWithdrawComplete);
					panel.validate();
					panel.repaint();*/
				}
				catch(NumberFormatException n)
				{
					panel.add(lblBadInput);
					panel.validate();
					panel.repaint();
					/*panel.remove(lblBadInput);
					panel.validate();
					panel.repaint();*/
				}
					
				
			}
		});
		btnWithdraw.setForeground(Color.WHITE);
		btnWithdraw.setBackground(new Color(37,192,84));
		btnWithdraw.setBounds(138, 117, 89, 23);
		panel.add(btnWithdraw);
		
		JButton btnCancel = new JButton("Return");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Menu mn=new Menu();
				mn.Transaction();
			}
		});
		btnCancel.setForeground(Color.WHITE);
		btnCancel.setBackground(new Color(220,20,60));
		btnCancel.setBounds(138, 151, 89, 23);
		panel.add(btnCancel);
		
		JLabel label_2 = new JLabel("$");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		label_2.setForeground(Color.WHITE);
		label_2.setBounds(69, 62, 14, 31);
		panel.add(label_2);
		
		JLabel label_1 = new JLabel("");
		label_1.setBackground(Color.GRAY);
		label_1.setIcon(new ImageIcon("C:\\Users\\Drew\\Desktop\\workspace\\ATM-GroupProject\\img\\bank.png"));
		label_1.setBounds(0, 0, 67, 55);
		contentPane.add(label_1);
		
		JLabel label = new JLabel("");
		label.setBounds(0, 55, 597, 336);
		label.setIcon(new ImageIcon("C:\\Users\\Drew\\Desktop\\workspace\\ATM-GroupProject\\img\\blue.jpg"));
		contentPane.add(label);
		
		JLabel lblGroupBank = new JLabel("G7B");
		lblGroupBank.setFont(new Font("Baskerville Old Face", Font.BOLD, 30));
		lblGroupBank.setForeground(new Color(0,74,111));
		lblGroupBank.setBounds(60, -5, 67, 49);
		contentPane.add(lblGroupBank);
		
		JLabel lblNewLabel = new JLabel("Group7Bank");
		lblNewLabel.setFont(new Font("Baskerville Old Face", Font.BOLD, 25));
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setBounds(59, 33, 149, 24);
		contentPane.add(lblNewLabel);
	
	}
	void userWithdraw(int toSubtract)		//NOT ALL CODE BELONGS IN THIS SECTION
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
			boolean status;
			if(accountInfo[4] == "Active")
				status = true;
			else
				status = false;
			//Begin Withdraw
			balance -=toSubtract;
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

}
