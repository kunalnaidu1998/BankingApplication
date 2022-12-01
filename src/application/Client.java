package application;

public class Client {
	
	private String firstName = "";
	private String lastName = "";
	
	private String username = "";
	private String password = "";
	
	private SavingsAccount savingsAccount;
	private CheckingAccount checkingAccounts;

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
	
	
	public Client(String firstName, String lastName, String username, String password) {
		setFirstName(firstName);
		setLastName(lastName);
		setUsername(username);
		setPassword(password);
		// create savings account
		checkingAccounts = new CheckingAccount(0.0);
		
	}
}
