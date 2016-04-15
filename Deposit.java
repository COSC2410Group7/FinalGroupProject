import java.lang.String;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
public class Deposit extends ATM {
	private static final long serialVersionUID = 1L;
	JPanel contentPaneDeposit;
	private JTextField textField;
	private JLabel lblConfirmation;
	private JLabel lblInvalidInput;
	
	public Deposit() throws NumberFormatException {
		contentPaneDeposit = new JPanel();
		setContentPane(contentPaneDeposit);
		contentPaneDeposit.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 99, 147));
		panel.setBounds(151, 63, 482, 285);
		contentPaneDeposit.add(panel);
		panel.setLayout(null);
		
		JLabel lblWithdraw = new JLabel("Deposit");
		lblWithdraw.setForeground(Color.WHITE);
		lblWithdraw.setBounds(164, 11, 154, 49);
		panel.add(lblWithdraw);
		lblWithdraw.setHorizontalAlignment(SwingConstants.CENTER);
		lblWithdraw.setFont(new Font("Tahoma", Font.PLAIN, 40));
		
		lblConfirmation = new JLabel("Deposit complete.");
		lblConfirmation.setBounds(153, 153, 175, 27);
		panel.add(lblConfirmation);
		lblConfirmation.setForeground(new Color(0, 204, 0));
		lblConfirmation.setHorizontalAlignment(SwingConstants.CENTER);
		lblConfirmation.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		lblInvalidInput = new JLabel("Invalid Input");
		lblInvalidInput.setBounds(178, 152, 123, 27);
		panel.add(lblInvalidInput);
		lblInvalidInput.setForeground(new Color(255, 0, 51));
		lblInvalidInput.setHorizontalAlignment(SwingConstants.CENTER);
		lblInvalidInput.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JButton btnDeposit = new JButton("Deposit");
		btnDeposit.setForeground(Color.WHITE);
		btnDeposit.setBounds(57, 183, 171, 75);
		panel.add(btnDeposit);
		btnDeposit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int Input = 0;
				try{
					Input = Integer.parseInt(textField.getText());
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
				}
				if (!(textField.getText()==null)&&Input>0){
					int userDeposit = Integer.parseInt(textField.getText());
					int balance = Integer.parseInt(accountInfo[3]);
					balance+=userDeposit;
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
					lblConfirmation.setVisible(true);
					ActionListener erase = new ActionListener() {
						public void actionPerformed(ActionEvent e){
							lblConfirmation.setVisible(false);
						}
					};
					Timer error = new Timer(1000,erase);
					error.start();
					error.setRepeats(false);
				}
				else{
					lblInvalidInput.setVisible(true);
					ActionListener erase = new ActionListener() {
						public void actionPerformed(ActionEvent e){
							lblInvalidInput.setVisible(false);
						}
					};
					Timer error = new Timer(1000,erase);
					error.start();
					error.setRepeats(false);
				}
				textField.setText("");
			}
		});
		btnDeposit.setFont(new Font("Tahoma", Font.PLAIN, 35));
		btnDeposit.setBackground(new Color(51, 204, 0));
		
		JButton btnReturn = new JButton("Return");
		btnReturn.setForeground(Color.WHITE);
		btnReturn.setBounds(253, 184, 171, 75);
		panel.add(btnReturn);
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField.setText("");
				login.panel.removeAll();
				login.panel.add(menu.contentPaneMenu);
				login.panel.revalidate();
				login.panel.repaint();
			}
		});
		btnReturn.setFont(new Font("Tahoma", Font.PLAIN, 35));
		btnReturn.setBackground(new Color(255, 0, 51));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 51, 102));
		panel_1.setBounds(29, 80, 430, 73);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblSign = new JLabel("$");
		lblSign.setBounds(120, 18, 16, 37);
		panel_1.add(lblSign);
		lblSign.setForeground(Color.WHITE);
		lblSign.setHorizontalAlignment(SwingConstants.CENTER);
		lblSign.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.LEFT);
		textField.setBounds(136, 20, 270, 33);
		panel_1.add(textField);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 22));
		textField.setColumns(10);
		
		JLabel lblDepositAmount = new JLabel("Amount: ");
		lblDepositAmount.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblDepositAmount.setForeground(Color.WHITE);
		lblDepositAmount.setBounds(10, 22, 89, 28);
		panel_1.add(lblDepositAmount);
		lblInvalidInput.setVisible(false);
		lblConfirmation.setVisible(false);
		
		JLabel lblBackground = new JLabel("");
		lblBackground.setIcon(new ImageIcon(Deposit.class.getResource("/blue.jpg")));
		lblBackground.setBounds(0, 0, 784, 411);
		contentPaneDeposit.add(lblBackground);
	}
}