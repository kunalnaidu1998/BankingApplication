package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class AccountController {
	
	Stage applicationStage;
	
	private Client user;
	
	@FXML
	private Label minimumSavingsBalance;
	
	@FXML
	private VBox transactionVBox;
	
    @FXML
    private Label checkingBalanceLabel;
	
	@FXML
	private Label savingsBalanceLabel;

    @FXML
    private Label nameLabel;

    @FXML
    /**
     * on click of withdraw set up withdraw VBox
     * 
     * @param event : on menu select
     */
    void withdrawMenuItem(ActionEvent event) {
    	
    	/*
    	 * how i learned to remove everything in a VBox
    	 * 
    	 * https://stackoverflow.com/questions/28925381/is-there-a-way-to-remove-all-the-contents-in-vbox-in-javafx
    	 * 
    	 */
    	transactionVBox.getChildren().clear();
    	
    	// setup withdraw 
    	HBox chooseAccountHBox = new HBox();
    	chooseAccountHBox.setPadding(new Insets(10,10,10,10));
    	
    	Label accountWithdrawLabel = new Label("Withdraw From:");
    	accountWithdrawLabel.setPadding(new Insets(5,10,0,10));
    	
    	ChoiceBox<String> chooseAccountChoiceBox = new ChoiceBox<String>();
    	chooseAccountChoiceBox.getItems().add("Checking Account");
    	chooseAccountChoiceBox.getItems().add("Savings Account");
    	
    	chooseAccountHBox.getChildren().addAll(accountWithdrawLabel, chooseAccountChoiceBox);
    	
    	HBox amountHbox = new HBox();
    	amountHbox.setPadding(new Insets(10,10,10,10));
    	
    	Label amountLabel = new Label("Amount:");
    	amountLabel.setPadding(new Insets(5,10,0,10));
    	
    	TextField amountTextfield = new TextField();

    	
    	amountHbox.getChildren().addAll(amountLabel, amountTextfield);
    	
    	Label invalidWithdrawLabel = new Label();
    	invalidWithdrawLabel.setPadding(new Insets(10,10,10,10));
    	invalidWithdrawLabel.setTextFill(Color.RED);
    	
    	VBox buttonVbox = new VBox();
    	VBox.setMargin(buttonVbox, new Insets(5,10,5,10));
    	
    	Button commitWithdraw = new Button("Withdraw");
    	
    	buttonVbox.getChildren().addAll(invalidWithdrawLabel, commitWithdraw);
    	
    	transactionVBox.getChildren().addAll(chooseAccountHBox, amountHbox, buttonVbox);
    	
    	// set button action
    	commitWithdraw.setOnAction(commitEvent -> {
			try {
				// reset error label
				invalidWithdrawLabel.setText("");

				withdrawDepositAction("Withdraw" , chooseAccountChoiceBox.getValue(), amountTextfield.getText());
			} catch (NumberFormatException e) {
				invalidWithdrawLabel.setText("Invalid Amount Entered");
				e.printStackTrace();
			} catch (NullPointerException e) {
				invalidWithdrawLabel.setText("Please Enter Amount");
				e.printStackTrace();
			} catch (InvalidBalanceException e) {
				invalidWithdrawLabel.setText("Insuffient Funds");
				e.printStackTrace();
			}
		});
	

    }
    

    @FXML
    /**
     * on click of deposit set up deposit VBox
     * 
     * @param event : on menu select
     */
    void depositMenuItem(ActionEvent event) {
    	
    	transactionVBox.getChildren().clear();
    	
    	// setup deposit
    	HBox chooseAccountHBox = new HBox();
    	chooseAccountHBox.setPadding(new Insets(10,10,10,10));
    	
    	Label accountDepositLabel = new Label("Deposit To:");
    	accountDepositLabel.setPadding(new Insets(5,10,0,10));
    	
    	ChoiceBox<String> chooseAccountChoiceBox = new ChoiceBox<String>();
    	chooseAccountChoiceBox.getItems().add("Checking Account");
    	chooseAccountChoiceBox.getItems().add("Savings Account");
    	
    	chooseAccountHBox.getChildren().addAll(accountDepositLabel, chooseAccountChoiceBox);
    	
    	HBox amountHbox = new HBox();
    	amountHbox.setPadding(new Insets(10,10,10,10));
    	
    	Label amountLabel = new Label("Amount:");
    	amountLabel.setPadding(new Insets(5,10,0,10));
    	
    	TextField amountTextfield = new TextField();

    	
    	amountHbox.getChildren().addAll(amountLabel, amountTextfield);
    	
    	Label invalidDepositLabel = new Label();
    	invalidDepositLabel.setPadding(new Insets(10,10,10,10));
    	invalidDepositLabel.setTextFill(Color.RED);
    	
    	VBox buttonVbox = new VBox();
    	VBox.setMargin(buttonVbox, new Insets(5,10,5,10));
    	
    	Button commitDeposit = new Button("Deposit");
    	
    	buttonVbox.getChildren().addAll(invalidDepositLabel, commitDeposit);
    	
    	transactionVBox.getChildren().addAll(chooseAccountHBox, amountHbox, buttonVbox);
    	
    	// set button action
    	commitDeposit.setOnAction(commitEvent -> {
			try {
				// reset error label
				invalidDepositLabel.setText("");
				
				withdrawDepositAction("Deposit" , chooseAccountChoiceBox.getValue(), amountTextfield.getText());
			} catch (NumberFormatException e) {
				invalidDepositLabel.setText("Invalid Amount Entered");
				e.printStackTrace();
			} catch (NullPointerException e) {
				invalidDepositLabel.setText("Please Enter Amount");
				e.printStackTrace();
			} catch (InvalidBalanceException e) {
				e.printStackTrace();
			}
		});
	

    }

    @FXML
    /**
     * 
     *  on click of deposit set up deposit VBox
     *  
     * @param event : on menu select
     */
    void transferMenuItem(ActionEvent event) {
    	transactionVBox.getChildren().clear();
    	
    	// setup transfer 
    	HBox accountChoosingHbox = new HBox();
    	accountChoosingHbox.setPadding(new Insets(10,10,10,10));
    	
    	Label fromAccountLabel = new Label("Transfer From:");
    	fromAccountLabel.setPadding(new Insets(5,10,0,10));
    	
    	ChoiceBox<String> fromAccountChoiceBox = new ChoiceBox<String>();
    	fromAccountChoiceBox.getItems().add("Checking Account");
    	fromAccountChoiceBox.getItems().add("Savings Account");
    	
    	
    	Label toAccountLabel = new Label("To:");
    	toAccountLabel.setPadding(new Insets(5,10,0,10));
    	
    	ChoiceBox<String> toAccountChoiceBox = new ChoiceBox<String>();
    	toAccountChoiceBox.getItems().add("Checking Account");
    	toAccountChoiceBox.getItems().add("Savings Account");
    	
    	accountChoosingHbox.getChildren().addAll(fromAccountLabel, fromAccountChoiceBox, toAccountLabel, toAccountChoiceBox);
    	
    	HBox amountHBox = new HBox();
    	amountHBox.setPadding(new Insets(10,10,10,10));
    	
    	Label amountLabel = new Label("Amount:");
    	amountLabel.setPadding(new Insets(5,10,5,10));
    	
    	TextField amountTextfield = new TextField();
    	
    	amountHBox.getChildren().addAll(amountLabel, amountTextfield);
    	
    	VBox buttonVBox = new VBox();
    	buttonVBox.setPadding(new Insets(10,10,10,10));
    	
    	Label transferErrorLabel = new Label();
    	transferErrorLabel.setPadding(new Insets(10,10,10,10));
    	transferErrorLabel.setTextFill(Color.RED);
    	
    	Button transferButton = new Button("Transfer");
    	
    	buttonVBox.getChildren().addAll(transferErrorLabel, transferButton);
    	
    	transactionVBox.getChildren().addAll(accountChoosingHbox, amountHBox, buttonVBox);
    	
    	
    	transferButton.setOnAction(commitEvent -> {
			try {
				// reset error label
				transferErrorLabel.setText("");
				transferAction(fromAccountChoiceBox.getValue(), toAccountChoiceBox.getValue(), amountTextfield.getText());
			} catch (NumberFormatException e) {
				transferErrorLabel.setText("Invalid Amount Entered");
				e.printStackTrace();
			} catch (NullPointerException e) {
				transferErrorLabel.setText("Please Enter Amount");
				e.printStackTrace();
			} catch (InvalidBalanceException e) {
				transferErrorLabel.setText("Insufficient Funds");
				e.printStackTrace();
			}
		});

    }
    
    /**
     * 
     * transfer money from one account to another account
     * 
     * @param fromAccount : account to transfer from
     * @param toAccount : account to transfer to
     * @param amount : amount to be transfered
     * @throws NumberFormatException : makes sure format of number is correct
     * @throws NullPointerException : makes sure input isnt empty
     * @throws InvalidBalanceException : makes sure balance are valid
     */
    public void transferAction(String fromAccount, String toAccount, String amount) throws NumberFormatException, NullPointerException, InvalidBalanceException {
    	
    	// transfer from checking account to savings account
    	if (fromAccount.equals("Checking Account")) {
    		if(toAccount.equals("Savings Account")) {
    			withdrawDepositAction("Withdraw", fromAccount, amount);
    			withdrawDepositAction("Deposit", toAccount, amount);
    		}
 
    	// transfer from savings account to checking account
    	} else if (fromAccount.equals("Savings Account")) {
    		if (toAccount.equals("Checking Account")) {
    			withdrawDepositAction("Withdraw", fromAccount, amount);
    			withdrawDepositAction("Deposit", toAccount, amount);
    		}
    	}
    }
    
    /**
     * 
     * sets the user
     * 
     * @param currentUser : user to be set
     */
    public void setUser(Client currentUser) {
    	user = new Client(currentUser);
    }

    /**
     * 
     * gets user
     * 
     * @return current client
     * 
     */
	public Client getUser() {
		return new Client(user);
	}
	
	/**
	 * start of Account View setup
	 */
	public void initialize_screen() {
		
		// setup Hello phrase
		nameLabel.setText(getUser().getFirstName());
		
		// set up balance values
		minimumSavingsBalance.setText("$" + String.valueOf(getUser().getSavingsAccount().getMinimumBalance()));
		updateCheckingBalance();
		updateSavingsBalance();
		
	}
	
	/**
	 * updates checking balance on account view
	 */
	public void updateCheckingBalance() {
		checkingBalanceLabel.setText("$" + getUser().getCheckingAccount().getBalance());
	}
	
	/**
	 * updates savings balance on account view
	 */
	public void updateSavingsBalance() {
		savingsBalanceLabel.setText("$" + getUser().getSavingsAccount().getBalance());
	}
	
	/**
	 * 
	 * withdraw or deposit a certain amount of money from clients checking and savings account
	 * 
	 * @param transactionType : either of withdraw or deposit
	 * @param account : Savings account or Checking Account
	 * @param amount : amount to be withdrawn or deposited
	 * @throws NullPointerException : makes sure empty string isnt inputted
	 * @throws NumberFormatException : makes sure that the number is formatted correctly
	 * @throws InvalidBalanceException : makes sure that balance is valid
	 */
    public void withdrawDepositAction(String transactionType, String account, String amount) throws NullPointerException, NumberFormatException, InvalidBalanceException {
    	// check if value is correct input
    	
    	Double doubleAmount = Double.parseDouble(amount);
    	Client user = getUser();
    	
    	// withdraw from account
    	if (transactionType.equals("Withdraw")){
    		
    		if (account.equals("Checking Account")) {
    			user.withdrawCheckingAccount(doubleAmount);
    			
    		} else if (account.equals("Savings Account")) {
    			user.withdrawSavingsAccount(doubleAmount);
    		}
    	
    	// deposit to account
    	} else if (transactionType.equals("Deposit")){
    		
    		if (account.equals("Checking Account")) {
    			user.depositCheckingAccount(doubleAmount);
    			
    		} else if (account.equals("Savings Account")) {
    			user.depositSavingsAccount(doubleAmount);
    		}
    	}
    	setUser(user);
    	updateCheckingBalance();
    	updateSavingsBalance();
    }
}

