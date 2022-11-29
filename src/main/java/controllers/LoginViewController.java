package controllers;

import business.BusinessException;
import business.NftHubFactory;
import business.UserService;
import domain.Guest;
import domain.User;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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

    public LoginViewController() {
        NftHubFactory factory = NftHubFactory.getInstance();
        userService = factory.getUserService();

        dispatcher = ViewDispatcher.getInstance();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    // @TODO OPTIMIZATION
    // Write the binding on the login button for no useless checks


    public void loginAction() throws BusinessException, IOException {
        User user = userService.authenticate(usernameTextField.getText(), passwordTextField.getText());
        if (user != null)
            dispatcher.loggedIn(user);
        else System.out.println("Wrong Username or Password");
    }

    public void RegistrationAction() throws IOException {
        String username = usernameTextField.getText();
        String password = passwordTextField.getText();
        userService.signUp(username, password);

    }


}
