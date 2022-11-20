package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController{

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField usernameTextField;

    @FXML
    private Hyperlink signUpHyperLink;

    @FXML
    /**
     * 
     * @param event
     */
    void logInButton(ActionEvent event) {
    	System.out.println("hi");
    }
    

    @FXML
    /**
     * 
     * @param event
     */
    void signUpHyperLink(ActionEvent event) {
    	System.out.println("hello");
    }
}

