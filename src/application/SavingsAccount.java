package application;

public class SavingsAccount extends BankAccount {
	
	private Double minimumBalance = 100.0;
	
	/**
	 * gets Minimum Balance of savings account
	 * @return : minimum balance of account
	 */
	public Double getMinimumBalance() {
		return minimumBalance;
	}
	
	/**
	 * sets minimum balance of savings account
	 * @param minimumBalance : value of minimum balance
	 */
	public void setMinimumBalance(Double minimumBalance) {
		this.minimumBalance = minimumBalance;
	}
	
	/**
	 * initializing Savings account
	 * @param newBalance : starting balance of savings account
	 */
	public SavingsAccount(Double newBalance) {
		super(newBalance);
		
	}
	
	/**
	 * initializing savings account 
	 * @param newBalance : starting balance of savings account
	 * @param newMinimum : setting minimum of savings account
	 */
	public SavingsAccount(Double newBalance, Double newMinimum) {
		super(newBalance);
		setMinimumBalance(newMinimum);
	}
	
	/**
	 * copying savings account
	 * @param toCopy : savings account to be copied
	 */
	public SavingsAccount(SavingsAccount toCopy) {
		super(toCopy.getBalance());
	}
	
	/**
	 * checks to see if withdraw can be allowed for savings account
	 */
	public boolean allowedWithdraw(Double money) throws InvalidBalanceException {
		// make sure balance is larger than minimum balance
		if (getBalance() - getMinimumBalance() >= money) {
			return true;
			
		} else {
			throw new InvalidBalanceException();
		}
	}
}
