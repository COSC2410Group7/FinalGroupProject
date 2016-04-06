import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;


public class ATM extends JFrame {

	private JPanel contentPane;
	private JTextField inputAccount;
	private JPasswordField passwordField;

	public ATM() {
		setTitle("ATM");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(1000, 1000, 1910, 1244);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		Image wallpaper= new ImageIcon (this.getClass().getResource("blue.jpg")).getImage();
		
		JPanel panel = new JPanel();
		panel.setBounds(559, 363, 785, 609);
		panel.setBackground(new Color(0, 99, 147));
		contentPane.add(panel);
		panel.setLayout(null);
			
				
		JLabel AccountNumber = new JLabel("Account Number");
		AccountNumber.setBounds(149, 28, 508, 71);
		panel.add(AccountNumber);
		AccountNumber.setFont(new Font("Arial Unicode MS", Font.BOLD, 60));
		AccountNumber.setForeground(Color.white);
		
		inputAccount = new JTextField();
		inputAccount.setBounds(149, 114, 490, 95);
		panel.add(inputAccount);
		inputAccount.setColumns(10);
		inputAccount.setFont(new Font("SansSerif", Font.PLAIN, 50));
		
		JLabel Password = new JLabel("Password");
		Password.setBounds(239, 237, 314, 71);
		panel.add(Password);
		Password.setFont(new Font("Arial Unicode MS", Font.BOLD, 60));
		Password.setForeground(Color.white);
		
		JButton btnEnter = new JButton("Enter");
		btnEnter.setBackground(new Color(37, 192, 84));
		btnEnter.setFont(new Font("Arial Unicode MS", Font.BOLD, 60));
		btnEnter.setForeground(Color.white);
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Menu mn=new Menu();
				mn.Transaction();
			}
			});
		btnEnter.setBounds(90, 477, 248, 104);
		panel.add(btnEnter);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBackground(new Color(220, 20, 60));
		btnCancel.setForeground(Color.WHITE);
		btnCancel.setFont(new Font("Arial Unicode MS", Font.BOLD, 60));
		btnCancel.setBounds(458, 477, 248, 104);
		panel.add(btnCancel);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(149, 317, 490, 95);
		panel.add(passwordField);
		passwordField.setFont(new Font("SansSerif", Font.PLAIN, 50));
		
		btnCancel.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent e){
		        inputAccount.setText("");
		    	passwordField.setText("");
		    }
		});
		
		JLabel BankName = new JLabel("G7B");
		BankName.setBounds(167, 19, 401, 80);
		contentPane.add(BankName);
		BankName.setFont(new Font("Baskerville Old Face", Font.BOLD, 90));
		BankName.setForeground(new Color(0, 74, 111));
		Image img= new ImageIcon (this.getClass().getResource("/bank.png")).getImage();
		
		JLabel lblGroupbank = new JLabel("Group7Bank");
		lblGroupbank.setForeground(Color.BLUE);
		lblGroupbank.setFont(new Font("Baskerville Old Face", Font.BOLD, 60));
		lblGroupbank.setBounds(177, 91, 353, 54);
		contentPane.add(lblGroupbank);
		
		JLabel label = new JLabel("");
		label.setBounds(15, -16, 136, 164); //label for logo
		contentPane.add(label);
		label.setIcon(new ImageIcon(img));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 141, 1878, 1015);  //label for wallpaper
		contentPane.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon(wallpaper));
		
		
	}
}
