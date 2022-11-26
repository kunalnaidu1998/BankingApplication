package application;

public class BankAccount extends Client {

	private Double balance = 0.0;

	public BankAccount(String firstName, String lastName, String username, String password) {
		super(firstName, lastName, username, password);
		
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
