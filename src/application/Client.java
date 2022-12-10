package application;

public class Client {
	
	private String firstName = "";
	private String lastName = "";
	
	private String username = "";
	private String password = "";
	
	private SavingsAccount savingsAccount;
	private CheckingAccount checkingAccount;

	/**
	 * gets a copy of checking account
	 * @return instance of checking account
	 */
	public CheckingAccount getCheckingAccount() {
		return new CheckingAccount(checkingAccount);
	}
	
	/**
	 * set checking account
	 * @param checkingAccounts
	 */
	public void setCheckingAccount(CheckingAccount newCheckingAccount) {
		this.checkingAccount = new CheckingAccount(newCheckingAccount);
	}
	/**
	 * gets instance of savings acccount
	 * @return instance of savings account
	 */
	public SavingsAccount getSavingsAccount() {
		return new SavingsAccount(savingsAccount);
	}

	/**
	 * sets saving account
	 * @param savingsAccount
	 */
	public void setSavingsAccount(SavingsAccount savingsAccount) {
		this.savingsAccount = new SavingsAccount(savingsAccount);
	}

	/**
	 * gets first name of client
	 * @return first name as a string
	 */
	public String getFirstName() {
		return new String(firstName);
	}
	
	/**
	 * sets first name of client
	 * @param firstName : first name of client
	 */
	public void setFirstName(String firstName) {
		this.firstName = new String(firstName);
	}
	
	/**
	 * gets last name of client
	 * @return last name as a string
	 */
	public String getLastName() {
		return new String(lastName);
	}
	
	/**
	 * sets last name name of client
	 * @param lastName : last name of client
	 */
	public void setLastName(String lastName) {
		this.lastName = new String(lastName);
	}
	
	/**
	 * gets username of client
	 * @return username as string
	 */
	public String getUsername() {
		return new String(username);
	}
	
	/**
	 * sets username of client
	 * @param username username of client
	 */
	public void setUsername(String username) {
		this.username = new String(username);
	}
	
	/**
	 * sets password of client
	 * @return password as a string
	 */
	public String getPassword() {
		return new String(password);
	}
	
	/**
	 * sets password of client
	 * @param password password as a string
	 */
	public void setPassword(String password) {
		this.password = new String(password);
	}
	
	/**
	 * Initialize Client
	 * 
	 * @param firstName : first name of client
	 * @param lastName : last name of client
	 * @param username : username of client
	 * @param password : password of client
	 */
	public Client(String firstName, String lastName, String username, String password) {
		setFirstName(firstName);
		setLastName(lastName);
		setUsername(username);
		setPassword(password);

		// create checking and savings account account
		setCheckingAccount(new CheckingAccount(0.0));
		setSavingsAccount(new SavingsAccount(0.0));
		
	}
	/**
	 * Creates copy of Client
	 * @param toCopy : client to copy
	 */
	public Client(Client toCopy) {
		setFirstName(toCopy.getFirstName());
		setLastName(toCopy.getLastName());
		setUsername(toCopy.getUsername());
		setPassword(toCopy.getPassword());

		// create checking and savings account account
		setCheckingAccount(toCopy.getCheckingAccount());
		setSavingsAccount(toCopy.getSavingsAccount());
	}
	
	/**
	 * deposits amount to clients checking account
	 * @param amount : amount to deposit
	 * @throws InvalidAmountException  : makes sure amount is positive
	 */
	public void depositCheckingAccount(Double amount) throws InvalidAmountException {
		CheckingAccount account = getCheckingAccount();
		account.deposit(amount);
		setCheckingAccount(account);
	}
	
	/**
	 * withdraws money from clients checking account
	 * @param amount : amount of money to be withdrawn
	 * @throws InvalidBalanceException : makes sure balance is valid after withdraw
	 * @throws InvalidAmountException : makes sure amount is positive
	 */
	public void withdrawCheckingAccount(Double amount) throws InvalidBalanceException, InvalidAmountException {
		CheckingAccount account = getCheckingAccount();
		account.withdraw(amount);
		setCheckingAccount(account);
	}
	
	/**
	 * deposits money to clients savings account
	 * @param amount : amount of money to be deposited
	 * @throws InvalidAmountException  : makes sure amount positive
	 */
	public void depositSavingsAccount(Double amount) throws InvalidAmountException {
		SavingsAccount account = getSavingsAccount();
		account.deposit(amount);
		setSavingsAccount(account);
	}
	
	/**
	 * withdraws money from clients saving account
	 * @param amount : amount of money to be withdrawn
	 * @throws InvalidBalanceException : makes sure balance is valid after withdraw
	 * @throws InvalidAmountException : makes sure amount is positive
	 */
	public void withdrawSavingsAccount(Double amount) throws InvalidBalanceException, InvalidAmountException {
		SavingsAccount account = getSavingsAccount();
		account.withdraw(amount);
		setSavingsAccount(account);
	}

}
