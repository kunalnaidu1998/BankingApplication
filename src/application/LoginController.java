package application;

import java.util.HashMap;
import java.util.Map;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController{
	
	private Map<String, Client> clientData = new HashMap<String, Client>();

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField usernameTextField;

    @FXML
    private Hyperlink signUpHyperLink;
    
    @FXML
    private Label errorLabel;

    @FXML
    /**
     * 
     * @param event
     */
    void logInButton(ActionEvent event) {
    	String user = usernameTextField.getText();
    	String password = passwordField.getText();
    	
    	if (clientData.containsKey(user)) {
    		if (clientData.get(user).getPassword() == password) {
 
    		} else {
    			String error = "Incorrect Password";
    			errorLabel.setText(error);
    		}
    	} else {
    		String error = "Username does not exist";
    		errorLabel.setText(error);
    	}
    	
    	
    }
    

    @FXML
    /**
     * 
     * @param event
     */
    void signUpHyperLink(ActionEvent event) {
    	
    }
}
