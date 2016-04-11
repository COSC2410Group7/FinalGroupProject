import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Balance extends ATM {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel contentPaneBalance;
	private JTextField textField;
	public Balance() {
		setTitle("Balance");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 800, 450);
		contentPaneBalance = new JPanel();
		contentPaneBalance.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPaneBalance);
		contentPaneBalance.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0,99,147));
		panel.setBounds(151, 63, 482, 285);
		contentPaneBalance.add(panel);
		panel.setLayout(null);
		
		JLabel lblBalance = new JLabel("Balance");
		lblBalance.setForeground(Color.WHITE);
		lblBalance.setBounds(51, 11, 380, 49);
		panel.add(lblBalance);
		lblBalance.setHorizontalAlignment(SwingConstants.CENTER);
		lblBalance.setFont(new Font("Tahoma", Font.PLAIN, 40));
		
		JLabel lblAmount = new JLabel(accountInfo[3]);
		lblAmount.setForeground(Color.WHITE);
		lblAmount.setBounds(184, 81, 186, 28);
		panel.add(lblAmount);
		lblAmount.setHorizontalAlignment(SwingConstants.LEFT);
		lblAmount.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		JLabel lblSign = new JLabel("$");
		lblSign.setForeground(Color.WHITE);
		lblSign.setBounds(142, 66, 43, 59);
		panel.add(lblSign);
		lblSign.setHorizontalAlignment(SwingConstants.CENTER);
		lblSign.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		JLabel lblOriginalBalance = new JLabel("Original:");
		lblOriginalBalance.setForeground(Color.WHITE);
		lblOriginalBalance.setBounds(34, 71, 114, 49);
		panel.add(lblOriginalBalance);
		lblOriginalBalance.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblOriginalBalance.setHorizontalAlignment(SwingConstants.RIGHT);
		
		textField = new JTextField();
		textField.setBounds(184, 114, 186, 28);
		panel.add(textField);
		textField.setHorizontalAlignment(SwingConstants.LEFT);
		textField.setEditable(false);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textField.setColumns(10);
		
		JLabel label = new JLabel("$");
		label.setForeground(Color.WHITE);
		label.setBounds(142, 99, 43, 59);
		panel.add(label);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		JLabel lblNew = new JLabel("New:");
		lblNew.setForeground(Color.WHITE);
		lblNew.setBounds(-27, 104, 141, 49);
		panel.add(lblNew);
		lblNew.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNew.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		JButton btnShowBalance = new JButton("<html> Show </br> Balance </html>");
		btnShowBalance.setForeground(Color.WHITE);
		btnShowBalance.setBounds(142, 167, 202, 49);
		panel.add(btnShowBalance);
		btnShowBalance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(accountInfo[3]);
			}
		});
		btnShowBalance.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnShowBalance.setBackground(Color.GREEN);
		
		JButton btnReturn = new JButton("Return");
		btnReturn.setForeground(Color.WHITE);
		btnReturn.setBounds(183, 227, 119, 39);
		panel.add(btnReturn);
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				login.panel.removeAll();
				login.panel.add(menu.contentPaneMenu);
				login.panel.revalidate();
				login.panel.repaint();
			}
		});
		btnReturn.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnReturn.setBackground(new Color(255, 0, 51));
		
		JLabel lblBackground = new JLabel("");
		lblBackground.setIcon(new ImageIcon("C:\\Users\\Drew\\Desktop\\workspace\\ATM-GroupProject\\img\\blue.jpg"));
		lblBackground.setBounds(0, 0, 784, 411);
		contentPaneBalance.add(lblBackground);
	}
}
