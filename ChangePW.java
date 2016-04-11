import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.awt.event.ActionEvent;

public class ChangePW extends ATM {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel contentPaneChangePW;
	private JPasswordField passwordFieldCurrent;
	private JPasswordField passwordFieldNew;
	private JPasswordField passwordFieldConfirmNew;
	private JLabel lblPasswordSuccessfullyChanged;
	private JButton btnOK;
	private JLabel lblInvalidPassword;
	private JLabel lblPasswordsNoMatch;

	public ChangePW() {
		setTitle("Change Password");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 800, 450);
		contentPaneChangePW = new JPanel();
		contentPaneChangePW.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPaneChangePW);
		contentPaneChangePW.setLayout(null);
		
		JLabel lblChangePassword = new JLabel("Change Password");
		lblChangePassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblChangePassword.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblChangePassword.setBounds(209, 11, 380, 49);
		contentPaneChangePW.add(lblChangePassword);
		
		JLabel lblCurrentPassword = new JLabel("Current Password:");
		lblCurrentPassword.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblCurrentPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblCurrentPassword.setBounds(10, 71, 359, 75);
		contentPaneChangePW.add(lblCurrentPassword);
		
		passwordFieldCurrent = new JPasswordField();
		passwordFieldCurrent.setFont(new Font("Tahoma", Font.PLAIN, 30));
		passwordFieldCurrent.setBounds(379, 71, 339, 75);
		contentPaneChangePW.add(passwordFieldCurrent);
		
		JLabel lblNewPassword = new JLabel("New Password:");
		lblNewPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewPassword.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewPassword.setBounds(10, 157, 359, 75);
		contentPaneChangePW.add(lblNewPassword);
		
		JLabel lblConfrimNew = new JLabel("Confirm New Password:");
		lblConfrimNew.setHorizontalAlignment(SwingConstants.CENTER);
		lblConfrimNew.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblConfrimNew.setBounds(10, 243, 359, 75);
		contentPaneChangePW.add(lblConfrimNew);
		
		passwordFieldNew = new JPasswordField();
		passwordFieldNew.setFont(new Font("Tahoma", Font.PLAIN, 30));
		passwordFieldNew.setBounds(379, 157, 339, 75);
		contentPaneChangePW.add(passwordFieldNew);
		
		passwordFieldConfirmNew = new JPasswordField();
		passwordFieldConfirmNew.setFont(new Font("Tahoma", Font.PLAIN, 30));
		passwordFieldConfirmNew.setBounds(379, 251, 339, 75);
		contentPaneChangePW.add(passwordFieldConfirmNew);
		
		JButton button = new JButton("Return");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				passwordFieldCurrent.setText("");
				passwordFieldNew.setText("");
				passwordFieldConfirmNew.setText("");
				login.panel.removeAll();
				login.panel.add(menu.contentPaneMenu);
				login.panel.revalidate();
				login.panel.repaint();
			}
		});
		button.setFont(new Font("Tahoma", Font.PLAIN, 30));
		button.setBackground(new Color(255, 0, 51));
		button.setBounds(612, 333, 162, 67);
		contentPaneChangePW.add(button);
		
		lblPasswordSuccessfullyChanged = new JLabel("Password successfully changed!");
		lblPasswordSuccessfullyChanged.setForeground(new Color(0, 204, 51));
		lblPasswordSuccessfullyChanged.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblPasswordSuccessfullyChanged.setHorizontalAlignment(SwingConstants.CENTER);
		lblPasswordSuccessfullyChanged.setBounds(171, 342, 430, 49);
		contentPaneChangePW.add(lblPasswordSuccessfullyChanged);
		lblPasswordSuccessfullyChanged.setVisible(false);
		
		btnOK = new JButton("OK");
		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Arrays.equals(passwordFieldCurrent.getPassword(),Password)){
					if(Arrays.equals(passwordFieldNew.getPassword(), passwordFieldConfirmNew.getPassword())){
						try {
							PrintWriter writer = new PrintWriter(new FileOutputStream("Password.txt"));
							BufferedWriter bwriter = new BufferedWriter(writer);
							ATM.Password = passwordFieldNew.getPassword();
							String convert = new String(ATM.Password);
							ATM.accountPW[1] = convert;
							System.out.println(ATM.accountPW[1]);
							for (int i=0;i<2;i++){
								bwriter.write(ATM.accountPW[i]);
								if (i==0)
								bwriter.write(" ");
							}
							bwriter.close();
						}
						catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						lblPasswordSuccessfullyChanged.setVisible(true);
						ActionListener erase = new ActionListener() {
							public void actionPerformed(ActionEvent e){
								lblPasswordSuccessfullyChanged.setVisible(false);
							}
						};
						Timer error = new Timer(1000,erase);
						error.start();
						error.setRepeats(false);
					}
					else{
						lblPasswordsNoMatch.setVisible(true);
						ActionListener erase = new ActionListener() {
							public void actionPerformed(ActionEvent e){
								lblPasswordsNoMatch.setVisible(false);
							}
						};
						Timer error = new Timer(1000,erase);
						error.start();
						error.setRepeats(false);
					}
				}
				else{
					lblInvalidPassword.setVisible(true);
					ActionListener erase = new ActionListener() {
						public void actionPerformed(ActionEvent e){
							lblInvalidPassword.setVisible(false);
						}
					};
					Timer error = new Timer(1000,erase);
					error.start();
					error.setRepeats(false);
				}
				passwordFieldCurrent.setText("");
				passwordFieldNew.setText("");
				passwordFieldConfirmNew.setText("");
			}
		});
		btnOK.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnOK.setBackground(new Color(51, 204, 0));
		btnOK.setBounds(10, 333, 155, 67);
		contentPaneChangePW.add(btnOK);
		
		lblInvalidPassword = new JLabel("Invalid Password...");
		lblInvalidPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblInvalidPassword.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblInvalidPassword.setForeground(new Color(255, 0, 51));
		lblInvalidPassword.setBounds(171, 333, 431, 67);
		contentPaneChangePW.add(lblInvalidPassword);
		lblInvalidPassword.setVisible(false);
		
		lblPasswordsNoMatch = new JLabel("Passwords do not match.");
		lblPasswordsNoMatch.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblPasswordsNoMatch.setForeground(new Color(255, 204, 51));
		lblPasswordsNoMatch.setHorizontalAlignment(SwingConstants.CENTER);
		lblPasswordsNoMatch.setBounds(171, 329, 431, 71);
		contentPaneChangePW.add(lblPasswordsNoMatch);
		lblPasswordsNoMatch.setVisible(false);
		
	}

}
