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
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
public class Transfer extends ATM {
	private static final long serialVersionUID = 1L;
	JPanel contentPaneTransfer;
	private JTextField textFieldNumber;
	private JTextField textFieldAmount;
	private JLabel lblTransferComplete;
	private JLabel lblInsufficientFunds;
	private JLabel lblInvalidInput;
	public Transfer() {
		contentPaneTransfer = new JPanel();
		setContentPane(contentPaneTransfer);
		contentPaneTransfer.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(0, 99, 147));
		panel.setBounds(151, 63, 482, 285);
		contentPaneTransfer.add(panel);
		
		JLabel lblTransfer = new JLabel("Transfer");
		lblTransfer.setForeground(Color.WHITE);
		lblTransfer.setBounds(156, 11, 169, 49);
		panel.add(lblTransfer);
		lblTransfer.setHorizontalAlignment(SwingConstants.CENTER);
		lblTransfer.setFont(new Font("Tahoma", Font.PLAIN, 40));
		
		lblInvalidInput = new JLabel("Invalid Input");
		lblInvalidInput.setBounds(139, 163, 204, 28);
		panel.add(lblInvalidInput);
		lblInvalidInput.setForeground(new Color(255, 0, 51));
		lblInvalidInput.setHorizontalAlignment(SwingConstants.CENTER);
		lblInvalidInput.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblInvalidInput.setVisible(false);
		
		lblTransferComplete = new JLabel("Transfer Complete.");
		lblTransferComplete.setBounds(139, 163, 204, 28);
		panel.add(lblTransferComplete);
		lblTransferComplete.setForeground(new Color(0, 204, 0));
		lblTransferComplete.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblTransferComplete.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton btnTransfer = new JButton("Transfer");
		btnTransfer.setForeground(Color.WHITE);
		btnTransfer.setBounds(67, 192, 162, 71);
		panel.add(btnTransfer);
		btnTransfer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					int userTransfer = Integer.parseInt(textFieldAmount.getText());
					int balance = Integer.parseInt(accountInfo[3]);
					balance-=userTransfer;
					if(balance>0){
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
						lblTransferComplete.setVisible(true);
						ActionListener erase = new ActionListener() {
							public void actionPerformed(ActionEvent e){
								lblTransferComplete.setVisible(false);
							}
						};
						Timer error = new Timer(1000,erase);
						error.start();
						error.setRepeats(false);
						textFieldAmount.setText("");
						textFieldNumber.setText("");
					}
					else{
						balance+=userTransfer;
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
					textFieldAmount.setText("");
					textFieldNumber.setText("");
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
				
			}
		});
		btnTransfer.setFont(new Font("Tahoma", Font.PLAIN, 33));
		btnTransfer.setBackground(new Color(51, 204, 0));
		
		JButton btnReturn = new JButton("Return");
		btnReturn.setForeground(Color.WHITE);
		btnReturn.setBounds(256, 192, 162, 71);
		panel.add(btnReturn);
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				login.panel.removeAll();
				login.panel.add(menu.contentPaneMenu);
				login.panel.revalidate();
				login.panel.repaint();
			}
		});
		btnReturn.setFont(new Font("Tahoma", Font.PLAIN, 35));
		btnReturn.setBackground(new Color(255, 0, 51));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0,51,102));
		panel_1.setBounds(22, 74, 437, 87);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		textFieldNumber = new JTextField();
		textFieldNumber.setBounds(235, 10, 192, 28);
		panel_1.add(textFieldNumber);
		textFieldNumber.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldNumber.setFont(new Font("Tahoma", Font.PLAIN, 22));
		textFieldNumber.setColumns(10);
		
		JLabel label = new JLabel("$");
		label.setFont(new Font("Tahoma", Font.PLAIN, 22));
		label.setForeground(Color.WHITE);
		label.setBounds(220, 10, 21, 28);
		panel_1.add(label);
		
		JLabel lblAmount = new JLabel("Amount:");
		lblAmount.setBounds(127, 48, 82, 27);
		panel_1.add(lblAmount);
		lblAmount.setForeground(Color.WHITE);
		lblAmount.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblAmount.setHorizontalAlignment(SwingConstants.CENTER);
		
		textFieldAmount = new JTextField();
		textFieldAmount.setBounds(234, 47, 193, 28);
		panel_1.add(textFieldAmount);
		textFieldAmount.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldAmount.setFont(new Font("Tahoma", Font.PLAIN, 22));
		textFieldAmount.setColumns(10);
		
		JLabel lblToAccountNumber = new JLabel("To Account Number:");
		lblToAccountNumber.setBounds(10, 11, 200, 27);
		panel_1.add(lblToAccountNumber);
		lblToAccountNumber.setForeground(Color.WHITE);
		lblToAccountNumber.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblToAccountNumber.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel label_1 = new JLabel("$");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		label_1.setBounds(220, 47, 21, 28);
		panel_1.add(label_1);
		panel_1.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{textFieldNumber, textFieldAmount, label, lblAmount, lblToAccountNumber, label_1}));
		
		lblInsufficientFunds = new JLabel("Insufficient funds.");
		lblInsufficientFunds.setBounds(151, 163, 180, 29);
		panel.add(lblInsufficientFunds);
		lblInsufficientFunds.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblInsufficientFunds.setHorizontalAlignment(SwingConstants.CENTER);
		lblInsufficientFunds.setForeground(new Color(255, 0, 0));
		lblInsufficientFunds.setVisible(false);
		lblTransferComplete.setVisible(false);
		
		JLabel lblBackground = new JLabel("");
		lblBackground.setIcon(new ImageIcon(Transfer.class.getResource("/blue.jpg")));
		lblBackground.setBounds(0, 0, 784, 411);
		contentPaneTransfer.add(lblBackground);
		panel.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{textFieldNumber, textFieldAmount, btnTransfer, btnReturn, lblTransfer, lblInvalidInput, lblTransferComplete, panel_1, label, lblAmount, lblToAccountNumber, label_1, lblInsufficientFunds}));
		contentPaneTransfer.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{textFieldNumber, textFieldAmount, btnTransfer, btnReturn, panel, lblTransfer, lblInvalidInput, lblTransferComplete, panel_1, label, lblAmount, lblToAccountNumber, label_1, lblInsufficientFunds, lblBackground}));
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{textFieldNumber, textFieldAmount, btnTransfer, btnReturn, contentPaneTransfer, panel, lblTransfer, lblInvalidInput, lblTransferComplete, panel_1, label, lblAmount, lblToAccountNumber, label_1, lblInsufficientFunds, lblBackground}));
	}
}