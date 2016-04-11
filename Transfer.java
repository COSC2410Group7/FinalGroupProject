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

public class Transfer extends ATM {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel contentPaneTransfer;
	private JTextField textFieldNumber;
	private JTextField textFieldAmount;
	private JLabel lblTransferComplete;
	private JLabel lblInsufficientFunds;
	public Transfer() {
		setTitle("Transfer");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 800, 450);
		contentPaneTransfer = new JPanel();
		contentPaneTransfer.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPaneTransfer);
		contentPaneTransfer.setLayout(null);
		
		JLabel lblTransfer = new JLabel("Transfer");
		lblTransfer.setHorizontalAlignment(SwingConstants.CENTER);
		lblTransfer.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblTransfer.setBounds(210, 25, 380, 49);
		contentPaneTransfer.add(lblTransfer);
		
		JLabel lblToAccountNumber = new JLabel("To Account Number:");
		lblToAccountNumber.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblToAccountNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblToAccountNumber.setBounds(53, 107, 316, 67);
		contentPaneTransfer.add(lblToAccountNumber);
		
		textFieldNumber = new JTextField();
		textFieldNumber.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldNumber.setFont(new Font("Tahoma", Font.PLAIN, 50));
		textFieldNumber.setBounds(382, 107, 316, 67);
		contentPaneTransfer.add(textFieldNumber);
		textFieldNumber.setColumns(10);
		
		JLabel lblAmount = new JLabel("Amount:");
		lblAmount.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblAmount.setHorizontalAlignment(SwingConstants.CENTER);
		lblAmount.setBounds(219, 185, 150, 67);
		contentPaneTransfer.add(lblAmount);
		
		textFieldAmount = new JTextField();
		textFieldAmount.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldAmount.setFont(new Font("Tahoma", Font.PLAIN, 50));
		textFieldAmount.setColumns(10);
		textFieldAmount.setBounds(382, 185, 316, 67);
		contentPaneTransfer.add(textFieldAmount);
		
		JButton btnTransfer = new JButton("Transfer");
		btnTransfer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		});
		btnTransfer.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnTransfer.setBackground(new Color(51, 204, 0));
		btnTransfer.setBounds(10, 333, 197, 67);
		contentPaneTransfer.add(btnTransfer);
		
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
		contentPaneTransfer.add(btnReturn);
		
		lblTransferComplete = new JLabel("Transfer Complete.");
		lblTransferComplete.setForeground(new Color(0, 204, 0));
		lblTransferComplete.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblTransferComplete.setHorizontalAlignment(SwingConstants.CENTER);
		lblTransferComplete.setBounds(210, 263, 380, 57);
		contentPaneTransfer.add(lblTransferComplete);
		lblTransferComplete.setVisible(false);
		
		lblInsufficientFunds = new JLabel("Insufficient funds.");
		lblInsufficientFunds.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblInsufficientFunds.setHorizontalAlignment(SwingConstants.CENTER);
		lblInsufficientFunds.setForeground(new Color(255, 0, 0));
		lblInsufficientFunds.setBounds(219, 333, 371, 67);
		contentPaneTransfer.add(lblInsufficientFunds);
		lblInsufficientFunds.setVisible(false);
	}

}
