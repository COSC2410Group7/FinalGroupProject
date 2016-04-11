import java.lang.String;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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

public class Deposit extends ATM {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel contentPaneDeposit;
	private JTextField textField;
	private JLabel lblConfirmation;
	private JLabel lblInvalidInput;
	
	public Deposit() {
		setTitle("Deposit");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 800, 450);
		contentPaneDeposit = new JPanel();
		contentPaneDeposit.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPaneDeposit);
		contentPaneDeposit.setLayout(null);
		
		JLabel lblWithdraw = new JLabel("Deposit");
		lblWithdraw.setHorizontalAlignment(SwingConstants.CENTER);
		lblWithdraw.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblWithdraw.setBounds(210, 27, 380, 49);
		contentPaneDeposit.add(lblWithdraw);
		
		JLabel lblSign = new JLabel("$");
		lblSign.setHorizontalAlignment(SwingConstants.CENTER);
		lblSign.setFont(new Font("Tahoma", Font.PLAIN, 50));
		lblSign.setBounds(215, 160, 43, 59);
		contentPaneDeposit.add(lblSign);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 50));
		textField.setBounds(268, 160, 322, 59);
		contentPaneDeposit.add(textField);
		textField.setColumns(10);
		
		JButton btnDeposit = new JButton("Deposit");
		btnDeposit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!(textField.getText()==null)||!(Integer.parseInt(textField.getText())<0)){
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
		btnDeposit.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnDeposit.setBackground(new Color(51, 204, 0));
		btnDeposit.setBounds(10, 333, 197, 67);
		contentPaneDeposit.add(btnDeposit);
		
		JButton btnReturn = new JButton("Return");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				login.panel.removeAll();
				login.panel.add(menu.contentPaneMenu);
				login.panel.revalidate();
				login.panel.repaint();
			}
		});
		btnReturn.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnReturn.setBackground(new Color(255, 0, 51));
		btnReturn.setBounds(612, 333, 162, 67);
		contentPaneDeposit.add(btnReturn);
		
		lblConfirmation = new JLabel("Deposit complete.");
		lblConfirmation.setForeground(new Color(0, 204, 0));
		lblConfirmation.setHorizontalAlignment(SwingConstants.CENTER);
		lblConfirmation.setFont(new Font("Tahoma", Font.PLAIN, 60));
		lblConfirmation.setBounds(150, 241, 500, 67);
		contentPaneDeposit.add(lblConfirmation);
		lblConfirmation.setVisible(false);
		
		lblInvalidInput = new JLabel("Invalid Input");
		lblInvalidInput.setForeground(new Color(255, 0, 51));
		lblInvalidInput.setHorizontalAlignment(SwingConstants.CENTER);
		lblInvalidInput.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblInvalidInput.setBounds(215, 333, 375, 67);
		contentPaneDeposit.add(lblInvalidInput);
		lblInvalidInput.setVisible(false);
	}
}
