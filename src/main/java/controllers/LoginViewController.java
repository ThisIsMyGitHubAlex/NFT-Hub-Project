package controllers;

import business.BusinessException;
import business.NftHubFactory;
import business.UserService;
import domain.User;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import start.DataInitializable;
import viewManagement.ViewDispatcher;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class LoginViewController implements DataInitializable<User>, Initializable {

    private UserService userService;

    private ViewDispatcher dispatcher;

    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField passwordTextField;
    @FXML
    private Label errorLabel;
    @FXML
    private Button loginButton;
    @FXML
    private Button signUpButton;

    public LoginViewController() {
        NftHubFactory factory = NftHubFactory.getInstance();
        userService = factory.getUserService();
        dispatcher = ViewDispatcher.getInstance();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        loginButton.disableProperty().bind(
                usernameTextField.textProperty().isEmpty().or(passwordTextField.textProperty().isEmpty()));
        signUpButton.disableProperty().bind(
                usernameTextField.textProperty().isEmpty().or(passwordTextField.textProperty().isEmpty()));
    }


    public void loginAction() throws BusinessException, IOException {
        User user = userService.authenticate(usernameTextField.getText(), passwordTextField.getText());
        if (user != null)
            dispatcher.loggedIn(user);
        else errorLabel.setText("Wrong Username or Password");
    }

    public void RegistrationAction() throws IOException {
        String username = usernameTextField.getText();
        String password = passwordTextField.getText();
        userService.signUp(username, password);

    }


}
