package application;

public class CheckingAccount extends BankAccount {
	
	/**
	 * initializes Checking Account
	 * @param balance : initial balance of checking Account
	 */
	public CheckingAccount(Double balance) {
		super(balance);
	
	}	
	
	/**
	 * copies checking account 
	 * @param toCopy : checking account to be copied
	 */
	public CheckingAccount(CheckingAccount toCopy) {
		super(toCopy.getBalance());
	}
		

}
