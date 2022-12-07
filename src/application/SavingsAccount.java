package application;

public class SavingsAccount extends BankAccount {
	
	private Double minimumBalance = 100.0;
	
	private Double getMinimumBalance() {
		return minimumBalance;
	}
	private void setMinimumBalance(Double minimumBalance) {
		this.minimumBalance = minimumBalance;
	}
	public SavingsAccount(Double newBalance) {
		super(newBalance);
		
	}
	public SavingsAccount(Double newBalance, Double newMinimum) {
		super(newBalance);
		setMinimumBalance(newMinimum);
	}
	
	public SavingsAccount(SavingsAccount toCopy) {
		super(toCopy.getBalance());
	}
	
	/**
	 * 
	 */
	public boolean allowedWithdraw(Double money) throws InvalidBalanceException {
		if (getBalance() - getMinimumBalance() >= money) {
			return true;
			
		} else {
			throw new InvalidBalanceException();
		}
	}
}
