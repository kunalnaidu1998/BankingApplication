package application;

public class BankAccount {

	private Double balance = 0.0;

	public BankAccount(Double startBalance){
		setBalance(startBalance);
	}
	
	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public void deposit(Double money) {
		balance += money;
	}

	public void withdraw(Double money) {
		try {
			if (allowedWithdraw(money)) {
				balance -= money;
			}		
		} catch (InvalidBalanceException ibe) {
		
		}	
	}

	public boolean allowedWithdraw(Double money) throws InvalidBalanceException {
		if (getBalance() >= money) {
			throw new InvalidBalanceException();
		} else {
			return true;
		}
	}

}
