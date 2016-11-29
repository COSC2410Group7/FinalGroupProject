import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JFrame;

public class ATM extends JFrame{

	public ATM() { }

	private static final long serialVersionUID = 1L;
	static String accountInfo[];
	static String accountPW[];
	static char[] Password;
	public static Balance balance;
	public static ChangePW changePW;
	public static Deposit deposit;
	public static Login login;
	public static Menu menu;
	public static Transfer transfer;
	public static Withdraw withdraw;

	public static void main(String[] args)throws FileNotFoundException {

		accountInfo = new String[5];
		Scanner readFile = new Scanner(new FileInputStream("AccountInformation.txt"));
		for(int i=0;i<5;i++)
			accountInfo[i]=readFile.nextLine();
		accountPW = new String[2];
		readFile.close();

		readFile = new Scanner(new FileInputStream("Password.txt"));
		for (int i=0;i<2;i++)
			accountPW[i] = readFile.next();
		Password = accountPW[1].toCharArray();
		readFile.close();

		balance = new Balance();
		changePW = new ChangePW();
		deposit = new Deposit();
		login = new Login();
		menu = new Menu();
		transfer = new Transfer();
		withdraw = new Withdraw();
	}
}
