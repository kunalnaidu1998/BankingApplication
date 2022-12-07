package application;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class SignUpController{
	
	Stage applicationStage;
	
	private HashMap<String, Client> clientData = new HashMap<String, Client>();

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
    /**
     *  on button press creates new user
     * @param event
     */
    void SignUpButton(ActionEvent event) {
    	// get information from sign up
    	String firstName = newFirstNameTextField.getText();
    	String lastName = newLastNameTextField.getText();
    	String username = newUsernameTextField.getText();
    	String password = newPasswordTextField.getText();
    	
    	// if client doesn't exist
    	if (!getClientData().containsKey(username)) {
    		
    		// create client
    		Client tempClient = new Client(firstName, lastName, username, password);
    		addClient(username, tempClient);
        	
    		// go back to log in view
    		try {
    			
    			FXMLLoader loader = new FXMLLoader();
    			VBox root = loader.load(new FileInputStream("src/application/LoginView.fxml"));
    			
    			LoginController LoginController = loader.getController();
    			LoginController.setClientData(getClientData());

    			applicationStage = (Stage)((Node)event.getSource()).getScene().getWindow();
    			Scene LoginScene = new Scene(root, 400, 250);
    			applicationStage.setScene(LoginScene);
    			applicationStage.setTitle("Banking Application - Login");
    			
    		} catch (IOException e) {
    			e.printStackTrace();
    		}

    	} else {
    		String error = "This username already exists";
    		signUpErrorLabel.setText(error);
    	}
    }
    
    /**
     * sets Client Data
     * 
     * @param newClientData : client list
     */
    public void setClientData(HashMap<String, Client> newClientData){
    	HashMap<String, Client> clientDataCopy = new HashMap<String, Client>(newClientData);
    	clientData = clientDataCopy;
    }
    
    /**
     * returns client data
     * @return : client list
     */
    public HashMap<String, Client> getClientData(){
    	return new HashMap<String, Client>(clientData);
    }
    
    /**
     * adds a client to the list of clients
     * 
     * @param username : username of the new client
     * @param newClient : client object of the new client
     * @return
     */
    public void addClient(String username, Client newClient){
    	HashMap<String, Client> clientDataCopy = getClientData();
    	clientDataCopy.put(username, newClient);
    	setClientData(clientDataCopy);
    }

}

