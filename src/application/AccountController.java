package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class AccountController {
	
	Stage applicationStage;
	
	private Client user;
	
    @FXML
    private Label checkingBalanceLabel;
	
	@FXML
	private Label savingsBalanceLabel;

    @FXML
    private Label nameTextField;

    @FXML
    void withdrawMenuItem(ActionEvent event) {

    }

    @FXML
    void DepositMenuItem(ActionEvent event) {

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
		updateCheckingBalance(getUser().getCheckingAccounts().getBalance());
		updateSavingsBalance(getUser().getSavingsAccount().getBalance());
		
	}
	
	public void updateCheckingBalance(Double value) {
		checkingBalanceLabel.setText("$" + value);
	}
	
	public void updateSavingsBalance(Double value) {
		savingsBalanceLabel.setText("$" + value);
	}
}

