import javax.swing.JPanel;
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

public class Withdraw extends ATM {

	private static final long serialVersionUID = 1L;
	JPanel contentPaneWithdraw;
	private JTextField textField;
	private JLabel lblWithdrawComplete;
	private JLabel lblInsufficientFunds;
	private JLabel lblInvalidInput;

	public Withdraw() {

		contentPaneWithdraw = new JPanel();
		setContentPane(contentPaneWithdraw);
		contentPaneWithdraw.setLayout(null);

		JLabel lblWithdraw = new JLabel("Withdraw");
		lblWithdraw.setForeground(Color.WHITE);
		lblWithdraw.setBounds(308, 23, 167, 49);
		lblWithdraw.setHorizontalAlignment(SwingConstants.CENTER);
		lblWithdraw.setFont(new Font("Tahoma", Font.PLAIN, 40));
		contentPaneWithdraw.add(lblWithdraw);

		lblInvalidInput = new JLabel("Invalid Input");
		lblInvalidInput.setBounds(243, 368, 298, 43);
		contentPaneWithdraw.add(lblInvalidInput);
		lblInvalidInput.setForeground(new Color(255, 0, 51));
		lblInvalidInput.setHorizontalAlignment(SwingConstants.CENTER);
		lblInvalidInput.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblInvalidInput.setVisible(false);

		lblWithdrawComplete = new JLabel("Withdrawal complete!");
		lblWithdrawComplete.setBounds(243, 368, 328, 43);
		lblWithdrawComplete.setForeground(new Color(0, 204, 0));
		lblWithdrawComplete.setHorizontalAlignment(SwingConstants.CENTER);
		lblWithdrawComplete.setFont(new Font("Tahoma", Font.PLAIN, 32));
		contentPaneWithdraw.add(lblWithdrawComplete);
		lblWithdrawComplete.setVisible(false);

		lblInsufficientFunds = new JLabel("Insufficient Funds.");
		lblInsufficientFunds.setHorizontalAlignment(SwingConstants.CENTER);
		lblInsufficientFunds.setForeground(new Color(255, 0, 0));
		lblInsufficientFunds.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblInsufficientFunds.setBounds(248, 368, 288, 43);
		contentPaneWithdraw.add(lblInsufficientFunds);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 99, 147));
		panel.setBounds(107, 84, 569, 292);
		contentPaneWithdraw.add(panel);
		panel.setLayout(null);

		JPanel darkerPanel = new JPanel();
		darkerPanel.setBounds(20, 21, 530, 82);
		panel.add(darkerPanel);
		darkerPanel.setBackground(new Color(0, 51, 102));
		darkerPanel.setLayout(null);

		JButton btnWithdrawbutton = new JButton("Withdraw");
		btnWithdrawbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tryWithdraw(accountInfo);				//TESTING
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
		textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField.setHorizontalAlignment(SwingConstants.LEFT);
		textField.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyCode() == KeyEvent.VK_ENTER){
					tryWithdraw(accountInfo);
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

		JButton btnWith20 = new JButton("$20");
		btnWith20.setBounds(20, 114, 170, 75);
		panel.add(btnWith20);
		btnWith20.setBackground(new Color(0, 51, 102));
		btnWith20.setForeground(Color.WHITE);
		btnWith20.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				withdraw(20);
			}
		});
		btnWith20.setFont(new Font("Tahoma", Font.PLAIN, 30));

		JButton btnWith40 = new JButton("$40");
		btnWith40.setBounds(200, 114, 170, 75);
		panel.add(btnWith40);
		btnWith40.setBackground(new Color(0, 51, 102));
		btnWith40.setForeground(Color.WHITE);
		btnWith40.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				withdraw(40);
			}
		});
		btnWith40.setFont(new Font("Tahoma", Font.PLAIN, 30));

		JButton btnWith60 = new JButton("$60");
		btnWith60.setBounds(380, 114, 170, 75);
		panel.add(btnWith60);
		btnWith60.setBackground(new Color(0, 51, 102));
		btnWith60.setForeground(Color.WHITE);
		btnWith60.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				withdraw(60);
			}
		});
		btnWith60.setFont(new Font("Tahoma", Font.PLAIN, 30));

		JButton btnReturn = new JButton("Return");
		btnReturn.setBounds(380, 200, 170, 75);
		panel.add(btnReturn);
		btnReturn.setForeground(Color.WHITE);
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField.setText("");
				login.CardLayout.removeAll();
				login.CardLayout.add(menu.contentPaneMenu);
				login.CardLayout.revalidate();
				login.CardLayout.repaint();
			}
		});
		btnReturn.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnReturn.setBackground(new Color(255, 0, 51));

		JButton btnWith100 = new JButton("$100");
		btnWith100.setBounds(200, 200, 170, 75);
		panel.add(btnWith100);
		btnWith100.setBackground(new Color(0, 51, 102));
		btnWith100.setForeground(Color.WHITE);
		btnWith100.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				withdraw(100);
			}
		});
		btnWith100.setFont(new Font("Tahoma", Font.PLAIN, 30));

		JButton btnWith80 = new JButton("$80");
		btnWith80.setBounds(20, 200, 170, 75);
		panel.add(btnWith80);
		btnWith80.setBackground(new Color(0, 51, 102));
		btnWith80.setForeground(Color.WHITE);
		btnWith80.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				withdraw(80);
			}
		});
		btnWith80.setFont(new Font("Tahoma", Font.PLAIN, 30));

		JLabel lblBg = new JLabel("");
		lblBg.setIcon(new ImageIcon(Withdraw.class.getResource("/blue.jpg")));
		lblBg.setBounds(0, 0, 784, 411);
		contentPaneWithdraw.add(lblBg);
		lblInsufficientFunds.setVisible(false);

	}

	public void tryWithdraw(String[] accountInfo)	{

		int userWithdraw = 0;
		
		try{
			userWithdraw = Integer.parseInt(textField.getText());
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
		catch(NumberFormatException e1){
			lblInvalidInput.setVisible(true);
			ActionListener erase = new ActionListener() {
				public void actionPerformed(ActionEvent e){
					lblInvalidInput.setVisible(false);
				}
			};
			Timer error = new Timer(1000,erase);
			error.start();
			error.setRepeats(false);
			textField.setText("");
		}
	}

	public void withdraw(int newAmt)	{

		int balance = Integer.parseInt(accountInfo[3]);
		balance-=newAmt;
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
			balance+=newAmt;
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
