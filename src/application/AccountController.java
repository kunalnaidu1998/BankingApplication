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
	private VBox transactionVBox;
	
    @FXML
    private Label checkingBalanceLabel;
	
	@FXML
	private Label savingsBalanceLabel;

    @FXML
    private Label nameTextField;

    @FXML
    void withdrawMenuItem(ActionEvent event) {
    	
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
    void DepositMenuItem(ActionEvent event) {
    	
    	transactionVBox.getChildren().clear();
    	
    	// setup withdraw 
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
    void TransferMenuItem(ActionEvent event) {

    }
    
    public void setUser(Client currentUser) {
    	user = new Client(currentUser);
    }

	public Client getUser() {
		return new Client(user);
	}
	
	public void initialize_screen() {
		nameTextField.setText(getUser().getFirstName());
		updateCheckingBalance();
		updateSavingsBalance();
		
	}
	
	public void updateCheckingBalance() {
		checkingBalanceLabel.setText("$" + getUser().getCheckingAccount().getBalance());
	}
	
	public void updateSavingsBalance() {
		savingsBalanceLabel.setText("$" + getUser().getSavingsAccount().getBalance());
	}
	
	
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

