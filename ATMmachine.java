package First_JDBC_Program;

import java.lang.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class ATMmachine {
	
	
	
	private static void getPreviousTransactionDetails() 
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/atm";
			String username = "root";
			String password = "root";
			Connection con = DriverManager.getConnection(url, username, password);
			 Statement st=con.createStatement();
			   ResultSet rs=st.executeQuery("select * from atmmachine");

			   System.out.println("Transaction History");
			   while(rs.next())
			   {
				   System.out.print(" "+rs.getFloat(4));
				   System.out.print("\n");
			   }

		} catch (Exception e) {
			System.out.print("Wrong in getPreviousTransactionDetails() method :msg " + e.getMessage());
		}


		
	}
	

	private static void maintainTransaction(float balance) 
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/atm";
			String username = "root";
			String password = "root";
			Connection con = DriverManager.getConnection(url, username, password);
			String uname="pundgaurav";
		   
		
		   System.out.print("Balance :"+balance);
			String update="insert into atmmachine(transaction) values(?);";
			PreparedStatement ps = con.prepareStatement(update);
			ps.setFloat(1, balance);
			 int f = ps.executeUpdate();
	            if (f==1) {
	                    System.out.println("amount set successfuly");

	            } else 
	            {
	                System.out.println("Something went wrong!\nServer side issue!");
	            }
	

		} catch (Exception e) {
			System.out.print("Wrong in maintainTransaction() method :msg " + e.getMessage());
		}
		
		
	}
	
	
	private static void depositMoney(float addMoney) 
	{
		float b=addMoney;
		if(addMoney>0)
		{
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			
				String url = "jdbc:mysql://localhost:3306/atm";
				String username = "root";
				String password = "root";
				Connection con = DriverManager.getConnection(url, username, password);
				String uname="pundgaurav";
			
				
				String update="update atmmachine set balance=? where username='pundgaurav';";
				PreparedStatement ps = con.prepareStatement(update);
				  
				addMoney=checkBalance()+addMoney;
				 ps.setFloat(1, addMoney);
				 int f = ps.executeUpdate();
		            if (f==1) {
		            	maintainTransaction(b);
		                    System.out.println("Amount Deposited Seccussfully...\nPlease Collect Your Receipt and come again...");

		            } else {
		                System.out.println("Something went wrong!\nServer side issue!");
		            }
		

			} catch (Exception e) {
				System.out.print("Wrong in depositMoney() method :msg " + e.getMessage());
			}
		}
		else
		{
			System.err.println("\nYou can't Deposit Zero or Negative Amount Of Money Such as "+addMoney);
		}
		
		
		
	}
	
	
	private static void withdrawMoney(float rs) 
	{
		if(rs<=checkBalance())
		{
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			
				String url = "jdbc:mysql://localhost:3306/atm";
				String username = "root";
				String password = "root";
				Connection con = DriverManager.getConnection(url, username, password);
				String uname="pundgaurav";
			
				
				String update="update atmmachine set balance=? where username='pundgaurav';";
				PreparedStatement ps = con.prepareStatement(update);
			
				rs=checkBalance()-rs;
				 ps.setFloat(1, rs);
				 int f = ps.executeUpdate();
		            if (f==1) {
		                    System.out.println("Amount Withdraw Seccussfully...\nPlease Collect Your Money and come again...");

		            } else {
		                System.out.println("Something went wrong!\nServer side issue!");
		            }
		

			} catch (Exception e) {
				System.out.print("Wrong in withdrawMoney() method :msg " + e.getMessage());
			}
			
		}
		else
		{
			System.err.println("Your Remaing Balance is "+checkBalance()+". You Can't Withdraw More than that. e.g. "+rs);
		}
		
	}

	private static float checkBalance() {
		float balance = 0;
	
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		
			String url = "jdbc:mysql://localhost:3306/atm";
			String username = "root";
			String password = "root";
			Connection con = DriverManager.getConnection(url, username, password);
		
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from atmmachine");

			while (rs.next()) {
				balance = rs.getFloat(3);
				

			}

		} catch (Exception e) {
			System.out.print("Wrong in checkBalance() method :msg " + e.getMessage());
		}
		
		return balance;

	}

	private static boolean checkUsernameAndPass(String arr[]) {
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/atm", "root", "root");

			Statement st = con.createStatement();

			ResultSet rs = st.executeQuery("select * from atmmachine");

			while (rs.next()) {
				if ((rs.getString(1).equals(arr[0])) && (rs.getString(2).equals(arr[1]))) {
					return true;

				}

			}

			con.close();

		} catch (Exception e) {
			System.out.print("wrong in usernameAndPassword() method :msg-" + e.getMessage());
		}
		return false;
	}

	private static void acceptUserAndPassword(String arr[]) {

		Scanner sc = new Scanner(System.in);
		System.out.print("Enter user name :");
		arr[0] = sc.next().trim();
		System.out.print("Enter password  :");
		arr[1] = sc.next().trim();

	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		float rs = 0;
		String[] arr = new String[2];
		acceptUserAndPassword(arr);

		boolean flag = checkUsernameAndPass(arr);
		if (flag) {
			System.out.println("**********ATM MACHINE APPLICATION*********");
			System.out.println("Press 1 to - Check Balance ");
			System.out.println("Press 2 to -Withdraw Money ");
			System.out.println("Press 3 to -Deposit Money ");
			System.out.println("Press 4 to -Display Previous All Transaction");
			System.out.println("Press 5 to -Exit");
			System.out.print("Enter your choice :");
			int ch = s.nextInt();

			switch (ch) {
			case 1 : System.out.print("Available Balance =" + checkBalance());
				     break;
			case 2 : System.out.print("How many amount you want to withdraw :");
				     rs=s.nextFloat();
				     withdrawMoney(rs);
				     break;
			case 3 : System.out.print("How many ruppes you want to Deposit :");
					 rs=s.nextFloat();
					 depositMoney(rs);
					 break;
			case 4 : getPreviousTransactionDetails();
			         break;
			case 5 : System.exit(0);
			default : System.err.print("Please Enter correct number.");
			}
		} else {
			
			System.err.println("Wrong UserName and Password ");
			System.err.println("Suppose!!!!");
			System.err.println("First of all go to near bank Opean your account then bank give you username and password...");
		}

	}


	


	

	

	

}
