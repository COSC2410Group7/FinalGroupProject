import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Withdraw extends ATM {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel contentPaneWithdraw;
	private JTextField textField;
	private JLabel lblWithdrawComplete;
	private JLabel lblInsufficientFunds;

	public Withdraw() {
		setTitle("Withdraw");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 800, 450);
		contentPaneWithdraw = new JPanel();
		contentPaneWithdraw.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPaneWithdraw);
		contentPaneWithdraw.setLayout(null);
		
		JLabel lblWithdraw = new JLabel("Withdraw");
		lblWithdraw.setBounds(210, 32, 380, 49);
		lblWithdraw.setHorizontalAlignment(SwingConstants.CENTER);
		lblWithdraw.setFont(new Font("Tahoma", Font.PLAIN, 40));
		contentPaneWithdraw.add(lblWithdraw);
		
		JButton btnWith20 = new JButton("$20");
		btnWith20.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int balance = Integer.parseInt(accountInfo[3]);
				balance-=20;
				if (balance>0){
					String convert = new String(Integer.toString(balance));
					accountInfo[3]=convert;
					PrintWriter writer;
					try {
						writer = new PrintWriter(new FileOutputStream("AccountInformation.txt"));
						BufferedWriter bwriter = new BufferedWriter(writer);
						for(int i=0;i<5;i++){
							bwriter.write(accountInfo[i]);
							if(i!=4)
								bwriter.newLine();
						}
						bwriter.close();
					}
					catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					lblWithdrawComplete.setVisible(true);
					ActionListener erase = new ActionListener() {
						public void actionPerformed(ActionEvent e){
							lblWithdrawComplete.setVisible(false);
						}
					};
					Timer error = new Timer(1000,erase);
					error.start();
					error.setRepeats(false);
					textField.setText("");
				}
				else{
					balance+=20;
					lblInsufficientFunds.setVisible(true);
					ActionListener erase = new ActionListener() {
						public void actionPerformed(ActionEvent e){
							lblInsufficientFunds.setVisible(false);
						}
					};
					Timer error = new Timer(1000,erase);
					error.start();
					error.setRepeats(false);
				}
			}
		});
		btnWith20.setBounds(10, 84, 170, 75);
		btnWith20.setFont(new Font("Tahoma", Font.PLAIN, 30));
		contentPaneWithdraw.add(btnWith20);
		
		JButton btnWith40 = new JButton("$40");
		btnWith40.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int balance = Integer.parseInt(accountInfo[3]);
				balance-=40;
				if (balance>0){
					String convert = new String(Integer.toString(balance));
					accountInfo[3]=convert;
					PrintWriter writer;
					try {
						writer = new PrintWriter(new FileOutputStream("AccountInformation.txt"));
						BufferedWriter bwriter = new BufferedWriter(writer);
						for(int i=0;i<5;i++){
							bwriter.write(accountInfo[i]);
							if(i!=4)
								bwriter.newLine();
						}
						bwriter.close();
					}
					catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					lblWithdrawComplete.setVisible(true);
					ActionListener erase = new ActionListener() {
						public void actionPerformed(ActionEvent e){
							lblWithdrawComplete.setVisible(false);
						}
					};
					Timer error = new Timer(1000,erase);
					error.start();
					error.setRepeats(false);
					textField.setText("");
				}
				else{
					balance+=40;
					lblInsufficientFunds.setVisible(true);
					ActionListener erase = new ActionListener() {
						public void actionPerformed(ActionEvent e){
							lblInsufficientFunds.setVisible(false);
						}
					};
					Timer error = new Timer(1000,erase);
					error.start();
					error.setRepeats(false);
				}
			}
		});
		btnWith40.setBounds(315, 84, 170, 75);
		btnWith40.setFont(new Font("Tahoma", Font.PLAIN, 30));
		contentPaneWithdraw.add(btnWith40);
		
		JButton btnWith60 = new JButton("$60");
		btnWith60.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int balance = Integer.parseInt(accountInfo[3]);
				balance-=60;
				if (balance>0){
					String convert = new String(Integer.toString(balance));
					accountInfo[3]=convert;
					PrintWriter writer;
					try {
						writer = new PrintWriter(new FileOutputStream("AccountInformation.txt"));
						BufferedWriter bwriter = new BufferedWriter(writer);
						for(int i=0;i<5;i++){
							bwriter.write(accountInfo[i]);
							if(i!=4)
								bwriter.newLine();
						}
						bwriter.close();
					}
					catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					lblWithdrawComplete.setVisible(true);
					ActionListener erase = new ActionListener() {
						public void actionPerformed(ActionEvent e){
							lblWithdrawComplete.setVisible(false);
						}
					};
					Timer error = new Timer(1000,erase);
					error.start();
					error.setRepeats(false);
					textField.setText("");
				}
				else{
					balance+=60;
					lblInsufficientFunds.setVisible(true);
					ActionListener erase = new ActionListener() {
						public void actionPerformed(ActionEvent e){
							lblInsufficientFunds.setVisible(false);
						}
					};
					Timer error = new Timer(1000,erase);
					error.start();
					error.setRepeats(false);
				}
			}
		});
		btnWith60.setBounds(604, 84, 170, 75);
		btnWith60.setFont(new Font("Tahoma", Font.PLAIN, 30));
		contentPaneWithdraw.add(btnWith60);
		
		JButton btnWith80 = new JButton("$80");
		btnWith80.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int balance = Integer.parseInt(accountInfo[3]);
				balance-=80;
				if (balance>0){
					String convert = new String(Integer.toString(balance));
					accountInfo[3]=convert;
					PrintWriter writer;
					try {
						writer = new PrintWriter(new FileOutputStream("AccountInformation.txt"));
						BufferedWriter bwriter = new BufferedWriter(writer);
						for(int i=0;i<5;i++){
							bwriter.write(accountInfo[i]);
							if(i!=4)
								bwriter.newLine();
						}
						bwriter.close();
					}
					catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					lblWithdrawComplete.setVisible(true);
					ActionListener erase = new ActionListener() {
						public void actionPerformed(ActionEvent e){
							lblWithdrawComplete.setVisible(false);
						}
					};
					Timer error = new Timer(1000,erase);
					error.start();
					error.setRepeats(false);
					textField.setText("");
				}
				else{
					balance+=80;
					lblInsufficientFunds.setVisible(true);
					ActionListener erase = new ActionListener() {
						public void actionPerformed(ActionEvent e){
							lblInsufficientFunds.setVisible(false);
						}
					};
					Timer error = new Timer(1000,erase);
					error.start();
					error.setRepeats(false);
				}
			}
		});
		btnWith80.setBounds(10, 170, 170, 75);
		btnWith80.setFont(new Font("Tahoma", Font.PLAIN, 30));
		contentPaneWithdraw.add(btnWith80);
		
		JButton btnWith100 = new JButton("$100");
		btnWith100.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int balance = Integer.parseInt(accountInfo[3]);
				balance-=100;
				if (balance>0){
					String convert = new String(Integer.toString(balance));
					accountInfo[3]=convert;
					PrintWriter writer;
					try {
						writer = new PrintWriter(new FileOutputStream("AccountInformation.txt"));
						BufferedWriter bwriter = new BufferedWriter(writer);
						for(int i=0;i<5;i++){
							bwriter.write(accountInfo[i]);
							if(i!=4)
								bwriter.newLine();
						}
						bwriter.close();
					}
					catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					lblWithdrawComplete.setVisible(true);
					ActionListener erase = new ActionListener() {
						public void actionPerformed(ActionEvent e){
							lblWithdrawComplete.setVisible(false);
						}
					};
					Timer error = new Timer(1000,erase);
					error.start();
					error.setRepeats(false);
					textField.setText("");
				}
				else{
					balance+=100;
					lblInsufficientFunds.setVisible(true);
					ActionListener erase = new ActionListener() {
						public void actionPerformed(ActionEvent e){
							lblInsufficientFunds.setVisible(false);
						}
					};
					Timer error = new Timer(1000,erase);
					error.start();
					error.setRepeats(false);
				}
			}
		});
		btnWith100.setBounds(315, 170, 170, 75);
		btnWith100.setFont(new Font("Tahoma", Font.PLAIN, 30));
		contentPaneWithdraw.add(btnWith100);
		
		JButton btnReturn = new JButton("Return");
		btnReturn.setBounds(612, 333, 162, 67);
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField.setText("");
				login.panel.removeAll();
				login.panel.add(menu.contentPaneMenu);
				login.panel.revalidate();
				login.panel.repaint();
			}
		});
		btnReturn.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnReturn.setBackground(new Color(255, 0, 51));
		contentPaneWithdraw.add(btnReturn);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 30));
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyCode() == KeyEvent.VK_ENTER){
					int userWithdraw = Integer.parseInt(textField.getText());
					int balance = Integer.parseInt(accountInfo[3]);
					balance-=userWithdraw;
					if (balance>0){
						String convert = new String(Integer.toString(balance));
						accountInfo[3]=convert;
						PrintWriter writer;
						try {
							writer = new PrintWriter(new FileOutputStream("AccountInformation.txt"));
							BufferedWriter bwriter = new BufferedWriter(writer);
							for(int i=0;i<5;i++){
								bwriter.write(accountInfo[i]);
								if(i!=4)
									bwriter.newLine();
							}
							bwriter.close();
						}
						catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						lblWithdrawComplete.setVisible(true);
						ActionListener erase = new ActionListener() {
							public void actionPerformed(ActionEvent e){
								lblWithdrawComplete.setVisible(false);
							}
						};
						Timer error = new Timer(1000,erase);
						error.start();
						error.setRepeats(false);
						textField.setText("");
					}
					else{
						balance+=userWithdraw;
						lblInsufficientFunds.setVisible(true);
						ActionListener erase = new ActionListener() {
							public void actionPerformed(ActionEvent e){
								lblInsufficientFunds.setVisible(false);
							}
						};
						Timer error = new Timer(1000,erase);
						error.start();
						error.setRepeats(false);
					}
				}
			}
		});
		textField.setBounds(314, 251, 171, 75);
		contentPaneWithdraw.add(textField);
		textField.setColumns(10);
		
		JLabel lblCustom = new JLabel("Custom Amount:");
		lblCustom.setBounds(104, 247, 200, 75);
		lblCustom.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCustom.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPaneWithdraw.add(lblCustom);
		
		lblWithdrawComplete = new JLabel("Withdraw complete");
		lblWithdrawComplete.setBounds(217, 333, 373, 67);
		lblWithdrawComplete.setForeground(new Color(0, 204, 0));
		lblWithdrawComplete.setHorizontalAlignment(SwingConstants.CENTER);
		lblWithdrawComplete.setFont(new Font("Tahoma", Font.PLAIN, 40));
		contentPaneWithdraw.add(lblWithdrawComplete);
		lblWithdrawComplete.setVisible(false);
		
		lblInsufficientFunds = new JLabel("Insufficient Funds.");
		lblInsufficientFunds.setHorizontalAlignment(SwingConstants.CENTER);
		lblInsufficientFunds.setForeground(new Color(255, 0, 0));
		lblInsufficientFunds.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblInsufficientFunds.setBounds(217, 333, 373, 67);
		contentPaneWithdraw.add(lblInsufficientFunds);
		lblInsufficientFunds.setVisible(false);
	}
}