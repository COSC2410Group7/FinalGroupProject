import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Menu extends ATM {

	private static final long serialVersionUID = 1L;
	JPanel contentPaneMenu;

	public Menu() {

		contentPaneMenu = new JPanel();
		setContentPane(contentPaneMenu);
		contentPaneMenu.setLayout(null);

		JLabel lblGreeting = new JLabel("Welcome, " + accountInfo[2] + " " + accountInfo[1] + "!");
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

				changePanel(balance.contentPaneBalance);
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

				changePanel(transfer.contentPaneTransfer);
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

				changePanel(deposit.contentPaneDeposit);
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

				changePanel(withdraw.contentPaneWithdraw);
			}
		});
		btnWithdraw.setFont(new Font("Tahoma", Font.PLAIN, 30));

		JButton btnLogout = new JButton("Logout");
		btnLogout.setBounds(204, 210, 162, 82);
		panel.add(btnLogout);
		btnLogout.setForeground(Color.WHITE);
		btnLogout.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				changePanel(login.contentPaneLogin);
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

				changePanel(changePW.contentPaneChangePW);
			}
		});
		btnChangePW.setBackground(new Color(255, 204, 0));
		btnChangePW.setFont(new Font("Tahoma", Font.PLAIN, 30));

		JLabel lblBackground = new JLabel("");
		lblBackground.setIcon(new ImageIcon(Menu.class.getResource("/blue.jpg")));
		lblBackground.setBounds(0, 0, 784, 411);
		contentPaneMenu.add(lblBackground);
	}

	public void changePanel(JPanel newPanel)	{

		login.CardLayout.removeAll();
		login.CardLayout.add(newPanel);
		login.CardLayout.revalidate();
		login.CardLayout.repaint();
	}
}
