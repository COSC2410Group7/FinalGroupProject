import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JPasswordField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.awt.CardLayout;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
public class Login extends ATM {
	
	private static final long serialVersionUID = 1L;
	private JTextField accountField;
	private JPasswordField passwordField;
	private JLabel lblError;
	private int attemptCount=0;
	public JPanel panel;
	JPanel contentPaneLogin;
	private JLabel lblYourAccountIs;
	private JLabel lblBackground;
	private JPanel panel_2;
	private JLabel lblNewLabel;
	public Login() {
		setForeground(new Color(0, 153, 204));
		setIconImage(Toolkit.getDefaultToolkit().getImage("img\\blue.jpg"));
		setTitle("ATM");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 250, 800, 450);
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(panel);
		panel.setLayout(new CardLayout(0, 0));
		
		contentPaneLogin = new JPanel();
		panel.add(contentPaneLogin, "name_2096823609730483");
		contentPaneLogin.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 99, 147));
		panel_1.setBounds(172, 51, 439, 308);
		contentPaneLogin.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(47, 228, 166, 69);
		panel_1.add(btnLogin);
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 40));
		btnLogin.setBackground(Color.GREEN);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				accountField.setText("");
				passwordField.setText("");
				
			}
		});
		btnClear.setForeground(Color.WHITE);
		btnClear.setFont(new Font("Tahoma", Font.PLAIN, 40));
		btnClear.setBackground(Color.RED);
		btnClear.setBounds(223, 228, 166, 69);
		panel_1.add(btnClear);
		
		panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 51, 102));
		panel_2.setBounds(15, 114, 408, 103);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblAccountNumber = new JLabel("Account Number:");
		lblAccountNumber.setBounds(13, 12, 194, 31);
		panel_2.add(lblAccountNumber);
		lblAccountNumber.setForeground(Color.WHITE);
		lblAccountNumber.setFont(new Font("Tahoma", Font.PLAIN, 22));
		
		accountField = new JTextField();
		accountField.setBounds(196, 18, 194, 25);
		panel_2.add(accountField);
		accountField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyCode() == KeyEvent.VK_ENTER){
					if(accountInfo[4].equals("Active")){
						if (accountField.getText().equals(ATM.accountPW[0]) && Arrays.equals(passwordField.getPassword(), Password)){
							login.panel.remove(contentPaneLogin);
							login.panel.add(menu.contentPaneMenu);
							login.panel.revalidate();
							login.panel.repaint();
							attemptCount=0;
						}
						else{
							attemptCount++;
							if (attemptCount == 3){
								lblYourAccountIs.setVisible(true);
								ActionListener erase = new ActionListener() {
									public void actionPerformed(ActionEvent e){
										lblYourAccountIs.setVisible(false);
									}
								};
								Timer error = new Timer(10000,erase);
								error.start();
								error.setRepeats(false);
								
								String status = new String();
								status = "Inactive";
								accountInfo[4]=status;
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
									// 	TODO Auto-generated catch block
									e1.printStackTrace();
								}
								ActionListener recovery = new ActionListener() {
									public void actionPerformed(ActionEvent e){
										String status = "Active";
										accountInfo[4]=status;
										PrintWriter writer;
										try{
											writer = new PrintWriter(new FileOutputStream("AccountInformation.txt"));
											BufferedWriter bwriter = new BufferedWriter(writer);
											for(int i=0;i<5;i++){
												bwriter.write(accountInfo[i]);
												if(i!=4)
													bwriter.newLine();
											}
											bwriter.close();
											attemptCount=0;
										}
										catch (IOException e1) {
											// TODO Auto-generated catch block
											e1.printStackTrace();
										}
									}
								};
								Timer changeStatus = new Timer(10000,recovery);
								changeStatus.start();
								changeStatus.setRepeats(false);
							}
							lblError.setVisible(true);
							ActionListener erase = new ActionListener() {
								public void actionPerformed(ActionEvent e){
									lblError.setVisible(false);
								}
							};
							Timer error = new Timer(1000,erase);
							error.start();
							error.setRepeats(false);
						}
						accountField.setText("");
						passwordField.setText("");
					}
				}
			}
		});
		accountField.setHorizontalAlignment(SwingConstants.LEFT);
		accountField.setFont(new Font("Tahoma", Font.PLAIN, 22));
		accountField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(196, 54, 194, 25);
		panel_2.add(passwordField);
		passwordField.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER){
					if(accountInfo[4].equals("Active")){
						if (accountField.getText().equals(ATM.accountPW[0]) && Arrays.equals(passwordField.getPassword(), Password)){
							login.panel.remove(contentPaneLogin);
							login.panel.add(menu.contentPaneMenu);
							login.panel.revalidate();
							login.panel.repaint();
							attemptCount=0;
						}
						else{
							attemptCount++;
							if (attemptCount == 3){
								lblYourAccountIs.setVisible(true);
								ActionListener erase = new ActionListener() {
									public void actionPerformed(ActionEvent e){
										lblYourAccountIs.setVisible(false);
									}
								};
								Timer error = new Timer(10000,erase);
								error.start();
								error.setRepeats(false);
								
								String status = new String();
								status = "Inactive";
								accountInfo[4]=status;
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
									// 	TODO Auto-generated catch block
									e1.printStackTrace();
								}
								ActionListener recovery = new ActionListener() {
									public void actionPerformed(ActionEvent e){
										String status = "Active";
										accountInfo[4]=status;
										PrintWriter writer;
										try{
											writer = new PrintWriter(new FileOutputStream("AccountInformation.txt"));
											BufferedWriter bwriter = new BufferedWriter(writer);
											for(int i=0;i<5;i++){
												bwriter.write(accountInfo[i]);
												if(i!=4)
													bwriter.newLine();
											}
											bwriter.close();
											attemptCount=0;
										}
										catch (IOException e1) {
											// TODO Auto-generated catch block
											e1.printStackTrace();
										}
									}
								};
								Timer changeStatus = new Timer(10000,recovery);
								changeStatus.start();
								changeStatus.setRepeats(false);
							}
							lblError.setVisible(true);
							ActionListener erase = new ActionListener() {
								public void actionPerformed(ActionEvent e){
									lblError.setVisible(false);
								}
							};
							Timer error = new Timer(1000,erase);
							error.start();
							error.setRepeats(false);
						}
						accountField.setText("");
						passwordField.setText("");
					}
				}
			}
		});
		passwordField.setHorizontalAlignment(SwingConstants.LEFT);
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 22));
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(81, 54, 100, 27);
		panel_2.add(lblPassword);
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 22));
		
		lblError = new JLabel("Invalid Credentials");
		lblError.setBounds(137, 81, 133, 25);
		panel_2.add(lblError);
		lblError.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblError.setForeground(new Color(255, 0, 51));
		lblError.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblYourAccountIs = new JLabel("Your account has been disabled for 10 seconds.");
		lblYourAccountIs.setBounds(24, 82, 360, 22);
		panel_2.add(lblYourAccountIs);
		lblYourAccountIs.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblYourAccountIs.setForeground(new Color(255, 0, 0));
		lblYourAccountIs.setHorizontalAlignment(SwingConstants.CENTER);
		lblYourAccountIs.setVisible(false);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("img\\newlogo.png"));
		lblNewLabel.setBounds(130, 0, 191, 131);
		panel_1.add(lblNewLabel);
		panel_1.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{accountField, passwordField, btnLogin, btnClear, panel_2, lblAccountNumber, lblPassword, lblError, lblYourAccountIs, lblNewLabel}));
		lblError.setVisible(false);
		
		lblBackground = new JLabel("");
		lblBackground.setBounds(0, 0, 784, 411);
		contentPaneLogin.add(lblBackground);
		lblBackground.setIcon(new ImageIcon("img\\blue.jpg"));
		contentPaneLogin.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{accountField, passwordField, btnLogin, btnClear, panel_1, panel_2, lblAccountNumber, lblPassword, lblError, lblYourAccountIs, lblNewLabel, lblBackground}));
		panel.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{accountField, passwordField, btnLogin, btnClear, contentPaneLogin, panel_1, panel_2, lblAccountNumber, lblPassword, lblError, lblYourAccountIs, lblNewLabel, lblBackground}));
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{accountField, passwordField, btnLogin, btnClear, panel, contentPaneLogin, panel_1, panel_2, lblAccountNumber, lblPassword, lblError, lblYourAccountIs, lblNewLabel, lblBackground}));
		
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(accountInfo[4].equals("Active")){
					if (accountField.getText().equals(ATM.accountPW[0]) && Arrays.equals(passwordField.getPassword(), Password)){
						login.panel.remove(contentPaneLogin);
						login.panel.add(menu.contentPaneMenu);
						login.panel.revalidate();
						login.panel.repaint();
						attemptCount=0;
					}
					else{
						attemptCount++;
						if (attemptCount == 3){
							lblYourAccountIs.setVisible(true);
							ActionListener erase = new ActionListener() {
								public void actionPerformed(ActionEvent e){
									lblYourAccountIs.setVisible(false);
								}
							};
							Timer error = new Timer(10000,erase);
							error.start();
							error.setRepeats(false);	//timer applies to actionlistener erase
							
							String status = new String();
							status = "Inactive";
							accountInfo[4]=status;
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
								// 	TODO Auto-generated catch block
								e1.printStackTrace();
							}
							ActionListener recovery = new ActionListener() {
								public void actionPerformed(ActionEvent e){
									String status = "Active";
									accountInfo[4]=status;
									PrintWriter writer;
									try{
										writer = new PrintWriter(new FileOutputStream("AccountInformation.txt"));
										BufferedWriter bwriter = new BufferedWriter(writer);
										for(int i=0;i<5;i++){
											bwriter.write(accountInfo[i]);
											if(i!=4)
												bwriter.newLine();
										}
										bwriter.close();
										attemptCount=0;
									}
									catch (IOException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
								}
							};
							Timer changeStatus = new Timer(10000,recovery);
							changeStatus.start();
							changeStatus.setRepeats(false);
						}
						if(attemptCount != 3)
							lblError.setVisible(true);
						else
							;
						ActionListener erase = new ActionListener() {
							public void actionPerformed(ActionEvent e){
								lblError.setVisible(false);
							}
						};
						Timer error = new Timer(1000,erase);
						error.start();
						error.setRepeats(false);
					}
					accountField.setText("");
					passwordField.setText("");
				}
			}
		});
	}
}