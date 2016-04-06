import java.awt.EventQueue;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() {
				try {
					ATM frame = new ATM();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		Scanner inputStream = null; 
		try{           
			inputStream = new Scanner(new FileInputStream("txt/Password.txt")); 
		}
		catch (FileNotFoundException e){ 
			System.out.println("File password.txt was not found"); 
			System.out.println("or could not be opened."); 
			System.exit(0);         
			} 
		int accnum = inputStream.nextInt( ); 
		String pass= inputStream.next();
		System.out.println("The two inputs read from the file are:"); 
		System.out.println(accnum + " "+ pass );         
		inputStream.close( ); 
	}
}
