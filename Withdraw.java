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
import javax.swing.ImageIcon;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;

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
		lblWithdraw.setForeground(Color.WHITE);
		lblWithdraw.setBounds(321, 23, 167, 49);
		lblWithdraw.setHorizontalAlignment(SwingConstants.CENTER);
		lblWithdraw.setFont(new Font("Tahoma", Font.PLAIN, 40));
		contentPaneWithdraw.add(lblWithdraw);
		
		JButton btnWith20 = new JButton("$20");
		btnWith20.setBackground(new Color(0, 51, 102));
		btnWith20.setForeground(Color.WHITE);
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
		btnWith20.setBounds(125, 182, 170, 75);
		btnWith20.setFont(new Font("Tahoma", Font.PLAIN, 30));
		contentPaneWithdraw.add(btnWith20);
		
		JButton btnWith60 = new JButton("$60");
		btnWith60.setBackground(new Color(0, 51, 102));
		btnWith60.setForeground(Color.WHITE);
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
		
		JButton btnWith40 = new JButton("$40");
		btnWith40.setBackground(new Color(0, 51, 102));
		btnWith40.setForeground(Color.WHITE);
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
		btnWith40.setBounds(305, 182, 170, 75);
		btnWith40.setFont(new Font("Tahoma", Font.PLAIN, 30));
		contentPaneWithdraw.add(btnWith40);
		btnWith60.setBounds(485, 182, 170, 75);
		btnWith60.setFont(new Font("Tahoma", Font.PLAIN, 30));
		contentPaneWithdraw.add(btnWith60);
		
		JButton btnWith80 = new JButton("$80");
		btnWith80.setBackground(new Color(0, 51, 102));
		btnWith80.setForeground(Color.WHITE);
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
		btnWith80.setBounds(125, 268, 170, 75);
		btnWith80.setFont(new Font("Tahoma", Font.PLAIN, 30));
		contentPaneWithdraw.add(btnWith80);
		
		JButton btnWith100 = new JButton("$100");
		btnWith100.setBackground(new Color(0, 51, 102));
		btnWith100.setForeground(Color.WHITE);
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
		btnWith100.setBounds(305, 268, 170, 75);
		btnWith100.setFont(new Font("Tahoma", Font.PLAIN, 30));
		contentPaneWithdraw.add(btnWith100);
		
		JButton btnReturn = new JButton("Return");
		btnReturn.setForeground(Color.WHITE);
		btnReturn.setBounds(485, 268, 170, 75);
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
		
		lblWithdrawComplete = new JLabel("Withdraw complete");
		lblWithdrawComplete.setBounds(222, 351, 340, 49);
		lblWithdrawComplete.setForeground(new Color(0, 204, 0));
		lblWithdrawComplete.setHorizontalAlignment(SwingConstants.CENTER);
		lblWithdrawComplete.setFont(new Font("Tahoma", Font.PLAIN, 40));
		contentPaneWithdraw.add(lblWithdrawComplete);
		lblWithdrawComplete.setVisible(false);
		
		lblInsufficientFunds = new JLabel("Insufficient Funds.");
		lblInsufficientFunds.setHorizontalAlignment(SwingConstants.CENTER);
		lblInsufficientFunds.setForeground(new Color(255, 0, 0));
		lblInsufficientFunds.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblInsufficientFunds.setBounds(229, 351, 325, 49);
		contentPaneWithdraw.add(lblInsufficientFunds);
		
		JPanel darkerPanel = new JPanel();
		darkerPanel.setBackground(new Color(0, 51, 102));
		darkerPanel.setBounds(125, 89, 530, 82);
		contentPaneWithdraw.add(darkerPanel);
		darkerPanel.setLayout(null);
		
		JButton btnWithdrawbutton = new JButton("Withdraw");
		btnWithdrawbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

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
		});
		btnWithdrawbutton.setBounds(357, 9, 163, 64);
		darkerPanel.add(btnWithdrawbutton);
		btnWithdrawbutton.setForeground(Color.WHITE);
		btnWithdrawbutton.setBackground(Color.GREEN);
		btnWithdrawbutton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		
		textField = new JTextField();
		textField.setBounds(190, 30, 157, 23);
		darkerPanel.add(textField);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 30));
		textField.setHorizontalAlignment(SwingConstants.LEFT);
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
		textField.setColumns(10);
		
		JLabel lblCustom = new JLabel("Custom Amount: $");
		lblCustom.setBounds(10, 28, 195, 25);
		darkerPanel.add(lblCustom);
		lblCustom.setForeground(Color.WHITE);
		lblCustom.setHorizontalAlignment(SwingConstants.LEFT);
		lblCustom.setFont(new Font("Tahoma", Font.PLAIN, 21));
		darkerPanel.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{textField, btnWithdrawbutton, lblCustom}));
		
		JLabel lblBg = new JLabel("");
		lblBg.setIcon(new ImageIcon("img\\blue.jpg"));
		lblBg.setBounds(0, 0, 784, 411);
		contentPaneWithdraw.add(lblBg);
		contentPaneWithdraw.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{btnWith20, btnWith40, btnWith60, btnWith80, btnWith100, btnReturn, lblWithdrawComplete, lblInsufficientFunds, textField, btnWithdrawbutton, lblWithdraw, darkerPanel, lblCustom, lblBg}));
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{btnWith20, btnWith40, btnWith60, btnWith80, btnWith100, btnReturn, lblWithdrawComplete, lblInsufficientFunds, textField, btnWithdrawbutton, contentPaneWithdraw, lblWithdraw, darkerPanel, lblCustom, lblBg}));
		lblInsufficientFunds.setVisible(false);
	}
}