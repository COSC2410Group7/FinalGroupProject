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
		
		JLabel lblChoose = new JLabel("What would you like to do?");
		lblChoose.setForeground(Color.WHITE);
		lblChoose.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblChoose.setHorizontalAlignment(SwingConstants.CENTER);
		lblChoose.setBounds(202, 78, 380, 37);
		contentPaneMenu.add(lblChoose);
		
		JButton btnBalance = new JButton("Balance");
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
		btnBalance.setBounds(222, 126, 162, 82);
		contentPaneMenu.add(btnBalance);
		
		JButton btnTransfer = new JButton("Transfer");
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
		btnTransfer.setBounds(402, 126, 162, 82);
		contentPaneMenu.add(btnTransfer);
		
		JButton btnDeposit = new JButton("Deposit");
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
		btnDeposit.setBounds(220, 219, 162, 82);
		contentPaneMenu.add(btnDeposit);
		
		JButton btnWithdraw = new JButton("Withdraw");
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
		btnWithdraw.setBounds(402, 219, 162, 82);
		contentPaneMenu.add(btnWithdraw);
		
		JButton btnChangePW = new JButton("<html>&nbsp;Change</br> Password </html>");
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
		btnChangePW.setBounds(222, 312, 162, 82);
		contentPaneMenu.add(btnChangePW);
		
		JButton btnLogout = new JButton("Logout");
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
		btnLogout.setBounds(402, 312, 162, 82);
		contentPaneMenu.add(btnLogout);
		
		JLabel lblGreeting = new JLabel("Hello "+accountInfo[2]+" "+accountInfo[1]+",");
		lblGreeting.setForeground(Color.WHITE);
		lblGreeting.setHorizontalAlignment(SwingConstants.CENTER);
		lblGreeting.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblGreeting.setBounds(50, 11, 700, 56);
		contentPaneMenu.add(lblGreeting);
		
		JLabel lblBackground = new JLabel("");
		lblBackground.setIcon(new ImageIcon("img\\blue.jpg"));
		lblBackground.setBounds(0, 0, 784, 411);
		contentPaneMenu.add(lblBackground);
	}
}
