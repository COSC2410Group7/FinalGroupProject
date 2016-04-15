import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Menu extends ATM{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel contentPaneMenu;
	public Menu() {
		setTitle("Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 800, 450);
		contentPaneMenu = new JPanel();
		contentPaneMenu.setBorder(new EmptyBorder(0,0,0,0));
		setContentPane(contentPaneMenu);
		contentPaneMenu.setLayout(null);
		
		JLabel lblGreeting = new JLabel("Welcome, "+accountInfo[2]+" "+accountInfo[1]+"!");
		lblGreeting.setForeground(Color.WHITE);
		lblGreeting.setHorizontalAlignment(SwingConstants.CENTER);
		lblGreeting.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblGreeting.setBounds(125, 11, 534, 49);
		contentPaneMenu.add(lblGreeting);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 99, 147));
		panel.setBounds(204, 92, 387, 310);
		contentPaneMenu.add(panel);
		panel.setLayout(null);
		
		JButton btnBalance = new JButton("Balance");
		btnBalance.setBounds(25, 22, 162, 82);
		panel.add(btnBalance);
		btnBalance.setForeground(Color.WHITE);
		btnBalance.setBackground(new Color(0, 51, 102));
		btnBalance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				login.panel.removeAll();
				login.panel.add(balance.contentPaneBalance);
				login.panel.revalidate();
				login.panel.repaint();
			}
		});
		btnBalance.setFont(new Font("Tahoma", Font.PLAIN, 30));
		
		JButton btnTransfer = new JButton("Transfer");
		btnTransfer.setBounds(204, 22, 162, 82);
		panel.add(btnTransfer);
		btnTransfer.setForeground(Color.WHITE);
		btnTransfer.setBackground(new Color(0, 51, 102));
		btnTransfer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login.panel.removeAll();
				login.panel.add(transfer.contentPaneTransfer);
				login.panel.revalidate();
				login.panel.repaint();
			}
		});
		btnTransfer.setFont(new Font("Tahoma", Font.PLAIN, 30));
		
		JButton btnDeposit = new JButton("Deposit");
		btnDeposit.setBounds(25, 115, 162, 82);
		panel.add(btnDeposit);
		btnDeposit.setForeground(Color.WHITE);
		btnDeposit.setBackground(new Color(0, 51, 102));
		btnDeposit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login.panel.removeAll();
				login.panel.add(deposit.contentPaneDeposit);
				login.panel.revalidate();
				login.panel.repaint();
			}
		});
		btnDeposit.setFont(new Font("Tahoma", Font.PLAIN, 30));
		
		JButton btnWithdraw = new JButton("Withdraw");
		btnWithdraw.setBounds(204, 115, 162, 82);
		panel.add(btnWithdraw);
		btnWithdraw.setBackground(new Color(0, 51, 102));
		btnWithdraw.setForeground(Color.WHITE);
		btnWithdraw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login.panel.removeAll();
				login.panel.add(withdraw.contentPaneWithdraw);
				login.panel.revalidate();
				login.panel.repaint();
			}
		});
		btnWithdraw.setFont(new Font("Tahoma", Font.PLAIN, 30));
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setBounds(204, 210, 162, 82);
		panel.add(btnLogout);
		btnLogout.setForeground(Color.WHITE);
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login.panel.removeAll();
				login.panel.add(login.contentPaneLogin);
				login.panel.revalidate();
				login.panel.repaint();
			}
		});
		btnLogout.setBackground(new Color(255, 0, 51));
		btnLogout.setFont(new Font("Tahoma", Font.PLAIN, 30));
		
		JButton btnChangePW = new JButton("<html>&nbsp;Change</br> Password </html>");
		btnChangePW.setBounds(25, 210, 162, 82);
		panel.add(btnChangePW);
		btnChangePW.setVerticalAlignment(SwingConstants.TOP);
		btnChangePW.setForeground(Color.WHITE);
		btnChangePW.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login.panel.removeAll();
				login.panel.add(changePW.contentPaneChangePW);
				login.panel.revalidate();
				login.panel.repaint();
			}
		});
		btnChangePW.setBackground(new Color(255, 204, 0));
		btnChangePW.setFont(new Font("Tahoma", Font.PLAIN, 30));
		
		JLabel lblBackground = new JLabel("");
		lblBackground.setIcon(new ImageIcon("C:\\Users\\Drew\\Desktop\\workspace\\ATM-GroupProject\\img\\blue.jpg"));
		lblBackground.setBounds(0, 0, 784, 411);
		contentPaneMenu.add(lblBackground);
	}
}
