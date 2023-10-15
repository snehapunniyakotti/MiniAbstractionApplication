
abstract class BankApi //<------------------------------------  Service Specifier
{
	//data member
	String name,branch,ifsc;
	boolean is_acc_exists=false;

	//const
	BankApi(){
		//L.I
	}

	BankApi(String name,String branch,String ifsc){
		//L.I
		this.name=name;
		this.branch=branch;
		this.ifsc=ifsc;
	}

	//abstract methods
	abstract boolean createAccount();
	abstract boolean deleteAccount();
	abstract public void deposite(double d);
	abstract public void withdraw(double d);
}

class CityBank extends BankApi //<------------------------------Service Provider
{
	//data member
	String acc_holder_name;
	double bal;

	//const
	CityBank(){
		super();
		//L.I
	}

	CityBank(String achn,String name,String branch,String ifsc){
		super(name,branch,ifsc);
		//L.I
		acc_holder_name=achn;
	}

	// abstract methods override
	@Override
		public boolean createAccount(){
	        //non-static context
			if (is_acc_exists){
				//when acc already exists
				return false;
			}else{
		    is_acc_exists=true;
			return is_acc_exists;
			}
	   }

	@Override
		public boolean deleteAccount(){
		    //non-static context
			if (is_acc_exists){
				// if acc exists then delete
				return true;
			}else{
		    return false;
			}
	   }
	@Override
		public void deposite(double d){
		    // checking for account is present 
		    if(is_acc_exists){
				// Account Exists
				bal+=d;
				System.out.println("\t\t\tDeposite Succesfully completed");
			}else
				//Account Not Exists
			    System.out.println("\t\t\tWe can't Deposite Because there is no Account");
	   }
	@Override
		public void withdraw(double w){
			//checking for account
			if (is_acc_exists){
				//Account Exists (Eligible for withdraw)
				if (bal>=w){
					//Sufficient bal is there to withdraw
					bal-=w;
					System.out.println("Withdraw Done Successfully");
				}else{
					//Insufficient Balance
					System.out.println("\t\t\tInSufficient Balance");
				}
			}else{
				//Account Not Exists(Not Eligible for Withdraw)
				System.out.println("\t\t\tWe can't withdraw because their is no Account");
			}
		}
		public void detailsOfAcc(){
			if (is_acc_exists){
				System.out.println("Bank Name :"+name);
				System.out.println("Branch :"+branch);
				System.out.println("IFSC :"+ifsc);
				System.out.println("Account Holder Name :"+acc_holder_name);
				System.out.println("Account Balance :"+bal);
				System.out.println("****************************************");
			}else
				System.out.println("\t\t\t No Account Exists to Show Details");
		}
}

//*******************************************************************************************************************************************

//End User file is saved as User Abstraction folder