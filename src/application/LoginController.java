package application;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LoginController{

	Stage applicationStage;
	
	private Map<String, Client> clientData = new HashMap<String, Client>();
	

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField usernameTextField;

    @FXML
    private Hyperlink signUpHyperLink;
    
    @FXML
    private Label errorLabel;
    
    protected Map<String, Client> getClientData(){
    	return new  HashMap<String, Client>(clientData);
    }
    
    /**
     * adds a client to the list of clients
     * 
     * @param username : username of the new client
     * @param newClient : client object of the new client
     * @return
     */
    protected Map<String, Client> addClient(String username, Client newClient){
    	Map<String, Client> newClientData =  getClientData();
    	newClientData.put(username, newClient);
    	return newClientData;
    }

    @FXML
    /**
     * on log in button press log into client account
     * @param event
     */
    void logInButton(ActionEvent event) {
    	String user = usernameTextField.getText();
    	String password = passwordField.getText();
    	
    	// check if user exist and password is correct
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
     * sets up sign up screen on button press
     *  
     * @param event
     */
    void signUpHyperLink(ActionEvent event) {
    	
		try {
			
			FXMLLoader loader = new FXMLLoader();
			VBox root = loader.load(new FileInputStream("src/application/SignUpView.fxml"));
			Scene signUpScene = new Scene(root, 400, 400);
			applicationStage.setScene(signUpScene);
			applicationStage.setTitle("Banking Application - Sign up");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    }
}

