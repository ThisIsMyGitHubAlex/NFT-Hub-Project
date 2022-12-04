package controllers;

import business.NftHubFactory;
import business.UserService;
import domain.User;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import start.DataInitializable;
import viewManagement.ViewDispatcher;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;


public class ManageUserViewController implements Initializable, DataInitializable<User> {

    private UserService userService;
    private ViewDispatcher dispatcher;
    private User user;

    @FXML
    private Label titleLabel;
    @FXML
    private Label operationResultLabel;
    @FXML
    private TextField usernameField;
    @FXML
    private TextField passwordField;


    public ManageUserViewController() {
        dispatcher = ViewDispatcher.getInstance();
        NftHubFactory factory = NftHubFactory.getInstance();
        userService = factory.getUserService();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {


    }

    @Override
    public void initializeData(User user) {
        this.user = user;
        usernameField.setPromptText(user.getUsername());
        // method for not showing the password but only the "*"
        StringBuffer passPrivacy = new StringBuffer();
        for (int i = 0; i < user.getPassword().length(); i++)
            passPrivacy.append("*");

        passwordField.setPromptText(passPrivacy.toString());
    }


    // TODO resolve the problem of... passing the admin?, is this really solved?
    public void goBack() {
        dispatcher.renderView("userlist-view", new User());
    }

    public void resetUsername() {
        try {
            if (userService.resetUsername(usernameField.getText(), user.getUsername())) {
                operationResultLabel.setText("Username Resetted");
                user.setUsername(usernameField.getText());
            } else
                operationResultLabel.setText("This Username is invalid or already exist ");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void resetPassword() {
        try {
            if (userService.resetPassword(passwordField.getText(), user.getUsername())) {
                user.setPassword(passwordField.getText());
                operationResultLabel.setText("Password Resetted");
            } else
                operationResultLabel.setText("Operation Failed");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
