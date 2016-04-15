import javax.swing.JPanel;
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
	private static final long serialVersionUID = 1L;
	JPanel contentPaneBalance;
	private JTextField textField;
	public Balance() {
		contentPaneBalance = new JPanel();
		setContentPane(contentPaneBalance);
		contentPaneBalance.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0,99,147));
		panel.setBounds(178, 71, 427, 269);
		contentPaneBalance.add(panel);
		panel.setLayout(null);
		
		JLabel lblBalance = new JLabel("Balance");
		lblBalance.setForeground(Color.WHITE);
		lblBalance.setBounds(145, 11, 136, 49);
		panel.add(lblBalance);
		lblBalance.setHorizontalAlignment(SwingConstants.CENTER);
		lblBalance.setFont(new Font("Tahoma", Font.PLAIN, 40));
		
		JButton btnShowBalance = new JButton("<html>&nbsp; &nbsp; &nbsp; Show </br>&nbsp; &nbsp; &nbsp; Balance </html>");
		btnShowBalance.setHorizontalTextPosition(SwingConstants.CENTER);
		btnShowBalance.setVerticalAlignment(SwingConstants.TOP);
		btnShowBalance.setForeground(Color.WHITE);
		btnShowBalance.setBounds(26, 173, 172, 74);
		panel.add(btnShowBalance);
		btnShowBalance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(accountInfo[3] + ".00");
			}
		});
		btnShowBalance.setFont(new Font("Tahoma", Font.PLAIN, 26));
		btnShowBalance.setBackground(Color.GREEN);
		
		JButton btnReturn = new JButton("Return");
		btnReturn.setForeground(Color.WHITE);
		btnReturn.setBounds(232, 173, 172, 74);
		panel.add(btnReturn);
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				login.CardLayout.removeAll();
				login.CardLayout.add(menu.contentPaneMenu);
				login.CardLayout.revalidate();
				login.CardLayout.repaint();
			}
		});
		btnReturn.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnReturn.setBackground(new Color(255, 0, 51));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 51, 102));
		panel_1.setBounds(24, 71, 380, 74);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblOriginalBalance = new JLabel("Original:");
		lblOriginalBalance.setBounds(0, -5, 114, 49);
		panel_1.add(lblOriginalBalance);
		lblOriginalBalance.setForeground(Color.WHITE);
		lblOriginalBalance.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblOriginalBalance.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblNew = new JLabel("New:");
		lblNew.setBounds(10, 30, 68, 40);
		panel_1.add(lblNew);
		lblNew.setForeground(Color.WHITE);
		lblNew.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNew.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		JLabel lblSign = new JLabel("$");
		lblSign.setBounds(115, -10, 43, 59);
		panel_1.add(lblSign);
		lblSign.setForeground(Color.WHITE);
		lblSign.setHorizontalAlignment(SwingConstants.CENTER);
		lblSign.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		JLabel label = new JLabel("$");
		label.setBounds(115, 36, 43, 31);
		panel_1.add(label);
		label.setForeground(Color.WHITE);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		JLabel lblAmount = new JLabel(accountInfo[3] + ".00");
		lblAmount.setBounds(153, 5, 217, 28);
		panel_1.add(lblAmount);
		lblAmount.setForeground(Color.WHITE);
		lblAmount.setHorizontalAlignment(SwingConstants.LEFT);
		lblAmount.setFont(new Font("Tahoma", Font.PLAIN, 22));
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(153, 36, 217, 28);
		panel_1.add(textField);
		textField.setHorizontalAlignment(SwingConstants.LEFT);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 22));
		textField.setColumns(10);
		
		JLabel lblBackground = new JLabel("");
		lblBackground.setIcon(new ImageIcon(Balance.class.getResource("/blue.jpg")));
		lblBackground.setBounds(0, 0, 784, 411);
		contentPaneBalance.add(lblBackground);
	}
}