package application;

import java.util.Map;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class SignUpController extends LoginController {

    @FXML
    private TextField newLastNameTextField;

    @FXML
    private TextField newFirstNameTextField;

    @FXML
    private TextField newUsernameTextField;

    @FXML
    private TextField newPasswordTextField;

    @FXML
    private Label signUpErrorLabel;

    @FXML
    void SignUpButton(ActionEvent event) {
    	String firstName = newFirstNameTextField.getText();
    	String lastName = newLastNameTextField.getText();
    	String username = newUsernameTextField.getText();
    	String password = newPasswordTextField.getText();
    	
    	Map<String, Client> clientData = super.getClientData();
    	if (!clientData.containsKey(username)) {
    		Client tempClient = new Client(firstName, lastName, username, password);
    		addClient(username, tempClient);

    	} else {
    		String error = "This username already exists";
    		signUpErrorLabel.setText(error);
    	}
    }
    

}

