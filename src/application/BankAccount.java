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

	public void withdraw(Double money) throws InvalidBalanceException {
		if (allowedWithdraw(money)) {
			balance -= money;
		}		
	}

	public boolean allowedWithdraw(Double money) throws InvalidBalanceException {
		if (getBalance() >= money) {
			return true;
			
		} else {
			throw new InvalidBalanceException();
		}
	}

}
