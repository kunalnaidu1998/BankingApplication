package application;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LoginController{

	Stage applicationStage;
	
	private HashMap<String, Client> clientData = new HashMap<String, Client>();
	
    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField usernameTextField;

    @FXML
    private Hyperlink signUpHyperLink;
    
    @FXML
    private Label errorLabel;
    
    /**
     * gets client data
     * @return
     */
    public HashMap<String, Client> getClientData(){
    	HashMap<String, Client> clientDataCopy = new HashMap<String, Client>(clientData);
    	return clientDataCopy;
    }
    
    /**
     * sets client data
     * @param newClientData
     */
    public void setClientData(HashMap<String, Client> newClientData){
    	HashMap<String, Client> clientDataCopy = new HashMap<String, Client>(newClientData);
    	clientData = clientDataCopy;
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
    	if (getClientData().containsKey(user)) {
    		if (getClientData().get(user).getPassword().equals(password)) {
    			
    			try {
    				
    				FXMLLoader loader = new FXMLLoader();
    				
    				VBox root = loader.load(new FileInputStream("src/application/AccountView.fxml"));
    				AccountController accountController = loader.getController();
    				accountController.setUser(clientData.get(user));
    				accountController.initialize_screen();

    				applicationStage = (Stage)((Node)event.getSource()).getScene().getWindow();
    				Scene AccountScene = new Scene(root, 400, 400);
    				applicationStage.setScene(AccountScene);
    				applicationStage.setTitle("Banking Application - Account");
    				
    			} catch (IOException e) {
    				e.printStackTrace();
    			} 
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
			
			SignUpController signUpController = loader.getController();
			signUpController.setClientData(getClientData());

			applicationStage = (Stage)((Node)event.getSource()).getScene().getWindow();
			Scene signUpScene = new Scene(root, 400, 400);
			applicationStage.setScene(signUpScene);
			applicationStage.setTitle("Banking Application - SignUp");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    }
}

