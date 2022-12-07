package application;

public class BankAccount {

	private Double balance = 0.0;
	
	/**
	 * Initialize BankAccount
	 * @param startBalance : starting balance of account
	 */
	public BankAccount(Double startBalance){
		setBalance(startBalance);
	}
	/**
	 * get balance of bank account
	 * @return : balance of account
	 */
	public Double getBalance() {
		return balance;
	}

	/**
	 * set balance of bank account
	 * @param balance new balance of account
	 */
	public void setBalance(Double balance) {
		this.balance = balance;
	}

	/**
	 * adds money to balance
	 * @param money: value to be added to balance
	 */
	public void deposit(Double money) {
		balance += money;
	}

	/**
	 * withdraws money from balance
	 * @param money : amount of money to be reduced from account 
	 * @throws InvalidBalanceException : makes sure that balance is valid
	 */
	public void withdraw(Double money) throws InvalidBalanceException {
		if (allowedWithdraw(money)) {
			balance -= money;
		}		
	}

	/**
	 * calculates the allowed withdraw value
	 * @param money : value to be withdrawn
	 * @return : boolean of if the withdraw is allowed
	 * @throws InvalidBalanceException : throws if withdraw isnt allowed
	 */
	public boolean allowedWithdraw(Double money) throws InvalidBalanceException {
		// make sure balance is bigger than 0
		if (getBalance() >= money) {
			return true;
			
		} else {
			throw new InvalidBalanceException();
		}
	}

}
