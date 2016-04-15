import javax.swing.JPanel;
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
import javax.swing.ImageIcon;
public class ChangePW extends ATM {
	private static final long serialVersionUID = 1L;
	JPanel contentPaneChangePW;
	private JPasswordField passwordFieldCurrent;
	private JPasswordField passwordFieldNew;
	private JPasswordField passwordFieldConfirmNew;
	private JLabel lblPasswordSuccessfullyChanged;
	private JButton btnOK;
	private JLabel lblInvalidPassword;
	private JLabel lblPasswordsNoMatch;
	private JPanel panel_1;

	public ChangePW() {
		contentPaneChangePW = new JPanel();
		setContentPane(contentPaneChangePW);
		contentPaneChangePW.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 99, 147));
		panel.setBounds(122, 70, 539, 330);
		contentPaneChangePW.add(panel);
		panel.setLayout(null);
		
		lblPasswordSuccessfullyChanged = new JLabel("Password successfully changed!");
		lblPasswordSuccessfullyChanged.setBounds(115, 222, 309, 27);
		panel.add(lblPasswordSuccessfullyChanged);
		lblPasswordSuccessfullyChanged.setForeground(new Color(0, 204, 51));
		lblPasswordSuccessfullyChanged.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblPasswordSuccessfullyChanged.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblInvalidPassword = new JLabel("Invalid Password...");
		lblInvalidPassword.setBounds(169, 222, 200, 27);
		panel.add(lblInvalidPassword);
		lblInvalidPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblInvalidPassword.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblInvalidPassword.setForeground(new Color(255, 0, 51));
		
		lblPasswordsNoMatch = new JLabel("Passwords do not match.");
		lblPasswordsNoMatch.setBounds(147, 222, 244, 27);
		panel.add(lblPasswordsNoMatch);
		lblPasswordsNoMatch.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblPasswordsNoMatch.setForeground(new Color(255, 204, 51));
		lblPasswordsNoMatch.setHorizontalAlignment(SwingConstants.CENTER);
		
		btnOK = new JButton("OK");
		btnOK.setBounds(103, 252, 155, 67);
		panel.add(btnOK);
		btnOK.setForeground(Color.WHITE);
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
		btnOK.setFont(new Font("Tahoma", Font.PLAIN, 35));
		btnOK.setBackground(new Color(51, 204, 0));
		
		JButton button = new JButton("Return");
		button.setBounds(284, 252, 162, 67);
		panel.add(button);
		button.setForeground(Color.WHITE);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				passwordFieldCurrent.setText("");
				passwordFieldNew.setText("");
				passwordFieldConfirmNew.setText("");
				login.CardLayout.removeAll();
				login.CardLayout.add(menu.contentPaneMenu);
				login.CardLayout.revalidate();
				login.CardLayout.repaint();
			}
		});
		button.setFont(new Font("Tahoma", Font.PLAIN, 35));
		button.setBackground(new Color(255, 0, 51));
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 51, 102));
		panel_1.setBounds(16, 83, 506, 141);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		passwordFieldConfirmNew = new JPasswordField();
		passwordFieldConfirmNew.setBounds(267, 95, 210, 27);
		panel_1.add(passwordFieldConfirmNew);
		passwordFieldConfirmNew.setFont(new Font("Tahoma", Font.PLAIN, 22));
		
		JLabel lblConfrimNew = new JLabel("Confirm New Password:");
		lblConfrimNew.setBounds(25, 95, 232, 27);
		panel_1.add(lblConfrimNew);
		lblConfrimNew.setForeground(Color.WHITE);
		lblConfrimNew.setHorizontalAlignment(SwingConstants.CENTER);
		lblConfrimNew.setFont(new Font("Tahoma", Font.PLAIN, 22));
		
		passwordFieldNew = new JPasswordField();
		passwordFieldNew.setBounds(267, 57, 210, 27);
		panel_1.add(passwordFieldNew);
		passwordFieldNew.setFont(new Font("Tahoma", Font.PLAIN, 30));
		
		JLabel lblNewPassword = new JLabel("New Password:");
		lblNewPassword.setBounds(107, 57, 150, 27);
		panel_1.add(lblNewPassword);
		lblNewPassword.setForeground(Color.WHITE);
		lblNewPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewPassword.setFont(new Font("Tahoma", Font.PLAIN, 22));
		
		passwordFieldCurrent = new JPasswordField();
		passwordFieldCurrent.setBounds(267, 19, 210, 27);
		panel_1.add(passwordFieldCurrent);
		passwordFieldCurrent.setFont(new Font("Tahoma", Font.PLAIN, 22));
		
		JLabel lblCurrentPassword = new JLabel("Current Password:");
		lblCurrentPassword.setBounds(78, 19, 179, 27);
		panel_1.add(lblCurrentPassword);
		lblCurrentPassword.setForeground(Color.WHITE);
		lblCurrentPassword.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblCurrentPassword.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblChangePassword = new JLabel("Change Password");
		lblChangePassword.setBounds(113, 11, 312, 49);
		panel.add(lblChangePassword);
		lblChangePassword.setForeground(Color.WHITE);
		lblChangePassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblChangePassword.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblPasswordsNoMatch.setVisible(false);
		lblInvalidPassword.setVisible(false);
		lblPasswordSuccessfullyChanged.setVisible(false);
		
		JLabel lblBackground = new JLabel("");
		lblBackground.setIcon(new ImageIcon(ChangePW.class.getResource("/blue.jpg")));
		lblBackground.setBounds(0, 0, 784, 411);
		contentPaneChangePW.add(lblBackground);
	}
}