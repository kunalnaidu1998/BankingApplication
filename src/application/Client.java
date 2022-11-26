package application;

public class Client {
	
	private String firstName = "";
	private String lastName = "";
	
	private String username = "";
	private String password = "";

	public String getFirstName() {
		return new String(firstName);
	}
	public void setFirstName(String firstName) {
		this.firstName = new String(firstName);
	}
	public String getLastName() {
		return new String(lastName);
	}
	public void setLastName(String lastName) {
		this.lastName = new String(lastName);
	}
	public String getUsername() {
		return new String(username);
	}
	public void setUsername(String username) {
		this.username = new String(username);
	}
	public String getPassword() {
		return new String(password);
	}
	public void setPassword(String password) {
		this.password = new String(password);
	}
	
	public Client(String firstName, String lastName, String username, String password) {
		setFirstName(firstName);
		setLastName(lastName);
		setUsername(username);
		setPassword(password);

	}
}
