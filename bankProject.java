
import java.sql.*;
import java.util.Random;
import java.util.Scanner;

public class bankProject
{
	public static void main(String args[])
	{
	   Connection co = null;
	   Statement st = null;
		try
		{

		Class.forName("com.mysql.jdbc.Driver");

		co=DriverManager.getConnection("jdbc:mysql://localhost:3306/PROJECT1",
                "root", "root");

		//co is the object name for making a connection between sql and java


		st = co.createStatement();

		//Statement object on which operations like insert and update can be performed

		String sql ="Create table SBI" +
                "(cust_id INTEGER, " +
                " cust_name VARCHAR(100), " +
                " cust_email VARCHAR(100), " +
                " cust_amount INTEGER, " +
                "cust_dob DATE, " +
                "cust_doj DATE," +
                " PRIMARY KEY ( cust_id ))";

	st.executeUpdate(sql);


		//table created


		boolean key=true;  //variable to manage the exiting of the program

	while(key)

		{

		System.out.println("CHOOSE ONE OF THE OPTIONS BELOW");
		System.out.println("\n1.OPEN AN ACCOUNT IN THE BANK");
		System.out.println("\n2.DEPOSIT MONEY IN YOUR ACCOUNT");
		System.out.println("\n3.WITHDRAW MONEY FROM THE ACCOUNT");
		System.out.println("\n4.CHECK BALANCE");
		System.out.println("\n5.TRANSFER MONEY");
		System.out.println("\n6.DELETE ACCOUNT");
		System.out.println("\nPRESS 0 FOR EXIT");

		Scanner sc = new Scanner(System.in);
		int x=sc.nextInt();


		ResultSet rs=st.executeQuery("Select * from SBI");   //ResultSet variables help to perform Select operations on the table
		ResultSet rs1=null;

		switch (x)
		{
		case 0:
			key=false;
			break;

		case 1:

			//code to open an account in the bank
			sc.nextLine();
			System.out.println("ENTER Your Name");
			String name=sc.nextLine();
			System.out.println("ENTER Your DOB in (yy-mm-dd)");
			String date=sc.nextLine();
			System.out.println("Enter Your Email");
			String email=sc.nextLine();
			System.out.println("ENTER THE AMOUNT TO BE DEPOSITED");
			int amt=sc.nextInt();
			Random rn=new Random();
			int id=rn.nextInt(10000);
			Date d= new Date(System.currentTimeMillis());

			if(amt<1800)
			{
				System.out.println("LOW BALANCE ,DEPOSIT MORE THAN 1800 RUPEES");
				System.out.println("Enter amount");
				amt=sc.nextInt();
				//condition of minimum deposition
			}
			else if(amt>10000)
			{
				System.out.println("AMOUNT TOO LARGE, DEPOSIT LESS THAN 10,000 RUPEES");
				System.out.println("Enter amount");
				amt=sc.nextInt();
				//condition of maximum deposition
			}


			 st.executeUpdate("insert into SBI values('"+id+"' ,'"+name+"','"+email+"','"+amt+"','"+date+"','"+d+"')");

	         // now record inserted (of Insert Record JDBC Keyboard Input

			 System.out.println(name + " record inerted"+ " your account number is "+ id);

			 //record inserted statement
	         break;

		case 2:

			//code to deposit money in your account
			System.out.println("ENTER THE MONEY TO BE DEPOSITED");
			int deposit=sc.nextInt();
			System.out.println("ENTER YOUR BANK ACCOUNT NUMBER");
			int i=sc.nextInt();
			while(rs.next())
			{
				int identity =rs.getInt("cust_id");
				if(identity==i)
				{
					int money = rs.getInt("cust_amount");
					money=money+deposit;


				 st.executeUpdate("Update SBI set cust_amount='"+money+"' where cust_id='"+identity+"'");
				 break;
			    }
			}

			break;

		case 3:

			//code to withdraw money from your account

			System.out.println("ENTER THE MONEY TO BE WITHDRAWN");
			int withdraw=sc.nextInt();
			System.out.println("ENTER YOUR BANK ACCOUNT NUMBER");
			i=sc.nextInt();
			while(rs.next())
			{
				int identity =rs.getInt("cust_id");
				if(identity==i)
				{
					int money = rs.getInt("cust_amount");
					if(money<withdraw)
					{
						System.out.println("Not enough MOney");
						break;
					}
					else
					money=money-withdraw;


					st.executeUpdate("Update SBI set cust_amount='"+money+"' where cust_id='"+identity+"'");
					break;
			    }
			}

			break;


		case 4:

			//code to generate account balance
			System.out.println("ENTER YOUR BANK ACCOUNT NUMBER");
			i=sc.nextInt();
			while(rs.next())
			{
				int identity =rs.getInt("cust_id");
				if(identity==i)
				{   int money=rs.getInt("cust_amount");
					System.out.println(money);
				 break;
			    }
			}

			break;


		case 5:

			//code to transfer money
			System.out.println("ENTER THE MONEY TO BE DEPOSITED");
			int amount=sc.nextInt();
			System.out.println("ENTER YOUR BANK ACCOUNT NUMBER");
			int sender_acc=sc.nextInt();
			System.out.println("ENTER THE BANK AMOUNT THE MONEY HAS TO BE TRANSFERRED");
			int transfer_acc=sc.nextInt();

			int receiver_money = 0;
			int money = 0;


			rs=st.executeQuery("Select * from SBI where cust_id='"+sender_acc+"'");

			if(rs.next() )
			{

					money = rs.getInt("cust_amount");
					if(amount<money)
					{
						money=money-amount;
					    st.executeUpdate("Update SBI set cust_amount='"+money+"' where cust_id='"+sender_acc+"'");
					}
					else
						System.out.println("Insufficient Balance");



			}
			rs.close();




			rs1=st.executeQuery("Select * from SBI where cust_id='"+transfer_acc+"'");

			if(rs1.next())
			{

					receiver_money = rs1.getInt("cust_amount");
					receiver_money=receiver_money+amount;
					st.executeUpdate("Update SBI set cust_amount='"+receiver_money+"' where cust_id='"+transfer_acc+"'");

			}

			rs1.close();
			st.close();


		default:
			System.out.println("INVALID INPUT");
			break;
		}

	}





		co.close();
		}

		catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		      System.out.println("ERROR!");
		   }catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		      System.out.println("ERROR 2");
		   }

	}
}
