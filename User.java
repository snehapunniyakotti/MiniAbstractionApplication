import java.util.*;
class User //<----------------------------------------------End User
{
	static Scanner sc=new Scanner(System.in);
	static CityBank city_bank=new CityBank("Tabrez","CityBank","Vadapalani","City0012");
	static boolean repeat_features=true;
	public static void main(String[] args){
		do
		{
			System.out.println("\t\t\tWelcome to City Bank");
			System.out.println("1.Create Account\n2.Delete Account\n3.Deposite\n4.Withdraw\n5.Details of Account\n6.Exit");
			int user_in=sc.nextInt();

			switch (user_in)
			{
			case 1:{//Create Account
				if (city_bank.createAccount())
					System.out.println("\t\t\tAccount Create Succesfully");
				else
					System.out.println("\t\t\tAccount Already Exists");
				break;}
			case 2:{// Delete Account
				if (city_bank.deleteAccount())
					System.out.println("\t\t\tAccount delete Succesfully");
				else
					System.out.println("\t\t\tNo Account to Delete");
				break;}
			case 3:{//Deposite
				System.out.println("\t\t\tEnter the Amount");
				city_bank.deposite(sc.nextDouble());
				break;}
			case 4:{//withdraw
				System.out.println("\t\t\tEnter the Amount");
				city_bank.withdraw(sc.nextDouble());
				break;}
			case 5:{//Details
				city_bank.detailsOfAcc();
				break;}
			case 6:{//Exit
				repeat_features=false;
				break;}
			}
		}
		while (repeat_features);
		System.out.println("\t\t\tThankYou!!!!!");
	}
}