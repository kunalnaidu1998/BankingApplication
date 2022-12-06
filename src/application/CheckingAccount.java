package application;

public class CheckingAccount extends BankAccount {
	

	public CheckingAccount(Double balance) {
		super(balance);
	
	}	
	public CheckingAccount(CheckingAccount toCopy) {
		super(toCopy.getBalance());
	}
		

}
