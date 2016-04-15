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
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;

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
		
		JButton btnShowBalance = new JButton("<html>&nbsp; &nbsp; &nbsp; Show </br>&nbsp; &nbsp; &nbsp; Balance </html>");
		btnShowBalance.setHorizontalTextPosition(SwingConstants.CENTER);
		btnShowBalance.setVerticalAlignment(SwingConstants.TOP);
		btnShowBalance.setForeground(Color.WHITE);
		btnShowBalance.setBounds(51, 185, 182, 74);
		panel.add(btnShowBalance);
		btnShowBalance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(accountInfo[3]);
			}
		});
		btnShowBalance.setFont(new Font("Tahoma", Font.PLAIN, 26));
		btnShowBalance.setBackground(Color.GREEN);
		
		JButton btnReturn = new JButton("Return");
		btnReturn.setForeground(Color.WHITE);
		btnReturn.setBounds(249, 184, 182, 74);
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
		btnReturn.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnReturn.setBackground(new Color(255, 0, 51));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 51, 102));
		panel_1.setBounds(61, 82, 360, 74);
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
		
		JLabel lblAmount = new JLabel(accountInfo[3]);
		lblAmount.setBounds(153, 5, 186, 28);
		panel_1.add(lblAmount);
		lblAmount.setForeground(Color.WHITE);
		lblAmount.setHorizontalAlignment(SwingConstants.LEFT);
		lblAmount.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		textField = new JTextField();
		textField.setBounds(153, 36, 186, 28);
		panel_1.add(textField);
		textField.setHorizontalAlignment(SwingConstants.LEFT);
		textField.setEditable(false);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textField.setColumns(10);
		panel.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{textField, btnShowBalance, btnReturn, lblBalance, panel_1, lblOriginalBalance, lblNew, lblSign, label, lblAmount}));
		
		JLabel lblBackground = new JLabel("");
		lblBackground.setIcon(new ImageIcon("img\\blue.jpg"));
		lblBackground.setBounds(0, 0, 784, 411);
		contentPaneBalance.add(lblBackground);
		contentPaneBalance.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{textField, btnShowBalance, btnReturn, panel, lblBalance, panel_1, lblOriginalBalance, lblNew, lblSign, label, lblAmount, lblBackground}));
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{textField, btnShowBalance, btnReturn, contentPaneBalance, panel, lblBalance, panel_1, lblOriginalBalance, lblNew, lblSign, label, lblAmount, lblBackground}));
	}
}
